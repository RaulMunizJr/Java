import java.awt.Component;
import javax.swing.JOptionPane;
class ComputeLoan
{
  public static void main(String[] args) 
  {   
    int maxTries = 3;
    int count = 0;
    //********************************************************
    //Inputs
    while(true)
    {
    	try
    	{
    		 double annualInterestRate, monthlyInterestRate, loanAmount, monthlyPayment, totalPayment;
    		   int numberOfYears, endProgram = 0;
    			  
    		    String annualInterestRateString = JOptionPane.showInputDialog(
    		      "Enter annual interest rate, e.g., 8.25:");
    		    
    		    String numberOfYearsString = JOptionPane.showInputDialog( 
    		    	      "Enter number of years as an integer, \ne.g., 5:");

    		    String loanString = JOptionPane.showInputDialog( 
    		    	      "Enter loan amount, e.g., 120000.95:");
    		    
    		annualInterestRate =
    				Double.parseDouble(annualInterestRateString);
    
    		monthlyInterestRate = annualInterestRate / 1200;
    
    		numberOfYears = Integer.parseInt(numberOfYearsString);
    
    		loanAmount = Double.parseDouble(loanString);
    
    		monthlyPayment = loanAmount * monthlyInterestRate / (1 
    				- 1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12));
    
    		totalPayment = monthlyPayment * numberOfYears * 12;
    		monthlyPayment = (int)(monthlyPayment * 100) / 100.0;
    	    totalPayment = (int)(totalPayment * 100) / 100.0;
    	    
    	    // Display results
    	    String output = "The monthly payment is $" + monthlyPayment + 
    	      "\nThe total payment is $" + totalPayment;
    	    JOptionPane.showMessageDialog(null, output);
    	    break;
    	}
    	catch(NumberFormatException nfe)
    	{
    		
    		Component frame = null;
    		JOptionPane.showMessageDialog(frame,
    				"One or more of the inputs was not an integer, try again.",
    				"Incorrect input error",
    				JOptionPane.ERROR_MESSAGE);
    		
    		if(++count == maxTries) throw nfe;
    	}
    }
    //************************************************************
    
    

  }
}