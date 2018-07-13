
public class Car {
	private String brand="";
	private String model="";
	private int year=0;
	
	public Car(String b, String m, int y)
	{
		brand = b;
		model = m;
		year = y;
	}
	
	String getBrand()
	{
		return brand;
	}
	String getModel()
	{
		return model;
	}
	int getYear()
	{
		return year;
	}
	
}
