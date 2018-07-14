import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class RoundRobin
{
   //**********************************************
   // Variables
   double arrivalTime[] = new double[500];
   double process[] = new double[500];
   double serviceTime[] = new double[500];
   int size = 0;
   double quantum;
   //***********************************************
  
   // Functions to get started
   public void getData() throws FileNotFoundException
   {
       // VAriables for this function
       Scanner cin = new Scanner(System.in);
       Scanner scanner = new Scanner(new File("test.txt"));
       int i = 0;
      
       System.out.println("Please enter how many processes we will be working with today? ");
       size = cin.nextInt();
      
      
       // Add processes
       while(scanner.hasNext() || i < size)
       {
           arrivalTime[i] = scanner.nextInt();
           serviceTime[i] = scanner.nextFloat();
           process[i] = i + 1;
           i++;
       }
      
       System.out.println("Please enter the qunatum: ");
       quantum = cin.nextDouble();
      
   }
  
   public void displayData()
   {
       System.out.println("Process ID || Execution Time || Arrival Time ");
       for(int i = 0; i < size; i++)
       {
           System.out.println(i + 1 + " " + serviceTime[i] + " " + arrivalTime[i]);
       }
   }
  
   public void calculate_wt_tt()
   {
       // More variables
       double servicesTwo[] = new double[500];
       boolean flag = true; // 1
       boolean flag2 = false; // 0
       double a_t = 0, wt = 0, tnt = 0;
       float avg = 0, avtnt = 0;
      
       // Copy the data
       for (int i = 0; i<size; i++)
       {
           servicesTwo[i] = serviceTime[i];
       }
      
       a_t = arrivalTime[0];
       System.out.println("Process ID || Wait Time || Turn around Time ");
      
       while(flag)
       {
           for (int i = 0; i<size; i++)
           {
               if (a_t < arrivalTime[i] || process[i]<0)
               {
                   continue;
               }
              
               flag2= true;
               a_t += quantum;
               serviceTime[i] -= quantum;
              
               if (serviceTime[i] <= 0)
               {
                   a_t += serviceTime[i];
                   wt = a_t - servicesTwo[i] - arrivalTime[i];
                   tnt = a_t - arrivalTime[i];
                   System.out.println(process[i] + " " + wt + " " + tnt);
                   process[i] = -1;
                   avg += wt;
                   avtnt += tnt;
               }
           }
          
           if (flag2 == false)
           {
               a_t++;
           }
          
           flag2 = flag = false;
           for (int k = 0; k < size; k++)
           {
               if (process[k] != -1)
               {
                   flag = true;
               }
           }
          
       }
       avg = avg / (float)size;
       avtnt /= (float)size;
      
       System.out.println("Average Waiting Time: " + avg);
       System.out.println("Average turn around time: " + avtnt);
      
   }
  
  
   // main method to test if it works
   public static void main(String[] args) throws FileNotFoundException
   {
       RoundRobin rr = new RoundRobin();
       rr.getData();
   rr.displayData();
   rr.calculate_wt_tt();
   }
  

}