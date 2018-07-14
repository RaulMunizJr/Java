import java.util.Scanner;

public class ComputerNetwork 
{
   static int network[][];
   static int infected[];
  
   public static void numInfected(int comp, int n)
   {   
       for(int i=0;i<n;i++){
           if(network[comp][i] == 1)
           {
               infected[i] = 1;
               numInfected(i, n);
           }
       }
     
   }
  
   public static void main(String[] args) 
   {
       Scanner input = new Scanner(System.in); 
       System.out.println("Input:");
       int numComp = input.nextInt();
       int numEdges = input.nextInt();
      
       network = new int[numComp][numComp];
       infected = new int[numComp];

       for(int i=0;i<numComp;i++)
       {
           for(int j=0;j<numComp;j++)
           {
               network[i][j] = 0;
           }
           infected[i] = 0;
       }
      
       for(int i=0;i<numEdges;i++)
       {
           int x = input.nextInt();
           int y = input.nextInt();

           network[x-1][y-1] = 1;      
       }
       int infectedComp = input.nextInt();
       infected[infectedComp-1] = 1;
      
       numInfected(infectedComp-1, numComp);
      
       int result = 0;
       for(int i=0;i<numComp;i++)
       {
           if(infected[i] == 1){
               result++;
           }
       }

       System.out.println("Output:\n"+(result-1));
       input.close();
   }
}