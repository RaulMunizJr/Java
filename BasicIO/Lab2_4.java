import java.util.Scanner;

public class Lab2_4 {
	
	public static void main(String[] args)
	{
		System.out.print("Please input the height of the cylinder? ");
		Scanner in = new Scanner(System.in);
		double height = in.nextDouble();
		System.out.print("Please input the radius of the cylinder? ");
		double radius = in.nextDouble();
		System.out.println("Processing...");
		//Volume = pi * r^2 * h
		System.out.println("The volume of the cylinder is: "+(3.14*(radius*radius)*height));		
	}
}