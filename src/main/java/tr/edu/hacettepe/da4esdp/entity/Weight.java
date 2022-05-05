package tr.edu.hacettepe.da4esdp.entity;

import javax.persistence.*;

@Entity
public class Weight {
  private double a;
  private double b;
  private double c;
  private Criteria criteria;
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  public Weight() {

  }

  public Weight(double a, double b, double c) {
    this.a = a;
    this.b = b;
    this.c = c;
  }

  public Weight(double w[]) {
    this.a = w[0];
    this.b = w[1];
    this.c = w[2];
  }

  public double getA() {
    return a;
  }

  public void setA(double a) {
    this.a = a;
  }

  public double getB() {
    return b;
  }

  public void setB(double b) {
    this.b = b;
  }

  public double getC() {
    return c;
  }

  public void setC(double c) {
    this.c = c;
  }

  @Id
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @OneToOne
  @JoinColumn(name = "id")
  public Criteria getCriteria() {
    return criteria;
  }

  public void setCriteria(Criteria criteria) {
    this.criteria = criteria;
  }
}
