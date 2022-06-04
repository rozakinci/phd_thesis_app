package tr.edu.hacettepe.da4esdp.service;


import tr.edu.hacettepe.da4esdp.entity.Alternative;
import tr.edu.hacettepe.da4esdp.entity.Fuzzy;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Config {
    // DM1
    static final Fuzzy DM1_ALTERNATIVE_1_CAUSALITY = Fuzzy.AVERAGE;
    static final Fuzzy DM1_ALTERNATIVE_1_UNCERTAINTY = Fuzzy.AVERAGE;
    static final Fuzzy DM1_ALTERNATIVE_1_MISSING = Fuzzy.HIGH;
    static final Fuzzy DM1_ALTERNATIVE_1_OUTLIER = Fuzzy.HIGH;
    static final Fuzzy DM1_ALTERNATIVE_1_INTERPRETABILITY = Fuzzy.VERY_LOW;
    static final Fuzzy DM1_ALTERNATIVE_1_COMPLEXITY = Fuzzy.HIGH;
    static final Fuzzy DM1_ALTERNATIVE_1_ACCURACY = Fuzzy.AVERAGE;
    static final Fuzzy DM1_ALTERNATIVE_1_MAINTAINABILITY = Fuzzy.LOW;
    static final Fuzzy DM1_ALTERNATIVE_1_SPEED = Fuzzy.LOW;

  static final Fuzzy DM1_ALTERNATIVE_2_CAUSALITY = Fuzzy.AVERAGE;
    static final Fuzzy DM1_ALTERNATIVE_2_UNCERTAINTY = Fuzzy.AVERAGE;
    static final Fuzzy DM1_ALTERNATIVE_2_MISSING = Fuzzy.HIGH;
    static final Fuzzy DM1_ALTERNATIVE_2_OUTLIER = Fuzzy.AVERAGE;
    static final Fuzzy DM1_ALTERNATIVE_2_INTERPRETABILITY = Fuzzy.AVERAGE;
    static final Fuzzy DM1_ALTERNATIVE_2_COMPLEXITY = Fuzzy.HIGH;
    static final Fuzzy DM1_ALTERNATIVE_2_ACCURACY = Fuzzy.HIGH;
    static final Fuzzy DM1_ALTERNATIVE_2_MAINTAINABILITY = Fuzzy.AVERAGE;
    static final Fuzzy DM1_ALTERNATIVE_2_SPEED = Fuzzy.AVERAGE;

  static final Fuzzy DM1_ALTERNATIVE_3_CAUSALITY = Fuzzy.AVERAGE;
    static final Fuzzy DM1_ALTERNATIVE_3_UNCERTAINTY = Fuzzy.AVERAGE;
    static final Fuzzy DM1_ALTERNATIVE_3_MISSING = Fuzzy.HIGH;
    static final Fuzzy DM1_ALTERNATIVE_3_OUTLIER = Fuzzy.VERY_LOW;
    static final Fuzzy DM1_ALTERNATIVE_3_INTERPRETABILITY = Fuzzy.VERY_HIGH;
    static final Fuzzy DM1_ALTERNATIVE_3_COMPLEXITY = Fuzzy.VERY_LOW;
    static final Fuzzy DM1_ALTERNATIVE_3_ACCURACY = Fuzzy.HIGH;
    static final Fuzzy DM1_ALTERNATIVE_3_MAINTAINABILITY = Fuzzy.HIGH;
    static final Fuzzy DM1_ALTERNATIVE_3_SPEED = Fuzzy.VERY_HIGH;

  static final Fuzzy DM1_ALTERNATIVE_4_CAUSALITY = Fuzzy.LOW;
    static final Fuzzy DM1_ALTERNATIVE_4_UNCERTAINTY = Fuzzy.LOW;
    static final Fuzzy DM1_ALTERNATIVE_4_MISSING = Fuzzy.AVERAGE;
    static final Fuzzy DM1_ALTERNATIVE_4_OUTLIER = Fuzzy.AVERAGE;
    static final Fuzzy DM1_ALTERNATIVE_4_INTERPRETABILITY = Fuzzy.AVERAGE;
    static final Fuzzy DM1_ALTERNATIVE_4_COMPLEXITY = Fuzzy.HIGH;
    static final Fuzzy DM1_ALTERNATIVE_4_ACCURACY = Fuzzy.AVERAGE;
    static final Fuzzy DM1_ALTERNATIVE_4_MAINTAINABILITY = Fuzzy.LOW;
    static final Fuzzy DM1_ALTERNATIVE_4_SPEED = Fuzzy.AVERAGE;

  static final Fuzzy DM1_ALTERNATIVE_5_CAUSALITY = Fuzzy.LOW;
    static final Fuzzy DM1_ALTERNATIVE_5_UNCERTAINTY = Fuzzy.AVERAGE;
    static final Fuzzy DM1_ALTERNATIVE_5_MISSING = Fuzzy.HIGH;
    static final Fuzzy DM1_ALTERNATIVE_5_OUTLIER = Fuzzy.AVERAGE;
    static final Fuzzy DM1_ALTERNATIVE_5_INTERPRETABILITY = Fuzzy.VERY_HIGH;
    static final Fuzzy DM1_ALTERNATIVE_5_COMPLEXITY = Fuzzy.VERY_LOW;
    static final Fuzzy DM1_ALTERNATIVE_5_ACCURACY = Fuzzy.AVERAGE;
    static final Fuzzy DM1_ALTERNATIVE_5_MAINTAINABILITY = Fuzzy.HIGH;
    static final Fuzzy DM1_ALTERNATIVE_5_SPEED = Fuzzy.VERY_HIGH;

  static final Fuzzy DM1_ALTERNATIVE_6_CAUSALITY = Fuzzy.AVERAGE;
    static final Fuzzy DM1_ALTERNATIVE_6_UNCERTAINTY = Fuzzy.AVERAGE;
    static final Fuzzy DM1_ALTERNATIVE_6_MISSING = Fuzzy.HIGH;
    static final Fuzzy DM1_ALTERNATIVE_6_OUTLIER = Fuzzy.HIGH;
    static final Fuzzy DM1_ALTERNATIVE_6_INTERPRETABILITY = Fuzzy.VERY_HIGH;
    static final Fuzzy DM1_ALTERNATIVE_6_COMPLEXITY = Fuzzy.VERY_LOW;
    static final Fuzzy DM1_ALTERNATIVE_6_ACCURACY = Fuzzy.HIGH;
    static final Fuzzy DM1_ALTERNATIVE_6_MAINTAINABILITY = Fuzzy.HIGH;
    static final Fuzzy DM1_ALTERNATIVE_6_SPEED = Fuzzy.VERY_HIGH;

  static final Fuzzy DM1_ALTERNATIVE_7_CAUSALITY = Fuzzy.AVERAGE;
    static final Fuzzy DM1_ALTERNATIVE_7_UNCERTAINTY = Fuzzy.HIGH;
    static final Fuzzy DM1_ALTERNATIVE_7_MISSING = Fuzzy.HIGH;
    static final Fuzzy DM1_ALTERNATIVE_7_OUTLIER = Fuzzy.HIGH;
    static final Fuzzy DM1_ALTERNATIVE_7_INTERPRETABILITY = Fuzzy.VERY_HIGH;
    static final Fuzzy DM1_ALTERNATIVE_7_COMPLEXITY = Fuzzy.VERY_LOW;
    static final Fuzzy DM1_ALTERNATIVE_7_ACCURACY = Fuzzy.HIGH;
    static final Fuzzy DM1_ALTERNATIVE_7_MAINTAINABILITY = Fuzzy.HIGH;
    static final Fuzzy DM1_ALTERNATIVE_7_SPEED = Fuzzy.VERY_HIGH;

  static final Fuzzy DM1_ALTERNATIVE_8_CAUSALITY = Fuzzy.AVERAGE;
    static final Fuzzy DM1_ALTERNATIVE_8_UNCERTAINTY = Fuzzy.AVERAGE;
    static final Fuzzy DM1_ALTERNATIVE_8_MISSING = Fuzzy.HIGH;
    static final Fuzzy DM1_ALTERNATIVE_8_OUTLIER = Fuzzy.HIGH;
    static final Fuzzy DM1_ALTERNATIVE_8_INTERPRETABILITY = Fuzzy.AVERAGE;
    static final Fuzzy DM1_ALTERNATIVE_8_COMPLEXITY = Fuzzy.HIGH;
    static final Fuzzy DM1_ALTERNATIVE_8_ACCURACY = Fuzzy.HIGH;
    static final Fuzzy DM1_ALTERNATIVE_8_MAINTAINABILITY = Fuzzy.AVERAGE;
    static final Fuzzy DM1_ALTERNATIVE_8_SPEED = Fuzzy.AVERAGE;
    //DM2
    static final Fuzzy DM2_ALTERNATIVE_1_CAUSALITY = Fuzzy.AVERAGE;
    static final Fuzzy DM2_ALTERNATIVE_1_UNCERTAINTY = Fuzzy.HIGH;
    static final Fuzzy DM2_ALTERNATIVE_1_MISSING = Fuzzy.AVERAGE;
    static final Fuzzy DM2_ALTERNATIVE_1_OUTLIER = Fuzzy.HIGH;
    static final Fuzzy DM2_ALTERNATIVE_1_INTERPRETABILITY = Fuzzy.VERY_LOW;
    static final Fuzzy DM2_ALTERNATIVE_1_COMPLEXITY = Fuzzy.VERY_HIGH;
    static final Fuzzy DM2_ALTERNATIVE_1_ACCURACY = Fuzzy.VERY_HIGH;
    static final Fuzzy DM2_ALTERNATIVE_1_MAINTAINABILITY = Fuzzy.AVERAGE;
    static final Fuzzy DM2_ALTERNATIVE_1_SPEED = Fuzzy.LOW;

  static final Fuzzy DM2_ALTERNATIVE_2_CAUSALITY = Fuzzy.OTHER;
    static final Fuzzy DM2_ALTERNATIVE_2_UNCERTAINTY = Fuzzy.OTHER;
    static final Fuzzy DM2_ALTERNATIVE_2_MISSING = Fuzzy.OTHER;
    static final Fuzzy DM2_ALTERNATIVE_2_OUTLIER = Fuzzy.OTHER;
    static final Fuzzy DM2_ALTERNATIVE_2_INTERPRETABILITY = Fuzzy.OTHER;
    static final Fuzzy DM2_ALTERNATIVE_2_COMPLEXITY = Fuzzy.OTHER;
    static final Fuzzy DM2_ALTERNATIVE_2_ACCURACY = Fuzzy.OTHER;
    static final Fuzzy DM2_ALTERNATIVE_2_MAINTAINABILITY = Fuzzy.OTHER;
    static final Fuzzy DM2_ALTERNATIVE_2_SPEED = Fuzzy.OTHER;

  static final Fuzzy DM2_ALTERNATIVE_3_CAUSALITY = Fuzzy.OTHER;
    static final Fuzzy DM2_ALTERNATIVE_3_UNCERTAINTY = Fuzzy.OTHER;
    static final Fuzzy DM2_ALTERNATIVE_3_MISSING = Fuzzy.OTHER;
    static final Fuzzy DM2_ALTERNATIVE_3_OUTLIER = Fuzzy.OTHER;
    static final Fuzzy DM2_ALTERNATIVE_3_INTERPRETABILITY = Fuzzy.HIGH;
    static final Fuzzy DM2_ALTERNATIVE_3_COMPLEXITY = Fuzzy.OTHER;
    static final Fuzzy DM2_ALTERNATIVE_3_ACCURACY = Fuzzy.OTHER;
    static final Fuzzy DM2_ALTERNATIVE_3_MAINTAINABILITY = Fuzzy.OTHER;
    static final Fuzzy DM2_ALTERNATIVE_3_SPEED = Fuzzy.OTHER;

  static final Fuzzy DM2_ALTERNATIVE_4_CAUSALITY = Fuzzy.VERY_HIGH;
    static final Fuzzy DM2_ALTERNATIVE_4_UNCERTAINTY = Fuzzy.LOW;
    static final Fuzzy DM2_ALTERNATIVE_4_MISSING = Fuzzy.LOW;
    static final Fuzzy DM2_ALTERNATIVE_4_OUTLIER = Fuzzy.LOW;
    static final Fuzzy DM2_ALTERNATIVE_4_INTERPRETABILITY = Fuzzy.VERY_HIGH;
    static final Fuzzy DM2_ALTERNATIVE_4_COMPLEXITY = Fuzzy.VERY_LOW;
    static final Fuzzy DM2_ALTERNATIVE_4_ACCURACY = Fuzzy.HIGH;
    static final Fuzzy DM2_ALTERNATIVE_4_MAINTAINABILITY = Fuzzy.VERY_HIGH;
  static final Fuzzy DM2_ALTERNATIVE_4_SPEED = Fuzzy.HIGH;

  static final Fuzzy DM2_ALTERNATIVE_5_CAUSALITY = Fuzzy.OTHER;
  static final Fuzzy DM2_ALTERNATIVE_5_UNCERTAINTY = Fuzzy.OTHER;
  static final Fuzzy DM2_ALTERNATIVE_5_MISSING = Fuzzy.OTHER;
  static final Fuzzy DM2_ALTERNATIVE_5_OUTLIER = Fuzzy.OTHER;
  static final Fuzzy DM2_ALTERNATIVE_5_INTERPRETABILITY = Fuzzy.OTHER;
  static final Fuzzy DM2_ALTERNATIVE_5_COMPLEXITY = Fuzzy.OTHER;
  static final Fuzzy DM2_ALTERNATIVE_5_ACCURACY = Fuzzy.OTHER;
  static final Fuzzy DM2_ALTERNATIVE_5_MAINTAINABILITY = Fuzzy.OTHER;
  static final Fuzzy DM2_ALTERNATIVE_5_SPEED = Fuzzy.OTHER;

  static final Fuzzy DM2_ALTERNATIVE_6_CAUSALITY = Fuzzy.OTHER;
  static final Fuzzy DM2_ALTERNATIVE_6_UNCERTAINTY = Fuzzy.OTHER;
  static final Fuzzy DM2_ALTERNATIVE_6_MISSING = Fuzzy.OTHER;
  static final Fuzzy DM2_ALTERNATIVE_6_OUTLIER = Fuzzy.OTHER;
  static final Fuzzy DM2_ALTERNATIVE_6_INTERPRETABILITY = Fuzzy.OTHER;
  static final Fuzzy DM2_ALTERNATIVE_6_COMPLEXITY = Fuzzy.OTHER;
  static final Fuzzy DM2_ALTERNATIVE_6_ACCURACY = Fuzzy.OTHER;
  static final Fuzzy DM2_ALTERNATIVE_6_MAINTAINABILITY = Fuzzy.OTHER;
  static final Fuzzy DM2_ALTERNATIVE_6_SPEED = Fuzzy.OTHER;

  static final Fuzzy DM2_ALTERNATIVE_7_CAUSALITY = Fuzzy.OTHER;
    static final Fuzzy DM2_ALTERNATIVE_7_UNCERTAINTY = Fuzzy.OTHER;
    static final Fuzzy DM2_ALTERNATIVE_7_MISSING = Fuzzy.OTHER;
    static final Fuzzy DM2_ALTERNATIVE_7_OUTLIER = Fuzzy.OTHER;
    static final Fuzzy DM2_ALTERNATIVE_7_INTERPRETABILITY = Fuzzy.OTHER;
    static final Fuzzy DM2_ALTERNATIVE_7_COMPLEXITY = Fuzzy.LOW;
    static final Fuzzy DM2_ALTERNATIVE_7_ACCURACY = Fuzzy.HIGH;
    static final Fuzzy DM2_ALTERNATIVE_7_MAINTAINABILITY = Fuzzy.HIGH;
    static final Fuzzy DM2_ALTERNATIVE_7_SPEED = Fuzzy.HIGH;

  static final Fuzzy DM2_ALTERNATIVE_8_CAUSALITY = Fuzzy.OTHER;
    static final Fuzzy DM2_ALTERNATIVE_8_UNCERTAINTY = Fuzzy.OTHER;
    static final Fuzzy DM2_ALTERNATIVE_8_MISSING = Fuzzy.OTHER;
    static final Fuzzy DM2_ALTERNATIVE_8_OUTLIER = Fuzzy.OTHER;
    static final Fuzzy DM2_ALTERNATIVE_8_INTERPRETABILITY = Fuzzy.OTHER;
    static final Fuzzy DM2_ALTERNATIVE_8_COMPLEXITY = Fuzzy.AVERAGE;
    static final Fuzzy DM2_ALTERNATIVE_8_ACCURACY = Fuzzy.AVERAGE;
    static final Fuzzy DM2_ALTERNATIVE_8_MAINTAINABILITY = Fuzzy.OTHER;
    static final Fuzzy DM2_ALTERNATIVE_8_SPEED = Fuzzy.OTHER;
    //DM3
    static final Fuzzy DM3_ALTERNATIVE_1_CAUSALITY = Fuzzy.VERY_LOW;
    static final Fuzzy DM3_ALTERNATIVE_1_UNCERTAINTY = Fuzzy.LOW;
    static final Fuzzy DM3_ALTERNATIVE_1_MISSING = Fuzzy.AVERAGE;
    static final Fuzzy DM3_ALTERNATIVE_1_OUTLIER = Fuzzy.HIGH;
    static final Fuzzy DM3_ALTERNATIVE_1_INTERPRETABILITY = Fuzzy.VERY_LOW;
    static final Fuzzy DM3_ALTERNATIVE_1_COMPLEXITY = Fuzzy.HIGH;
    static final Fuzzy DM3_ALTERNATIVE_1_ACCURACY = Fuzzy.HIGH;
    static final Fuzzy DM3_ALTERNATIVE_1_MAINTAINABILITY = Fuzzy.VERY_LOW;
    static final Fuzzy DM3_ALTERNATIVE_1_SPEED = Fuzzy.HIGH;

  static final Fuzzy DM3_ALTERNATIVE_2_CAUSALITY = Fuzzy.VERY_HIGH;
    static final Fuzzy DM3_ALTERNATIVE_2_UNCERTAINTY = Fuzzy.VERY_HIGH;
    static final Fuzzy DM3_ALTERNATIVE_2_MISSING = Fuzzy.VERY_HIGH;
    static final Fuzzy DM3_ALTERNATIVE_2_OUTLIER = Fuzzy.HIGH;
    static final Fuzzy DM3_ALTERNATIVE_2_INTERPRETABILITY = Fuzzy.VERY_HIGH;
    static final Fuzzy DM3_ALTERNATIVE_2_COMPLEXITY = Fuzzy.AVERAGE;
    static final Fuzzy DM3_ALTERNATIVE_2_ACCURACY = Fuzzy.HIGH;
    static final Fuzzy DM3_ALTERNATIVE_2_MAINTAINABILITY = Fuzzy.VERY_HIGH;
    static final Fuzzy DM3_ALTERNATIVE_2_SPEED = Fuzzy.AVERAGE;

  static final Fuzzy DM3_ALTERNATIVE_3_CAUSALITY = Fuzzy.VERY_LOW;
    static final Fuzzy DM3_ALTERNATIVE_3_UNCERTAINTY = Fuzzy.LOW;
    static final Fuzzy DM3_ALTERNATIVE_3_MISSING = Fuzzy.AVERAGE;
    static final Fuzzy DM3_ALTERNATIVE_3_OUTLIER = Fuzzy.HIGH;
    static final Fuzzy DM3_ALTERNATIVE_3_INTERPRETABILITY = Fuzzy.VERY_HIGH;
    static final Fuzzy DM3_ALTERNATIVE_3_COMPLEXITY = Fuzzy.LOW;
    static final Fuzzy DM3_ALTERNATIVE_3_ACCURACY = Fuzzy.HIGH;
    static final Fuzzy DM3_ALTERNATIVE_3_MAINTAINABILITY = Fuzzy.VERY_LOW;
    static final Fuzzy DM3_ALTERNATIVE_3_SPEED = Fuzzy.VERY_HIGH;

  static final Fuzzy DM3_ALTERNATIVE_4_CAUSALITY = Fuzzy.VERY_LOW;
    static final Fuzzy DM3_ALTERNATIVE_4_UNCERTAINTY = Fuzzy.AVERAGE;
    static final Fuzzy DM3_ALTERNATIVE_4_MISSING = Fuzzy.AVERAGE;
    static final Fuzzy DM3_ALTERNATIVE_4_OUTLIER = Fuzzy.OTHER;
    static final Fuzzy DM3_ALTERNATIVE_4_INTERPRETABILITY = Fuzzy.OTHER;
    static final Fuzzy DM3_ALTERNATIVE_4_COMPLEXITY = Fuzzy.OTHER;
    static final Fuzzy DM3_ALTERNATIVE_4_ACCURACY = Fuzzy.VERY_LOW;
    static final Fuzzy DM3_ALTERNATIVE_4_MAINTAINABILITY = Fuzzy.VERY_LOW;
    static final Fuzzy DM3_ALTERNATIVE_4_SPEED = Fuzzy.AVERAGE;

  static final Fuzzy DM3_ALTERNATIVE_5_CAUSALITY = Fuzzy.VERY_LOW;
    static final Fuzzy DM3_ALTERNATIVE_5_UNCERTAINTY = Fuzzy.LOW;
    static final Fuzzy DM3_ALTERNATIVE_5_MISSING = Fuzzy.LOW;
    static final Fuzzy DM3_ALTERNATIVE_5_OUTLIER = Fuzzy.LOW;
    static final Fuzzy DM3_ALTERNATIVE_5_INTERPRETABILITY = Fuzzy.HIGH;
    static final Fuzzy DM3_ALTERNATIVE_5_COMPLEXITY = Fuzzy.VERY_LOW;
    static final Fuzzy DM3_ALTERNATIVE_5_ACCURACY = Fuzzy.HIGH;
    static final Fuzzy DM3_ALTERNATIVE_5_MAINTAINABILITY = Fuzzy.AVERAGE;
    static final Fuzzy DM3_ALTERNATIVE_5_SPEED = Fuzzy.VERY_HIGH;

  static final Fuzzy DM3_ALTERNATIVE_6_CAUSALITY = Fuzzy.VERY_LOW;
    static final Fuzzy DM3_ALTERNATIVE_6_UNCERTAINTY = Fuzzy.LOW;
    static final Fuzzy DM3_ALTERNATIVE_6_MISSING = Fuzzy.LOW;
    static final Fuzzy DM3_ALTERNATIVE_6_OUTLIER = Fuzzy.LOW;
    static final Fuzzy DM3_ALTERNATIVE_6_INTERPRETABILITY = Fuzzy.HIGH;
    static final Fuzzy DM3_ALTERNATIVE_6_COMPLEXITY = Fuzzy.VERY_LOW;
    static final Fuzzy DM3_ALTERNATIVE_6_ACCURACY = Fuzzy.HIGH;
    static final Fuzzy DM3_ALTERNATIVE_6_MAINTAINABILITY = Fuzzy.AVERAGE;
    static final Fuzzy DM3_ALTERNATIVE_6_SPEED = Fuzzy.VERY_HIGH;

  static final Fuzzy DM3_ALTERNATIVE_7_CAUSALITY = Fuzzy.VERY_LOW;
    static final Fuzzy DM3_ALTERNATIVE_7_UNCERTAINTY = Fuzzy.VERY_HIGH;
    static final Fuzzy DM3_ALTERNATIVE_7_MISSING = Fuzzy.VERY_HIGH;
    static final Fuzzy DM3_ALTERNATIVE_7_OUTLIER = Fuzzy.AVERAGE;
    static final Fuzzy DM3_ALTERNATIVE_7_INTERPRETABILITY = Fuzzy.HIGH;
    static final Fuzzy DM3_ALTERNATIVE_7_COMPLEXITY = Fuzzy.VERY_LOW;
    static final Fuzzy DM3_ALTERNATIVE_7_ACCURACY = Fuzzy.HIGH;
    static final Fuzzy DM3_ALTERNATIVE_7_MAINTAINABILITY = Fuzzy.AVERAGE;
    static final Fuzzy DM3_ALTERNATIVE_7_SPEED = Fuzzy.VERY_HIGH;

  static final Fuzzy DM3_ALTERNATIVE_8_CAUSALITY = Fuzzy.VERY_LOW;
    static final Fuzzy DM3_ALTERNATIVE_8_UNCERTAINTY = Fuzzy.LOW;
    static final Fuzzy DM3_ALTERNATIVE_8_MISSING = Fuzzy.LOW;
    static final Fuzzy DM3_ALTERNATIVE_8_OUTLIER = Fuzzy.AVERAGE;
    static final Fuzzy DM3_ALTERNATIVE_8_INTERPRETABILITY = Fuzzy.VERY_LOW;
    static final Fuzzy DM3_ALTERNATIVE_8_COMPLEXITY = Fuzzy.LOW;
    static final Fuzzy DM3_ALTERNATIVE_8_ACCURACY = Fuzzy.AVERAGE;
    static final Fuzzy DM3_ALTERNATIVE_8_MAINTAINABILITY = Fuzzy.VERY_LOW;
    static final Fuzzy DM3_ALTERNATIVE_8_SPEED = Fuzzy.HIGH;
    //DM4
    static final Fuzzy DM4_ALTERNATIVE_1_CAUSALITY = Fuzzy.AVERAGE;
    static final Fuzzy DM4_ALTERNATIVE_1_UNCERTAINTY = Fuzzy.AVERAGE;
    static final Fuzzy DM4_ALTERNATIVE_1_MISSING = Fuzzy.AVERAGE;
    static final Fuzzy DM4_ALTERNATIVE_1_OUTLIER = Fuzzy.HIGH;
    static final Fuzzy DM4_ALTERNATIVE_1_INTERPRETABILITY = Fuzzy.VERY_LOW;
    static final Fuzzy DM4_ALTERNATIVE_1_COMPLEXITY = Fuzzy.VERY_HIGH;
    static final Fuzzy DM4_ALTERNATIVE_1_ACCURACY = Fuzzy.VERY_HIGH;
    static final Fuzzy DM4_ALTERNATIVE_1_MAINTAINABILITY = Fuzzy.HIGH;
    static final Fuzzy DM4_ALTERNATIVE_1_SPEED = Fuzzy.VERY_LOW;

  static final Fuzzy DM4_ALTERNATIVE_2_CAUSALITY = Fuzzy.VERY_HIGH;
    static final Fuzzy DM4_ALTERNATIVE_2_UNCERTAINTY = Fuzzy.VERY_HIGH;
    static final Fuzzy DM4_ALTERNATIVE_2_MISSING = Fuzzy.AVERAGE;
    static final Fuzzy DM4_ALTERNATIVE_2_OUTLIER = Fuzzy.HIGH;
    static final Fuzzy DM4_ALTERNATIVE_2_INTERPRETABILITY = Fuzzy.HIGH;
    static final Fuzzy DM4_ALTERNATIVE_2_COMPLEXITY = Fuzzy.HIGH;
    static final Fuzzy DM4_ALTERNATIVE_2_ACCURACY = Fuzzy.AVERAGE;
    static final Fuzzy DM4_ALTERNATIVE_2_MAINTAINABILITY = Fuzzy.AVERAGE;
    static final Fuzzy DM4_ALTERNATIVE_2_SPEED = Fuzzy.VERY_HIGH;

  static final Fuzzy DM4_ALTERNATIVE_3_CAUSALITY = Fuzzy.AVERAGE;
    static final Fuzzy DM4_ALTERNATIVE_3_UNCERTAINTY = Fuzzy.AVERAGE;
    static final Fuzzy DM4_ALTERNATIVE_3_MISSING = Fuzzy.LOW;
    static final Fuzzy DM4_ALTERNATIVE_3_OUTLIER = Fuzzy.LOW;
    static final Fuzzy DM4_ALTERNATIVE_3_INTERPRETABILITY = Fuzzy.VERY_HIGH;
    static final Fuzzy DM4_ALTERNATIVE_3_COMPLEXITY = Fuzzy.LOW;
    static final Fuzzy DM4_ALTERNATIVE_3_ACCURACY = Fuzzy.HIGH;
    static final Fuzzy DM4_ALTERNATIVE_3_MAINTAINABILITY = Fuzzy.LOW;
    static final Fuzzy DM4_ALTERNATIVE_3_SPEED = Fuzzy.VERY_HIGH;

  static final Fuzzy DM4_ALTERNATIVE_4_CAUSALITY = Fuzzy.VERY_HIGH;
    static final Fuzzy DM4_ALTERNATIVE_4_UNCERTAINTY = Fuzzy.AVERAGE;
    static final Fuzzy DM4_ALTERNATIVE_4_MISSING = Fuzzy.HIGH;
    static final Fuzzy DM4_ALTERNATIVE_4_OUTLIER = Fuzzy.AVERAGE;
    static final Fuzzy DM4_ALTERNATIVE_4_INTERPRETABILITY = Fuzzy.VERY_HIGH;
    static final Fuzzy DM4_ALTERNATIVE_4_COMPLEXITY = Fuzzy.LOW;
    static final Fuzzy DM4_ALTERNATIVE_4_ACCURACY = Fuzzy.AVERAGE;
    static final Fuzzy DM4_ALTERNATIVE_4_MAINTAINABILITY = Fuzzy.HIGH;
    static final Fuzzy DM4_ALTERNATIVE_4_SPEED = Fuzzy.VERY_LOW;

  static final Fuzzy DM4_ALTERNATIVE_5_CAUSALITY = Fuzzy.LOW;
    static final Fuzzy DM4_ALTERNATIVE_5_UNCERTAINTY = Fuzzy.LOW;
    static final Fuzzy DM4_ALTERNATIVE_5_MISSING = Fuzzy.LOW;
    static final Fuzzy DM4_ALTERNATIVE_5_OUTLIER = Fuzzy.AVERAGE;
    static final Fuzzy DM4_ALTERNATIVE_5_INTERPRETABILITY = Fuzzy.HIGH;
    static final Fuzzy DM4_ALTERNATIVE_5_COMPLEXITY = Fuzzy.VERY_LOW;
    static final Fuzzy DM4_ALTERNATIVE_5_ACCURACY = Fuzzy.HIGH;
    static final Fuzzy DM4_ALTERNATIVE_5_MAINTAINABILITY = Fuzzy.HIGH;
    static final Fuzzy DM4_ALTERNATIVE_5_SPEED = Fuzzy.AVERAGE;

  static final Fuzzy DM4_ALTERNATIVE_6_CAUSALITY = Fuzzy.LOW;
    static final Fuzzy DM4_ALTERNATIVE_6_UNCERTAINTY = Fuzzy.LOW;
    static final Fuzzy DM4_ALTERNATIVE_6_MISSING = Fuzzy.LOW;
    static final Fuzzy DM4_ALTERNATIVE_6_OUTLIER = Fuzzy.AVERAGE;
    static final Fuzzy DM4_ALTERNATIVE_6_INTERPRETABILITY = Fuzzy.HIGH;
    static final Fuzzy DM4_ALTERNATIVE_6_COMPLEXITY = Fuzzy.VERY_LOW;
    static final Fuzzy DM4_ALTERNATIVE_6_ACCURACY = Fuzzy.HIGH;
    static final Fuzzy DM4_ALTERNATIVE_6_MAINTAINABILITY = Fuzzy.HIGH;
    static final Fuzzy DM4_ALTERNATIVE_6_SPEED = Fuzzy.AVERAGE;

  static final Fuzzy DM4_ALTERNATIVE_7_CAUSALITY = Fuzzy.VERY_LOW;
    static final Fuzzy DM4_ALTERNATIVE_7_UNCERTAINTY = Fuzzy.HIGH;
    static final Fuzzy DM4_ALTERNATIVE_7_MISSING = Fuzzy.HIGH;
    static final Fuzzy DM4_ALTERNATIVE_7_OUTLIER = Fuzzy.LOW;
    static final Fuzzy DM4_ALTERNATIVE_7_INTERPRETABILITY = Fuzzy.AVERAGE;
    static final Fuzzy DM4_ALTERNATIVE_7_COMPLEXITY = Fuzzy.AVERAGE;
    static final Fuzzy DM4_ALTERNATIVE_7_ACCURACY = Fuzzy.HIGH;
    static final Fuzzy DM4_ALTERNATIVE_7_MAINTAINABILITY = Fuzzy.AVERAGE;
    static final Fuzzy DM4_ALTERNATIVE_7_SPEED = Fuzzy.VERY_HIGH;

  static final Fuzzy DM4_ALTERNATIVE_8_CAUSALITY = Fuzzy.LOW;
    static final Fuzzy DM4_ALTERNATIVE_8_UNCERTAINTY = Fuzzy.AVERAGE;
    static final Fuzzy DM4_ALTERNATIVE_8_MISSING = Fuzzy.AVERAGE;
    static final Fuzzy DM4_ALTERNATIVE_8_OUTLIER = Fuzzy.LOW;
    static final Fuzzy DM4_ALTERNATIVE_8_INTERPRETABILITY = Fuzzy.LOW;
    static final Fuzzy DM4_ALTERNATIVE_8_COMPLEXITY = Fuzzy.HIGH;
    static final Fuzzy DM4_ALTERNATIVE_8_ACCURACY = Fuzzy.AVERAGE;
    static final Fuzzy DM4_ALTERNATIVE_8_MAINTAINABILITY = Fuzzy.LOW;
    static final Fuzzy DM4_ALTERNATIVE_8_SPEED = Fuzzy.AVERAGE;

    public static String[] alternatives = new String[]{"ANN", "BBN", "DT", "FRBC", "LogR", "NB", "SVM"};
  public static List<Alternative> alternativeList = new ArrayList<>();
  static String[] dms = new String[]{"DM1", "DM2", "DM3", "DM4"};
  static Map<Alternative, List<Fuzzy>> dm1Evals = new HashMap<>();
    static Map<Alternative, List<Fuzzy>> dm2Evals = new HashMap<>();
    static Map<Alternative, List<Fuzzy>> dm3Evals = new HashMap<>();
    static Map<Alternative, List<Fuzzy>> dm4Evals = new HashMap<>();
    static DecimalFormat formatter = new DecimalFormat("0.000");


}
