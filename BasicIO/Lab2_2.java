import java.util.Scanner;

public class Lab2_2 {
	// Lab 2-2
		public static void main(String[] args)
		{
			System.out.print("When were you born? ");
			Scanner in = new Scanner(System.in);
			int year = in.nextInt();
			System.out.println("Processing...");
			System.out.println("I think you are "+(2018-year)+" years old.");
		}
}