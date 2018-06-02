import java.util.Scanner;

//Raul Muniz
//Jan 29, 2018
//Lab 3-1
public class Lab3_4 {
	public static void main(String[] args)
	{
		System.out.print("Random number generation: ");
		//Scanner in = new Scanner(System.in);
		int num = 3;
		int randNum=((int)(Math.random()*100))%num+1;
		System.out.println(randNum);
		
	}
}
