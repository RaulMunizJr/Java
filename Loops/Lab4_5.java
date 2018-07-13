import java.util.Scanner;

//Raul Muniz
//Jan 31, 2018
//Lab 4-5

public class Lab4_5 {

	public static void main(String[] args) {
		
		System.out.println("Start Game");
		Scanner in = new Scanner(System.in);
		boolean decision = false;
		do 
		{
		System.out.println("1. Rock");
		System.out.println("2. Paper");
		System.out.println("3. Scissors");
		System.out.print("What do you want to throw? ");
		
		String choice = in.nextLine();
		int randNum=((int)(Math.random()*100))%3+1;
		String compChoice = "blank";
		//------------------------
		if(choice.equals("1"))
		{
			choice = "Rock";
		}
		else if(choice.equals("2"))
		{
			choice = "Paper";
		}
		else
		{
			choice = "Sissors";
		}
		//------------------------
		if(randNum==1)
		{
			compChoice = "Rock";
		}
		else if(randNum==2)
		{
			compChoice = "Paper";
		}
		else
		{
			compChoice = "Sissors";
		}
		//------------------------
		System.out.println("\nComputer: "+compChoice+" vs You: "+choice);
		//------------------------
		if(choice.equals(compChoice))
		{
			System.out.println("\nIt's a draw!!!");
		}
		else if(choice == "Rock" && compChoice == "Sissors" || choice == "Paper" && compChoice == "Rock"
				|| choice == "Sissors" && compChoice == "Paper")
		{
			System.out.println("\nYou Win!!!");
		}
		else {
			System.out.println("\nYou Lose!!!");
		}
		//------------------------
		System.out.println("Would you like to play again(y/n)?");
		String userInput = in.nextLine();
		if(userInput.equals("n")||userInput.equals("N"))
		{
			decision = false;
		}
		else {
			decision = true;
		}
		}while(decision);
		System.out.println("Thank you!!!");
		}
	}