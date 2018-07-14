import java.util.*;
import java.io.*;

class RouteMap
{

public static void main(String[] args) throws IOException
{

	FileReader file = new FileReader("input.txt");
	int[] number = new int [100];
	int i=0;
	try {
		Scanner input = new Scanner(file);

		while(input.hasNext())
		{
			number[i] = input.nextInt();	
			i++;
		}
		input.close();
		}

		catch(Exception bus)
		{
			bus.printStackTrace();
		}

		int n = number[0];
		int line = number[1];
		int arr [][] = new int[line][2];
		int k = 0;
		int res[] = new int[5];

		for(int j=2; j<i; j=j+2)
		{
			arr[k][0] = number[j];
			arr[k][1] = number[j+1];

			if(arr[k][1] == 0)
			{
				arr[k][1] = n;
			}
			if(arr[k][0] > arr[k][1])
			{
			arr[k][0] = arr[k][0]-n;
			}
			k++;
			}

		for(int j=0;j<line;j++)
		{
			res[j]=1;
		}
		for(int j=0;j<line;j++)
		{
			for(k=0;k<line;k++)
			{
				if(arr[k][0]>=arr[j][0] && arr[k][1]<=arr[j][1] && j!=k)
				{
				res[k]=0;
				}

			}

		}
		for(i=0;i<line;i++)
		{
			if(res[i]==1)
			{
				System.out.print((i+1)+" ");
			}

		}
	}
}