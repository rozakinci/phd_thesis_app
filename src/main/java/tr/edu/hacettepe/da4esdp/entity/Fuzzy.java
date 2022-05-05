package tr.edu.hacettepe.da4esdp.entity;

public enum Fuzzy {

  VERY_LOW(1, 1, 3),
  LOW(1, 3, 5),
  AVERAGE(3, 5, 7),
  HIGH(5, 7, 9),
  VERY_HIGH(7, 9, 9),
  OTHER(0, 0, 0);

  private double a;
  private double b;
  private double c;

  Fuzzy(double a, double b, double c) {
    this.a = a;
    this.b = b;
    this.c = c;
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
}
