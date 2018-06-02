import java.util.Scanner;

//Raul Muniz
//Jan 29, 2018
//Lab 3-1
public class Lab3 {
	public static void main(String[] args)
	{
		System.out.print("Please input an integer number: ");
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		if(num%2==0)
		{
			System.out.println(num+" is even.");
		}
		else
		{
			System.out.println(num+" is odd.");
		}
	}
}
