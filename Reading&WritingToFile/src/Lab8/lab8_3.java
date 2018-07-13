//Raul Muniz
//02-26-2018
//Lab 8-2
package Lab8;
import java.io.*;
import java.util.*;

public class lab8_3 
{
	
	public static void main(String args[]) throws FileNotFoundException
	{
		char ch='y';
		Scanner in=new Scanner(System.in);
		PrintWriter op=new PrintWriter("ids.txt");
		PrintWriter op2=new PrintWriter("pwds.txt");
		while(ch=='y')
		{
			
			String id="";
			String pwd="";
			System.out.print("Enter ID: ");
			id=in.next();
			System.out.print("Enter password: ");
			pwd=in.next();
			op.println(id);
			op2.println(pwd);
			System.out.print("Do you wanna input more?");
			ch=in.next().charAt(0);
		}
		
		op.close();
		op2.close();
		
		if (ch=='n')
		{
			File file=new File("ids.txt");
			File file2=new File("pwds.txt");
			
			Scanner in1=new Scanner(file);
			Scanner in2=new Scanner(file2);
			
			while(in1.hasNext() && in2.hasNext())
			{
				String x=in1.next();
				String y=in2.next();
				System.out.println(x);
				System.out.println(y);
			}
			
			in1.close();
			in2.close();
			
		}
		in.close();
		op.close();
		op2.close();
	}
}