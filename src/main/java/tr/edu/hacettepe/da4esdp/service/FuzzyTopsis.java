package tr.edu.hacettepe.da4esdp.service;

import org.apache.commons.math3.ml.distance.EuclideanDistance;
import org.apache.commons.math3.util.FastMath;
import tr.edu.hacettepe.da4esdp.entity.Alternative;
import tr.edu.hacettepe.da4esdp.entity.Criteria;
import tr.edu.hacettepe.da4esdp.entity.Fuzzy;
import tr.edu.hacettepe.da4esdp.entity.Weight;

import java.util.*;
import java.util.stream.IntStream;

public class FuzzyTopsis {

    private Map<String, Map<Alternative, List<Fuzzy>>> dmEvaluationsMap;
    private Map<String, Weight> criteriaWeightMap;
    private LinkedList<Criteria> criteriaList;
    private Map<Alternative, List<Double>> alternativeFDMMap;
    private Map<Alternative, List<Double>> alternativeNormalizedFDMMap;
    private List<Double> FPIS_A_star;
    private List<Double> FNIS_A_minus;
    private Map<String, Double> diStarMap;
    private Map<String, Double> diMinusMap;
    private Map<String, Double> alternativeClosenessCoefficientMap;

    public FuzzyTopsis() {
        initializeDataStructures();
    }

    private void initializeDataStructures() {
      alternativeFDMMap = new HashMap<>();
      alternativeNormalizedFDMMap = new HashMap<>();
      dmEvaluationsMap = new HashMap<>();
      FPIS_A_star = new ArrayList<>();
      FNIS_A_minus = new ArrayList<>();
      criteriaWeightMap = new LinkedHashMap<>();
      criteriaList = new LinkedList<>();
      diStarMap = new HashMap<>();
      diMinusMap = new HashMap<>();
      alternativeClosenessCoefficientMap = new TreeMap<>();

      Config.alternativeList.clear();
      Config.alternativeList.add(new Alternative("ANN"));
      Config.alternativeList.add(new Alternative("BBN"));
      Config.alternativeList.add(new Alternative("DT"));
      Config.alternativeList.add(new Alternative("FRBC"));
      Config.alternativeList.add(new Alternative("LinR"));
      Config.alternativeList.add(new Alternative("LogR"));
      Config.alternativeList.add(new Alternative("NB"));
      Config.alternativeList.add(new Alternative("SVM"));

      Config.dm1Evals.put(Config.alternativeList.get(0), Arrays.asList(Config.DM1_ALTERNATIVE_1_CAUSALITY, Config.DM1_ALTERNATIVE_1_UNCERTAINTY, Config.DM1_ALTERNATIVE_1_MISSING, Config.DM1_ALTERNATIVE_1_OUTLIER,
        Config.DM1_ALTERNATIVE_1_INTERPRETABILITY, Config.DM1_ALTERNATIVE_1_COMPLEXITY, Config.DM1_ALTERNATIVE_1_ACCURACY, Config.DM1_ALTERNATIVE_1_MAINTAINABILITY, Config.DM1_ALTERNATIVE_1_SPEED));
      Config.dm1Evals.put(Config.alternativeList.get(1), Arrays.asList(Config.DM1_ALTERNATIVE_2_CAUSALITY, Config.DM1_ALTERNATIVE_2_UNCERTAINTY, Config.DM1_ALTERNATIVE_2_MISSING, Config.DM1_ALTERNATIVE_2_OUTLIER,
        Config.DM1_ALTERNATIVE_2_INTERPRETABILITY, Config.DM1_ALTERNATIVE_2_COMPLEXITY, Config.DM1_ALTERNATIVE_2_ACCURACY, Config.DM1_ALTERNATIVE_2_MAINTAINABILITY, Config.DM1_ALTERNATIVE_2_SPEED));
      Config.dm1Evals.put(Config.alternativeList.get(2), Arrays.asList(Config.DM1_ALTERNATIVE_3_CAUSALITY, Config.DM1_ALTERNATIVE_3_UNCERTAINTY, Config.DM1_ALTERNATIVE_3_MISSING, Config.DM1_ALTERNATIVE_3_OUTLIER,
        Config.DM1_ALTERNATIVE_3_INTERPRETABILITY, Config.DM1_ALTERNATIVE_3_COMPLEXITY, Config.DM1_ALTERNATIVE_3_ACCURACY, Config.DM1_ALTERNATIVE_3_MAINTAINABILITY, Config.DM1_ALTERNATIVE_3_SPEED));
      Config.dm1Evals.put(Config.alternativeList.get(3), Arrays.asList(Config.DM1_ALTERNATIVE_4_CAUSALITY, Config.DM1_ALTERNATIVE_4_UNCERTAINTY, Config.DM1_ALTERNATIVE_4_MISSING, Config.DM1_ALTERNATIVE_4_OUTLIER,
        Config.DM1_ALTERNATIVE_4_INTERPRETABILITY, Config.DM1_ALTERNATIVE_4_COMPLEXITY, Config.DM1_ALTERNATIVE_4_ACCURACY, Config.DM1_ALTERNATIVE_4_MAINTAINABILITY, Config.DM1_ALTERNATIVE_4_SPEED));
      Config.dm1Evals.put(Config.alternativeList.get(4), Arrays.asList(Config.DM1_ALTERNATIVE_5_CAUSALITY, Config.DM1_ALTERNATIVE_5_UNCERTAINTY, Config.DM1_ALTERNATIVE_5_MISSING, Config.DM1_ALTERNATIVE_5_OUTLIER,
        Config.DM1_ALTERNATIVE_5_INTERPRETABILITY, Config.DM1_ALTERNATIVE_5_COMPLEXITY, Config.DM1_ALTERNATIVE_5_ACCURACY, Config.DM1_ALTERNATIVE_5_MAINTAINABILITY, Config.DM1_ALTERNATIVE_5_SPEED));
      Config.dm1Evals.put(Config.alternativeList.get(5), Arrays.asList(Config.DM1_ALTERNATIVE_6_CAUSALITY, Config.DM1_ALTERNATIVE_6_UNCERTAINTY, Config.DM1_ALTERNATIVE_6_MISSING, Config.DM1_ALTERNATIVE_6_OUTLIER,
        Config.DM1_ALTERNATIVE_6_INTERPRETABILITY, Config.DM1_ALTERNATIVE_6_COMPLEXITY, Config.DM1_ALTERNATIVE_6_ACCURACY, Config.DM1_ALTERNATIVE_6_MAINTAINABILITY, Config.DM1_ALTERNATIVE_6_SPEED));
      Config.dm1Evals.put(Config.alternativeList.get(6), Arrays.asList(Config.DM1_ALTERNATIVE_7_CAUSALITY, Config.DM1_ALTERNATIVE_7_UNCERTAINTY, Config.DM1_ALTERNATIVE_7_MISSING, Config.DM1_ALTERNATIVE_7_OUTLIER,
        Config.DM1_ALTERNATIVE_7_INTERPRETABILITY, Config.DM1_ALTERNATIVE_7_COMPLEXITY, Config.DM1_ALTERNATIVE_7_ACCURACY, Config.DM1_ALTERNATIVE_7_MAINTAINABILITY, Config.DM1_ALTERNATIVE_7_SPEED));
      Config.dm1Evals.put(Config.alternativeList.get(7), Arrays.asList(Config.DM1_ALTERNATIVE_8_CAUSALITY, Config.DM1_ALTERNATIVE_8_UNCERTAINTY, Config.DM1_ALTERNATIVE_8_MISSING, Config.DM1_ALTERNATIVE_8_OUTLIER,
        Config.DM1_ALTERNATIVE_8_INTERPRETABILITY, Config.DM1_ALTERNATIVE_8_COMPLEXITY, Config.DM1_ALTERNATIVE_8_ACCURACY, Config.DM1_ALTERNATIVE_8_MAINTAINABILITY, Config.DM1_ALTERNATIVE_8_SPEED));

      Config.dm2Evals.put(Config.alternativeList.get(0), Arrays.asList(Config.DM2_ALTERNATIVE_1_CAUSALITY, Config.DM2_ALTERNATIVE_1_UNCERTAINTY, Config.DM2_ALTERNATIVE_1_MISSING, Config.DM2_ALTERNATIVE_1_OUTLIER,
        Config.DM2_ALTERNATIVE_1_INTERPRETABILITY, Config.DM2_ALTERNATIVE_1_COMPLEXITY, Config.DM2_ALTERNATIVE_1_ACCURACY, Config.DM2_ALTERNATIVE_1_MAINTAINABILITY, Config.DM2_ALTERNATIVE_1_SPEED));
      Config.dm2Evals.put(Config.alternativeList.get(1), Arrays.asList(Config.DM2_ALTERNATIVE_2_CAUSALITY, Config.DM2_ALTERNATIVE_2_UNCERTAINTY, Config.DM2_ALTERNATIVE_2_MISSING, Config.DM2_ALTERNATIVE_2_OUTLIER,
        Config.DM2_ALTERNATIVE_2_INTERPRETABILITY, Config.DM2_ALTERNATIVE_2_COMPLEXITY, Config.DM2_ALTERNATIVE_2_ACCURACY, Config.DM2_ALTERNATIVE_2_MAINTAINABILITY, Config.DM2_ALTERNATIVE_2_SPEED));
      Config.dm2Evals.put(Config.alternativeList.get(2), Arrays.asList(Config.DM2_ALTERNATIVE_3_CAUSALITY, Config.DM2_ALTERNATIVE_3_UNCERTAINTY, Config.DM2_ALTERNATIVE_3_MISSING, Config.DM2_ALTERNATIVE_3_OUTLIER,
        Config.DM2_ALTERNATIVE_3_INTERPRETABILITY, Config.DM2_ALTERNATIVE_3_COMPLEXITY, Config.DM2_ALTERNATIVE_3_ACCURACY, Config.DM2_ALTERNATIVE_3_MAINTAINABILITY, Config.DM2_ALTERNATIVE_3_SPEED));
      Config.dm2Evals.put(Config.alternativeList.get(3), Arrays.asList(Config.DM2_ALTERNATIVE_4_CAUSALITY, Config.DM2_ALTERNATIVE_4_UNCERTAINTY, Config.DM2_ALTERNATIVE_4_MISSING, Config.DM2_ALTERNATIVE_4_OUTLIER,
        Config.DM2_ALTERNATIVE_4_INTERPRETABILITY, Config.DM2_ALTERNATIVE_4_COMPLEXITY, Config.DM2_ALTERNATIVE_4_ACCURACY, Config.DM2_ALTERNATIVE_4_MAINTAINABILITY, Config.DM2_ALTERNATIVE_4_SPEED));
      Config.dm2Evals.put(Config.alternativeList.get(4), Arrays.asList(Config.DM2_ALTERNATIVE_5_CAUSALITY, Config.DM2_ALTERNATIVE_5_UNCERTAINTY, Config.DM2_ALTERNATIVE_5_MISSING, Config.DM2_ALTERNATIVE_5_OUTLIER,
        Config.DM2_ALTERNATIVE_5_INTERPRETABILITY, Config.DM2_ALTERNATIVE_5_COMPLEXITY, Config.DM2_ALTERNATIVE_5_ACCURACY, Config.DM2_ALTERNATIVE_5_MAINTAINABILITY, Config.DM2_ALTERNATIVE_5_SPEED));
      Config.dm2Evals.put(Config.alternativeList.get(5), Arrays.asList(Config.DM2_ALTERNATIVE_6_CAUSALITY, Config.DM2_ALTERNATIVE_6_UNCERTAINTY, Config.DM2_ALTERNATIVE_6_MISSING, Config.DM2_ALTERNATIVE_6_OUTLIER,
        Config.DM2_ALTERNATIVE_6_INTERPRETABILITY, Config.DM2_ALTERNATIVE_6_COMPLEXITY, Config.DM2_ALTERNATIVE_6_ACCURACY, Config.DM2_ALTERNATIVE_6_MAINTAINABILITY, Config.DM2_ALTERNATIVE_6_SPEED));
      Config.dm2Evals.put(Config.alternativeList.get(6), Arrays.asList(Config.DM2_ALTERNATIVE_7_CAUSALITY, Config.DM2_ALTERNATIVE_7_UNCERTAINTY, Config.DM2_ALTERNATIVE_7_MISSING, Config.DM2_ALTERNATIVE_7_OUTLIER,
        Config.DM2_ALTERNATIVE_7_INTERPRETABILITY, Config.DM2_ALTERNATIVE_7_COMPLEXITY, Config.DM2_ALTERNATIVE_7_ACCURACY, Config.DM2_ALTERNATIVE_7_MAINTAINABILITY, Config.DM2_ALTERNATIVE_7_SPEED));
      Config.dm2Evals.put(Config.alternativeList.get(7), Arrays.asList(Config.DM2_ALTERNATIVE_8_CAUSALITY, Config.DM2_ALTERNATIVE_8_UNCERTAINTY, Config.DM2_ALTERNATIVE_8_MISSING, Config.DM2_ALTERNATIVE_8_OUTLIER,
        Config.DM2_ALTERNATIVE_8_INTERPRETABILITY, Config.DM2_ALTERNATIVE_8_COMPLEXITY, Config.DM2_ALTERNATIVE_8_ACCURACY, Config.DM2_ALTERNATIVE_8_MAINTAINABILITY, Config.DM2_ALTERNATIVE_8_SPEED));


      Config.dm3Evals.put(Config.alternativeList.get(0), Arrays.asList(Config.DM3_ALTERNATIVE_1_CAUSALITY, Config.DM3_ALTERNATIVE_1_UNCERTAINTY, Config.DM3_ALTERNATIVE_1_MISSING, Config.DM3_ALTERNATIVE_1_OUTLIER,
        Config.DM3_ALTERNATIVE_1_INTERPRETABILITY, Config.DM3_ALTERNATIVE_1_COMPLEXITY, Config.DM3_ALTERNATIVE_1_ACCURACY, Config.DM3_ALTERNATIVE_1_MAINTAINABILITY, Config.DM3_ALTERNATIVE_1_SPEED));
      Config.dm3Evals.put(Config.alternativeList.get(1), Arrays.asList(Config.DM3_ALTERNATIVE_2_CAUSALITY, Config.DM3_ALTERNATIVE_2_UNCERTAINTY, Config.DM3_ALTERNATIVE_2_MISSING, Config.DM3_ALTERNATIVE_2_OUTLIER,
        Config.DM3_ALTERNATIVE_2_INTERPRETABILITY, Config.DM3_ALTERNATIVE_2_COMPLEXITY, Config.DM3_ALTERNATIVE_2_ACCURACY, Config.DM3_ALTERNATIVE_2_MAINTAINABILITY, Config.DM3_ALTERNATIVE_2_SPEED));
      Config.dm3Evals.put(Config.alternativeList.get(2), Arrays.asList(Config.DM3_ALTERNATIVE_3_CAUSALITY, Config.DM3_ALTERNATIVE_3_UNCERTAINTY, Config.DM3_ALTERNATIVE_3_MISSING, Config.DM3_ALTERNATIVE_3_OUTLIER,
        Config.DM3_ALTERNATIVE_3_INTERPRETABILITY, Config.DM3_ALTERNATIVE_3_COMPLEXITY, Config.DM3_ALTERNATIVE_3_ACCURACY, Config.DM3_ALTERNATIVE_3_MAINTAINABILITY, Config.DM3_ALTERNATIVE_3_SPEED));
      Config.dm3Evals.put(Config.alternativeList.get(3), Arrays.asList(Config.DM3_ALTERNATIVE_4_CAUSALITY, Config.DM3_ALTERNATIVE_4_UNCERTAINTY, Config.DM3_ALTERNATIVE_4_MISSING, Config.DM3_ALTERNATIVE_4_OUTLIER,
        Config.DM3_ALTERNATIVE_4_INTERPRETABILITY, Config.DM3_ALTERNATIVE_4_COMPLEXITY, Config.DM3_ALTERNATIVE_4_ACCURACY, Config.DM3_ALTERNATIVE_4_MAINTAINABILITY, Config.DM3_ALTERNATIVE_4_SPEED));
      Config.dm3Evals.put(Config.alternativeList.get(4), Arrays.asList(Config.DM3_ALTERNATIVE_5_CAUSALITY, Config.DM3_ALTERNATIVE_5_UNCERTAINTY, Config.DM3_ALTERNATIVE_5_MISSING, Config.DM3_ALTERNATIVE_5_OUTLIER,
        Config.DM3_ALTERNATIVE_5_INTERPRETABILITY, Config.DM3_ALTERNATIVE_5_COMPLEXITY, Config.DM3_ALTERNATIVE_5_ACCURACY, Config.DM3_ALTERNATIVE_5_MAINTAINABILITY, Config.DM3_ALTERNATIVE_5_SPEED));
      Config.dm3Evals.put(Config.alternativeList.get(5), Arrays.asList(Config.DM3_ALTERNATIVE_6_CAUSALITY, Config.DM3_ALTERNATIVE_6_UNCERTAINTY, Config.DM3_ALTERNATIVE_6_MISSING, Config.DM3_ALTERNATIVE_6_OUTLIER,
        Config.DM3_ALTERNATIVE_6_INTERPRETABILITY, Config.DM3_ALTERNATIVE_6_COMPLEXITY, Config.DM3_ALTERNATIVE_6_ACCURACY, Config.DM3_ALTERNATIVE_6_MAINTAINABILITY, Config.DM3_ALTERNATIVE_6_SPEED));
      Config.dm3Evals.put(Config.alternativeList.get(6), Arrays.asList(Config.DM3_ALTERNATIVE_7_CAUSALITY, Config.DM3_ALTERNATIVE_7_UNCERTAINTY, Config.DM3_ALTERNATIVE_7_MISSING, Config.DM3_ALTERNATIVE_7_OUTLIER,
        Config.DM3_ALTERNATIVE_7_INTERPRETABILITY, Config.DM3_ALTERNATIVE_7_COMPLEXITY, Config.DM3_ALTERNATIVE_7_ACCURACY, Config.DM3_ALTERNATIVE_7_MAINTAINABILITY, Config.DM3_ALTERNATIVE_7_SPEED));
      Config.dm3Evals.put(Config.alternativeList.get(7), Arrays.asList(Config.DM3_ALTERNATIVE_8_CAUSALITY, Config.DM3_ALTERNATIVE_8_UNCERTAINTY, Config.DM3_ALTERNATIVE_8_MISSING, Config.DM3_ALTERNATIVE_8_OUTLIER,
        Config.DM3_ALTERNATIVE_8_INTERPRETABILITY, Config.DM3_ALTERNATIVE_8_COMPLEXITY, Config.DM3_ALTERNATIVE_8_ACCURACY, Config.DM3_ALTERNATIVE_8_MAINTAINABILITY, Config.DM3_ALTERNATIVE_8_SPEED));

      Config.dm4Evals.put(Config.alternativeList.get(0), Arrays.asList(Config.DM4_ALTERNATIVE_1_CAUSALITY, Config.DM4_ALTERNATIVE_1_UNCERTAINTY, Config.DM4_ALTERNATIVE_1_MISSING, Config.DM4_ALTERNATIVE_1_OUTLIER,
        Config.DM4_ALTERNATIVE_1_INTERPRETABILITY, Config.DM4_ALTERNATIVE_1_COMPLEXITY, Config.DM4_ALTERNATIVE_1_ACCURACY, Config.DM4_ALTERNATIVE_1_MAINTAINABILITY, Config.DM4_ALTERNATIVE_1_SPEED));
      Config.dm4Evals.put(Config.alternativeList.get(1), Arrays.asList(Config.DM4_ALTERNATIVE_2_CAUSALITY, Config.DM4_ALTERNATIVE_2_UNCERTAINTY, Config.DM4_ALTERNATIVE_2_MISSING, Config.DM4_ALTERNATIVE_2_OUTLIER,
        Config.DM4_ALTERNATIVE_2_INTERPRETABILITY, Config.DM4_ALTERNATIVE_2_COMPLEXITY, Config.DM4_ALTERNATIVE_2_ACCURACY, Config.DM4_ALTERNATIVE_2_MAINTAINABILITY, Config.DM4_ALTERNATIVE_2_SPEED));
      Config.dm4Evals.put(Config.alternativeList.get(2), Arrays.asList(Config.DM4_ALTERNATIVE_3_CAUSALITY, Config.DM4_ALTERNATIVE_3_UNCERTAINTY, Config.DM4_ALTERNATIVE_3_MISSING, Config.DM4_ALTERNATIVE_3_OUTLIER,
        Config.DM4_ALTERNATIVE_3_INTERPRETABILITY, Config.DM4_ALTERNATIVE_3_COMPLEXITY, Config.DM4_ALTERNATIVE_3_ACCURACY, Config.DM4_ALTERNATIVE_3_MAINTAINABILITY, Config.DM4_ALTERNATIVE_3_SPEED));
      Config.dm4Evals.put(Config.alternativeList.get(3), Arrays.asList(Config.DM4_ALTERNATIVE_4_CAUSALITY, Config.DM4_ALTERNATIVE_4_UNCERTAINTY, Config.DM4_ALTERNATIVE_4_MISSING, Config.DM4_ALTERNATIVE_4_OUTLIER,
        Config.DM4_ALTERNATIVE_4_INTERPRETABILITY, Config.DM4_ALTERNATIVE_4_COMPLEXITY, Config.DM4_ALTERNATIVE_4_ACCURACY, Config.DM4_ALTERNATIVE_4_MAINTAINABILITY, Config.DM4_ALTERNATIVE_4_SPEED));
      Config.dm4Evals.put(Config.alternativeList.get(4), Arrays.asList(Config.DM4_ALTERNATIVE_5_CAUSALITY, Config.DM4_ALTERNATIVE_5_UNCERTAINTY, Config.DM4_ALTERNATIVE_5_MISSING, Config.DM4_ALTERNATIVE_5_OUTLIER,
        Config.DM4_ALTERNATIVE_5_INTERPRETABILITY, Config.DM4_ALTERNATIVE_5_COMPLEXITY, Config.DM4_ALTERNATIVE_5_ACCURACY, Config.DM4_ALTERNATIVE_5_MAINTAINABILITY, Config.DM4_ALTERNATIVE_5_SPEED));
      Config.dm4Evals.put(Config.alternativeList.get(5), Arrays.asList(Config.DM4_ALTERNATIVE_6_CAUSALITY, Config.DM4_ALTERNATIVE_6_UNCERTAINTY, Config.DM4_ALTERNATIVE_6_MISSING, Config.DM4_ALTERNATIVE_6_OUTLIER,
        Config.DM4_ALTERNATIVE_6_INTERPRETABILITY, Config.DM4_ALTERNATIVE_6_COMPLEXITY, Config.DM4_ALTERNATIVE_6_ACCURACY, Config.DM4_ALTERNATIVE_6_MAINTAINABILITY, Config.DM4_ALTERNATIVE_6_SPEED));
      Config.dm4Evals.put(Config.alternativeList.get(6), Arrays.asList(Config.DM4_ALTERNATIVE_7_CAUSALITY, Config.DM4_ALTERNATIVE_7_UNCERTAINTY, Config.DM4_ALTERNATIVE_7_MISSING, Config.DM4_ALTERNATIVE_7_OUTLIER,
        Config.DM4_ALTERNATIVE_7_INTERPRETABILITY, Config.DM4_ALTERNATIVE_7_COMPLEXITY, Config.DM4_ALTERNATIVE_7_ACCURACY, Config.DM4_ALTERNATIVE_7_MAINTAINABILITY, Config.DM4_ALTERNATIVE_7_SPEED));
      Config.dm4Evals.put(Config.alternativeList.get(7), Arrays.asList(Config.DM4_ALTERNATIVE_8_CAUSALITY, Config.DM4_ALTERNATIVE_8_UNCERTAINTY, Config.DM4_ALTERNATIVE_8_MISSING, Config.DM4_ALTERNATIVE_8_OUTLIER,
        Config.DM4_ALTERNATIVE_8_INTERPRETABILITY, Config.DM4_ALTERNATIVE_8_COMPLEXITY, Config.DM4_ALTERNATIVE_8_ACCURACY, Config.DM4_ALTERNATIVE_8_MAINTAINABILITY, Config.DM4_ALTERNATIVE_8_SPEED));

    }

    public List<Alternative> startFuzzyTopsisCalculation(List<Criteria> criteriaList, List<Alternative> alternativeList) {
        /**
         * Step 1. Assignment rating to the criteria and to the alternatives.
         */
        initializeAlternativeList(alternativeList);
        initializeDmEvaluations();
        initializeCriteriaWeights(criteriaList);
        initializeIdealSolutionLists();
        /**
         * Step 2. Compute the aggregated fuzzy ratings for alternatives and the aggregated fuzzy weights for criteria.
         */
        computeCombinedFuzzyDecisionMatrix();

        /**
         * Step 3. Compute the normalized fuzzy decision matrix.
         */
        computeNormalizedFuzzyDecisionMatrix();

        /**
         * Step 4. Compute the weighted normalized fuzzy decision matrix.
         */
        calculateWeightedNormalizedFuzzyDecisionMatrix();

        /**
         * Step 5. Compute the Fuzzy Positive Ideal Solution (FPIS) and Fuzzy Negative Ideal Solution (FNIS).
         */
        computeFPIS();
        computeFNIS();

        /**
         * Step 6. Compute the distance from each alternative to the FPIS and to the FNIS.
         */
        computeDistanceToFPISAndFNIS();

        /**
         * Step 7. Compute the closeness coefficient CCi for each alternative.
         */
        computeClosenessCoefficient();

        /**
         * Step 8. Rank the alternatives.
         */
        return rankAlternatives();
    }

    private void initializeIdealSolutionLists() {
        // TODO: change it to criteria list got from request
        IntStream.range(0, criteriaWeightMap.keySet().size() * 3).forEach(i -> FPIS_A_star.add(0.0));
        IntStream.range(0, criteriaWeightMap.keySet().size() * 3).forEach(i -> FNIS_A_minus.add(0.0));
    }

    private void initializeAlternativeList(List<Alternative> alternativeList) {
        List<Alternative> toBeRemoved = new ArrayList<Alternative>();
        Config.alternativeList.forEach(alternative -> {
            Optional<Alternative> existedAlternative = alternativeList.stream().filter(alternative1 -> alternative1.getName().equals(alternative.getName())).findFirst();
            if (!existedAlternative.isPresent()) {
                toBeRemoved.add(alternative);
            }
        });
        Config.alternativeList.removeAll(toBeRemoved);
    }

    private void initializeDmEvaluations() {
        dmEvaluationsMap.put(Config.dms[0], Config.dm1Evals);
        dmEvaluationsMap.put(Config.dms[1], Config.dm2Evals);
        dmEvaluationsMap.put(Config.dms[2], Config.dm3Evals);
        dmEvaluationsMap.put(Config.dms[3], Config.dm4Evals);
        System.out.println("DM evaluations = " + dmEvaluationsMap);
    }

    private void initializeCriteriaWeights(List<Criteria> criteriaList) {
        criteriaList.forEach(criteria -> {
            this.criteriaList.add(criteria);
            if (criteria.isChecked())
                criteriaWeightMap.put(criteria.getName(), criteria.getWeight());
            else
                criteriaWeightMap.put(criteria.getName(), new Weight(1, 1, 1));
        });
        System.out.println("Criteria Weight Map = " + criteriaWeightMap.keySet());
    }

    private void computeCombinedFuzzyDecisionMatrix() {
        for (int alternativeNum = 0; alternativeNum < Config.alternativeList.size(); alternativeNum++) {
            double minMin = 0.0;
            double avgAvg = 0.0;
            double maxMax = 0.0;
            ArrayList<Double> combinedMatrixRow = new ArrayList<>();
            for (int criteriaNum = 0; criteriaNum < criteriaWeightMap.keySet().size(); criteriaNum++) {
                double min = 0.0;
                double avg = 0.0;
                double max = 0.0;
                List<Double> minList = new ArrayList<>();
                List<Double> avgList = new ArrayList<>();
                List<Double> maxList = new ArrayList<>();
                for (String dm : Config.dms) {
                    Map<Alternative, List<Fuzzy>> dmAlternativeListHashMap = dmEvaluationsMap.get(dm);
                    List<Fuzzy> alternativeFuzzyList = dmAlternativeListHashMap.get(Config.alternativeList.get(alternativeNum));
                    if (alternativeFuzzyList != null) {
                        if (Objects.equals(alternativeFuzzyList.get(criteriaNum), Fuzzy.OTHER))
                            continue;
                        min = alternativeFuzzyList.get(criteriaNum).getA();
                        avg = alternativeFuzzyList.get(criteriaNum).getB();
                        max = alternativeFuzzyList.get(criteriaNum).getC();
                        minList.add(min);
                        avgList.add(avg);
                        maxList.add(max);
                    }
                }
                if (!minList.isEmpty() && !avgList.isEmpty() && !maxList.isEmpty()) {
                    minMin = findMin(minList);
                    avgAvg = findAvg(avgList);
                    maxMax = findMax(maxList);
                    combinedMatrixRow.add(minMin);
                    combinedMatrixRow.add(avgAvg);
                    combinedMatrixRow.add(maxMax);
                }
            }
            alternativeFDMMap.put(Config.alternativeList.get(alternativeNum), combinedMatrixRow);
        }
        System.out.println("Aggregated FDM = " + alternativeFDMMap);
    }

    private double findMax(List<Double> maxList) {
        Collections.sort(maxList);
        Collections.reverse(maxList);
        return maxList.get(0);
    }

    private double findAvg(List<Double> avgList) {
        double sum = avgList.stream().mapToDouble(aDouble -> aDouble).sum();
        return sum / avgList.size();
    }

    private double findMin(List<Double> minList) {
        Collections.sort(minList);
        return minList.get(0);
    }

    private void computeNormalizedFuzzyDecisionMatrix() {
        for (int criteriaNum = 1; criteriaNum <= criteriaWeightMap.keySet().size(); criteriaNum++) {
            double cStarr = 1;
            double aMinus = 9;
            double secilenKatsayi = 0;
            for (int i = 0; i <= Config.alternativeList.size() - 1; i++) {
                List<Double> doubles = alternativeFDMMap.get(Config.alternativeList.get(i));
                if (criteriaList.get(criteriaNum - 1).isCost()) {
                    double a1 = doubles.get((criteriaNum - 1) * 3);
                    if (a1 <= aMinus) {
                        aMinus = a1;
                    }
                } else {
                    double c1 = doubles.get((criteriaNum - 1) * 3 + 2);
                    if (c1 >= cStarr) {
                        cStarr = c1;
                    }
                }
            }
            secilenKatsayi = cStarr == 0 ? aMinus : cStarr;

            for (Map.Entry<Alternative, List<Double>> entry : alternativeFDMMap.entrySet()) {
                alternativeNormalizedFDMMap.putIfAbsent(entry.getKey(), new ArrayList<>());
            }
            for (int i = 0; i <= Config.alternativeList.size() - 1; i++) {
                List<Double> doubles = alternativeFDMMap.get(Config.alternativeList.get(i));
                for (int f = 0; f < doubles.size(); f = f + 3) {
                    if ((f / 3) % (criteriaWeightMap.keySet().size()) == (criteriaNum - 1)) {
                        if (criteriaList.get(criteriaNum - 1).isCost()) {
                            alternativeNormalizedFDMMap.get(Config.alternativeList.get(i)).add(secilenKatsayi / doubles.get(f + 2));
                            alternativeNormalizedFDMMap.get(Config.alternativeList.get(i)).add(secilenKatsayi / doubles.get(f + 1));
                            alternativeNormalizedFDMMap.get(Config.alternativeList.get(i)).add(secilenKatsayi / doubles.get(f));
                        } else {
                            alternativeNormalizedFDMMap.get(Config.alternativeList.get(i)).add(doubles.get(f) / secilenKatsayi);
                            alternativeNormalizedFDMMap.get(Config.alternativeList.get(i)).add(doubles.get(f + 1) / secilenKatsayi);
                            alternativeNormalizedFDMMap.get(Config.alternativeList.get(i)).add(doubles.get(f + 2) / secilenKatsayi);
                        }
                    }
                }
            }
        }
        System.out.println("Normalized FDM = " + alternativeNormalizedFDMMap);
        alternativeFDMMap.clear();
        alternativeFDMMap.putAll(alternativeNormalizedFDMMap);
    }

    private void calculateWeightedNormalizedFuzzyDecisionMatrix() {
        for (Map.Entry<Alternative, List<Double>> entry : alternativeFDMMap.entrySet()) {
            List<Double> weightedMatrix = new ArrayList<>();
            int j = 0;
            for (int i = 0; i < entry.getValue().size() - 2; i = i + 3) {
                weightedMatrix.add(entry.getValue().get(i) * criteriaWeightMap.get(criteriaList.get(j).getName()).getA());
                weightedMatrix.add(entry.getValue().get(i + 1) * criteriaWeightMap.get(criteriaList.get(j).getName()).getB());
                weightedMatrix.add(entry.getValue().get(i + 2) * criteriaWeightMap.get(criteriaList.get(j).getName()).getC());
                j++;
            }
            entry.setValue(weightedMatrix);
        }

        System.out.println("Weighted Normalized FDM = " + alternativeFDMMap);
    }

    private void computeFNIS() {
        for (int criteriaNum = 1; criteriaNum <= criteriaWeightMap.keySet().size(); criteriaNum++) {
            for (int index = 0; index <= 2; index++) {
                double aMinus = 9;
                double secilenKatsayi = 0;
                for (int i = 0; i <= Config.alternativeList.size() - 1; i++) {
                    List<Double> fuzzies = alternativeFDMMap.get(Config.alternativeList.get(i));
                    double a1 = fuzzies.get((criteriaNum - 1) * 3 + index);
                    if (a1 <= aMinus) {
                        aMinus = a1;
                    }
                }
                secilenKatsayi = aMinus;
                FNIS_A_minus.set((criteriaNum - 1) * 3 + index, secilenKatsayi);
            }
        }
        System.out.println("FNIS = " + FNIS_A_minus);
    }

    private void computeFPIS() {
        for (int criteriaNum = 1; criteriaNum <= criteriaWeightMap.keySet().size(); criteriaNum++) {
            for (int index = 2; index >= 0; index--) {
                double aMinus = 0;
                double secilenKatsayi = 0;
                for (int i = 0; i <= Config.alternativeList.size() - 1; i++) {
                    List<Double> fuzzies = alternativeFDMMap.get(Config.alternativeList.get(i));
                    double a1 = fuzzies.get((criteriaNum - 1) * 3 + index);
                    if (a1 >= aMinus) {
                        aMinus = a1;
                    }
                }
                secilenKatsayi = aMinus;
                FPIS_A_star.set((criteriaNum - 1) * 3 + index, secilenKatsayi);
            }
        }
        System.out.println("FPIS = " + FPIS_A_star);
    }

    private void computeDistanceToFPISAndFNIS() {
        EuclideanDistance distance = new EuclideanDistance();

        for (Map.Entry<Alternative, List<Double>> entry : alternativeFDMMap.entrySet()) {
            double totalDStarValue = 0.0;
            double totalDMinusValue = 0.0;
            for (int i = 0; i < entry.getValue().size(); i = i + 3) {
                double[] fuzzyValues = {entry.getValue().get(i), entry.getValue().get(i + 1), entry.getValue().get(i + 2)};
                double[] idealSolution = {FPIS_A_star.get(i), FPIS_A_star.get(i + 1), FPIS_A_star.get(i + 2)};
                double[] antiIdealSolution = {FNIS_A_minus.get(i), FNIS_A_minus.get(i + 1), FNIS_A_minus.get(i + 2)};
                double d = distance.compute(fuzzyValues, idealSolution) * FastMath.sqrt((1.0 / 3.0));
                totalDStarValue = totalDStarValue + d;
                d = distance.compute(fuzzyValues, antiIdealSolution) * FastMath.sqrt((1.0 / 3.0));
                totalDMinusValue = totalDMinusValue + d;
            }
            diStarMap.put(entry.getKey().getName(), totalDStarValue);
            diMinusMap.put(entry.getKey().getName(), totalDMinusValue);
        }
        System.out.println("diStarMap:" + diStarMap);
        System.out.println("diMinusMap:" + diMinusMap);
    }

    private void computeClosenessCoefficient() {
        diStarMap.forEach((key, value) -> alternativeClosenessCoefficientMap.put(key, diMinusMap.get(key) / (diMinusMap.get(key) + value)));
    }

    private List<Alternative> rankAlternatives() {
        System.out.println("Score values of the alternatives:");

        for (Map.Entry<String, Double> entry : alternativeClosenessCoefficientMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + Config.formatter.format(entry.getValue()));
        }

        TreeMap<Double, String> rankMap = new TreeMap<>(Collections.reverseOrder());
        System.out.println("Final Ranking of the alternatives:");

        for (Map.Entry<String, Double> entry : alternativeClosenessCoefficientMap.entrySet()) {
            String methodName = entry.getKey();
            if (rankMap.containsKey(entry.getValue())) {
                methodName = rankMap.get(entry.getValue()) + " & " + methodName;
            }
            rankMap.put(entry.getValue(), methodName);
        }
        int i = 1;
        List<Alternative> alternatives = new ArrayList<>();
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Double, String> entry : rankMap.entrySet()) {
            result.append(i + ". alternative: " + entry.getValue() + " (Score: " + Config.formatter.format(entry.getKey()) + ")\n");
            i++;
            Alternative alternative = new Alternative(entry.getValue());
            alternative.setScore(entry.getKey());
            alternatives.add(alternative);
        }
        System.out.println(result.toString());
        return alternatives;
    }
}
