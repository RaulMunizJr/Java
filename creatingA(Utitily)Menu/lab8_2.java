//Raul Muniz
//02-26-2018
//Lab 8-2
package lab8;
import java.util.*;

public class lab8_2 {

	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		int input=0;
		menu m=new menu();
		while(input!=4)
		{
			m.mainmenu();
			input=in.nextInt();
			
			if(input==1)
			{
				int temp=0;
				m.utility();
				temp=in.nextInt();
				
				while(temp<=3)
				{
					System.out.println("I am sorry. It's not ready yet");
					m.utility();
					temp=in.nextInt();
				}
				if(temp==4)
					continue;
					
			}
			
			else if(input==2)
			{

				int temp=0;
				m.game();
				temp=in.nextInt();
				
				while(temp<=2)
				{
					System.out.println("I am sorry. It's not ready yet");
					m.game();
					temp=in.nextInt();
				}
				if(temp==3)
					continue;
			}
			
			else if(input==3)
			{

				int temp=0;
				m.multimedia();
				temp=in.nextInt();
				
				while(temp<=3)
				{
					System.out.println("I am sorry. It's not ready yet");
					m.multimedia();
					temp=in.nextInt();
				}
				if(temp==4)
					continue;
			}
			
			else if(input==4)
			{
				System.out.println("Thank you! Bye~");
				break;
			}
			else
				System.out.println("I am sorry please input correctly");
				continue;
			}
	}
}