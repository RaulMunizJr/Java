import java.util.Scanner;

public class Lab2_5 {
	public static void main(String[] args)
	{
		System.out.print("What is your name? ");
		Scanner in = new Scanner(System.in);
		 String name = in.nextLine();
		 System.out.println("Hi "+name);
		System.out.print("What is your favorite sports team? ");
		 String team = in.nextLine();
		System.out.print("Do you think "+team+" will win in the league? ");
		 String answer = in.nextLine();
		 System.out.println("Thank you!");
	}
}
