import java.util.Scanner;

//Raul Muniz
//Jan 29, 2018
//Lab 3-1
public class Lab3_3 {
	public static void main(String[] args)
	{
		System.out.print("Please input three numbers: ");
		Scanner in = new Scanner(System.in);
		int num1 = in.nextInt();
		int num2 = in.nextInt();
		int num3 = in.nextInt();
		
		int max;
		int min;
		if(num1>num2)
		{
			max = num1;
		}
		else if(num2>num3)
		{
			max = num2;
		}
		else
		{
			max = num3;
		}
		if(num1<num2)
		{
			min = num1;
		}
		else if(num2<num3)
		{
			min = num2;
		}
		else
		{
			min = num3;
		}
		System.out.println("MAX: "+max);
		System.out.println("MIN: "+min);
	}
}
