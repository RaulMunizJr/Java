import java.util.Scanner;

//Raul Muniz
//Jan 29, 2018
//Lab 3-1
public class Lab3_2 {
	public static void main(String[] args)
	{
		//A = 4; B=3; C=2; D=1; F=0
		System.out.print("Please input your grades: ");
		Scanner in = new Scanner(System.in);
		String grade1 = in.nextLine();
		String grade2 = in.nextLine();
		String grade3 = in.nextLine();
		double score1 = 0.0;
		double score2 = 0.0;
		double score3 = 0.0;
		
		if(grade1.equals("A"))
		{
			score1 = 4.0;
		}
		else if(grade1.equals("B"))
		{
			score1 = 3.0;
		}
		else if(grade1.equals("C"))
		{
			score1 = 2.0;
		}
		else if(grade1.equals("D"))
		{
			score1 = 1.0;
		}
		else
		{
			score1 = 0.0;
		}
		if(grade2.equals("A"))
		{
			score2 = 4.0;
		}
		else if(grade2.equals("B"))
		{
			score2 = 3.0;
		}
		else if(grade2.equals("C"))
		{
			score2 = 2.0;
		}
		else if(grade2.equals("D"))
		{
			score2 = 1.0;
		}
		else
		{
			score2 = 0.0;
		}
		if(grade3.equals("A"))
		{
			score3 = 4.0;
		}
		else if(grade3.equals("B"))
		{
			score3 = 3.0;
		}
		else if(grade3.equals("C"))
		{
			score3 = 2.0;
		}
		else if(grade3.equals("D"))
		{
			score3 = 1.0;
		}
		else
		{
			score3 = 0.0;
		}
		
		System.out.println("Your GPA is "+(score1+score2+score3)/3);
	}
}
