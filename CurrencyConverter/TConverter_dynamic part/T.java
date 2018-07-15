package TConverter;


public class T{
   private double c; 
   private double f; 
   
  public T(double c, double f) {
    this.c = c;
    this.f = f;
  }

  public double getCelsius() {
    double c = (f-32)*5/9;   //formula from fahrenheit to celsius
    return c;
  }

  public double getFarenheits() {
    double f =  ((c*9/5)+32);  //formula from celsius to fahrenheit
    return f;
  }

}