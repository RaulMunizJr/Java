import java.util.Scanner;
public class Lab3_5 {
	public static void main(String[] args) 
	{
		System.out.print("Input: ");
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		int c = in.nextInt();
		int d = in.nextInt();
		
		System.out.print("Output: ");
		if(a == b && a== c && a == d)
		{
			System.out.print("Yes");
		}
		else if(a == b && c == d)
		{
			System.out.println("Yes");
		}
		else if(a == c && b == d)
		{
			System.out.println("Yes");
		}
		else if(a == d && c == b)
		{
			System.out.println("Yes");
		}
		else
		{
			System.out.println("No");
		}
	}
}