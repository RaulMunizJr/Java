//Raul Muniz
//Jan 31, 2018
//Lab 4-4

public class Lab4_4 {
	public static void main(String[] args) {
		for (int i=1; i<10; i += 2)
		{
		    for (int j=0; j < (4 - i / 2); j++)
		    {
		        System.out.print(" ");
		    }
		    for (int k=0; k<i; k++)
		    {
		        System.out.print("*");
		    }
		    System.out.println();
		}

	}

}
