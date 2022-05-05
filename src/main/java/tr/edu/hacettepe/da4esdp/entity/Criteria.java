package tr.edu.hacettepe.da4esdp.entity;

import javax.persistence.*;

@Entity
public class Criteria {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String name;
  private boolean checked;
  private Weight weight;
  private boolean cost;

  public Criteria(String name, Weight weight) {
    this.name = name;
    this.weight = weight;
  }

  public Criteria() {

  }

  @Id
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @OneToOne(targetEntity = Weight.class, mappedBy = "criteria",
    fetch = FetchType.EAGER)
  public Weight getWeight() {
    return weight;
  }

  public void setWeight(Weight weight) {
    this.weight = weight;
  }

  @Override
  public String toString() {
    return "Criteria is " + getName() + ". Weights: "
      + getWeight().getA() + " "
      + getWeight().getB() + " "
      + getWeight().getC();
  }

  public boolean isChecked() {
    return checked;
  }

  public void setChecked(boolean checked) {
    this.checked = checked;
  }

  public boolean isCost() {
    return cost;
  }

  public void setCost(boolean cost) {
    this.cost = cost;
  }
}
