package tr.edu.hacettepe.da4esdp.entity;

import java.util.List;

public class Dto {
  List<Criteria> criteriaList;
  List<Alternative> alternativeList;

  public Dto() {
  }

  public Dto(List<Criteria> criteriaList, List<Alternative> alternativeList) {
    this.criteriaList = criteriaList;
    this.alternativeList = alternativeList;
  }

  public List<Criteria> getCriteriaList() {
    return criteriaList;
  }

  public void setCriteriaList(List<Criteria> criteriaList) {
    this.criteriaList = criteriaList;
  }

  public List<Alternative> getAlternativeList() {
    return alternativeList;
  }

  public void setAlternativeList(List<Alternative> alternativeList) {
    this.alternativeList = alternativeList;
  }


}
