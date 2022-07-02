package tr.edu.hacettepe.da4esdp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Alternative {

    private final String name;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private Double score;
    private Fuzzy causality;
    private Fuzzy uncertainty;
    private Fuzzy missingData;
    private Fuzzy outlier;
    private Fuzzy interpretability;
    private Fuzzy complexity;
    private Fuzzy accuracy;
    private Fuzzy maintainability;
    private Fuzzy speed;

    public Alternative() {
        this.name = "";
    }

    public Alternative(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Fuzzy getCausality() {
        return causality;
    }

    public void setCausality(Fuzzy causality) {
        this.causality = causality;
    }

    public Fuzzy getUncertainty() {
        return uncertainty;
    }

    public void setUncertainty(Fuzzy uncertainty) {
        this.uncertainty = uncertainty;
    }

    public Fuzzy getMissingData() {
        return missingData;
    }

    public void setMissingData(Fuzzy missingData) {
        this.missingData = missingData;
    }

    public Fuzzy getOutlier() {
        return outlier;
    }

    public void setOutlier(Fuzzy outlier) {
        this.outlier = outlier;
    }

    public Fuzzy getInterpretability() {
        return interpretability;
    }

    public void setInterpretability(Fuzzy interpretability) {
        this.interpretability = interpretability;
    }

    public Fuzzy getComplexity() {
        return complexity;
    }

    public void setComplexity(Fuzzy complexity) {
        this.complexity = complexity;
    }

    public Fuzzy getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(Fuzzy accuracy) {
        this.accuracy = accuracy;
    }

    public Fuzzy getMaintainability() {
        return maintainability;
    }

    public void setMaintainability(Fuzzy maintainability) {
        this.maintainability = maintainability;
    }

    public Fuzzy getSpeed() {
        return speed;
    }

    public void setSpeed(Fuzzy speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Alternative{" + "id=" + id + ", name=" + name + '}';
    }
}
