package homework2;
import java.io.*;
import java.util.*;

public class car {

	String vin;
	String brand;
	String model;
	int year;
	int mileage;
	double price;
	String color;
	boolean blandnew;
	
	public car()
	{
		vin = null;
		brand = null;
		model = null;
		year = 0;
		mileage = 0;
		price = 0.00;
		color = null;
		blandnew = false;
	}
	
	public void setVin(String v)
	{ 
		vin = v;
	}
	public String getVin()
	{
		return vin;
	}
	
	public void setBrand(String v)
	{ 
		brand = v;
	}
	public String getBrand()
	{
		return brand;
	}
	
	public void setModel(String v)
	{ 
		model = v;
	}
	public String getModel()
	{
		return model;
	}
	public void setYear(int v)
	{ 
		
		year = v;
	}
	public int getYear()
	{
		return year;
	}
	public void setMileage(int v)
	{ 
		
		mileage = v;
	}
	public int getMileage()
	{
		return mileage;
	}
	public void setPrice(double v)
	{ 
		price = v;
	}
	public double getPrice()
	{
		return price;
	}
	public void setColor(String v)
	{ 
		color = v;
	}
	public String getColor()
	{
		return color;
	}
	public void setBland(char v)
	{ 
		if(v == 'Y')
			blandnew = true;
	}
	public char getBland()
	{
		if(blandnew)
		{
			return 'Y';
		}
		
		return 'N';
	}
	
	
	
}