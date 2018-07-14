

import java.util.Scanner; 
import java.util.Random; 

public class Pacman 
{
	public static void main(String[] args) throws InterruptedException
	{
		
		
		//Variables
		int nrow=5;
		int ncol=10; 
		char mrClean='@';
		int randomX=0;
		int randomY=0;
		int Area=0; 
		int counter=0; 
		Random randomNumbers= new Random();
		Scanner in= new Scanner(System.in);
		
		System.out.print("Input the number of rows: ");
		nrow=in.nextInt();
		System.out.print("\nInput the number of colums: ");
		ncol=in.nextInt();
		
		
		while(nrow<3 || ncol<3)
		{
			System.out.println("\nPlease Input a number greater than 2");
			System.out.print("\nInput the number of rows: ");
			nrow=in.nextInt();
			System.out.print("\nInput the number of colums: ");
			ncol=in.nextInt();
		}
		
		char [][] spaceToClean= new char[nrow][ncol];
		//Fills the array
		for(int i=0; i<nrow; i++)
		{
			for(int j=0; j<ncol; j++)
				spaceToClean[i][j]='*';
			
		}
	
		//MrClean stars to clean
		spaceToClean[1][1]=mrClean;
		System.out.print("\n\n");
		
		for(int i=0; i<nrow; i++)
		{
		
			for(int j=0; j<ncol; j++)
			System.out.print(spaceToClean[i][j]+" ");
			System.out.println();	
		}
		
		//Calculates the Area of the room minus the sides
		Area=(nrow-2)*(ncol-2);

		spaceToClean[1][1]=' ';
		
		//Loop to clean the trash in the room
		//Stops until area is equal empty spaces
		while(true)
		{
			Thread.sleep(500); 
			randomX=randomNumbers.nextInt(ncol);
			randomY=randomNumbers.nextInt(nrow);
			
			 
			if ((randomY>=1 && randomY<=nrow-2) && (randomX>=1 && randomX<=ncol-2))	
			{	
				spaceToClean[randomY][randomX]=mrClean;
				
				System.out.print("\n\n");
				
				for(int i=0; i<nrow; i++)
				{
					for(int j=0; j<ncol; j++)
						System.out.print(spaceToClean[i][j]+" ");
					System.out.println();	
				}
				
				spaceToClean[randomY][randomX]=' ';
			}
			for(int i=0; i<nrow; i++)
			{
				for(int j=0; j<ncol; j++)
					
					if(spaceToClean[i][j]==' ')
						counter++;
			}
			if(counter==Area)
			break;
			
			counter=0; 		
		}
		
		System.out.print("Game Over");
	}
}

