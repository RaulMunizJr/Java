import java.util.Scanner;

public class Lab2_3 {
	// Lab 2-2
	public static void main(String[] args)
	{
		System.out.print("Please insert the first integer value? ");
		Scanner in = new Scanner(System.in);
		int val1 = in.nextInt();
		System.out.print("Please insert the second integer value? ");
		int val2 = in.nextInt();
		System.out.println("Processing...");
		System.out.println("Addition: "+(val1+val2));
		System.out.println("Subtracion: "+(val1-val2));
		System.out.println("Integer Divison: "+(val1/val2));
		System.out.println("Modulus: "+(val1%val2));
		
	}
}