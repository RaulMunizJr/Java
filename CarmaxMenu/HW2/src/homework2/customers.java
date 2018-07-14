package homework2;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
public class customers {  

	ArrayList<Member> mem = new ArrayList<Member>(0);
	File cus = new File("customers.txt");
	//System.out.printf("%-20s %s\n", Name, Income); // Print formated
	
	
	public customers() throws IOException 
	{
		CustomerRead();
	}
	
	public void CustomerRead ()throws IOException 
	{ 
		BufferedReader br = new BufferedReader(new FileReader(cus));
	    String line = null;
	    String []tokens =  new String[5];
     	mem.clear();
	    while ((line = br.readLine()) != null)
	    {
		    tokens =  line.split("/");
		    Member this_mem = new Member();
		    	this_mem.setId(tokens[0]);
		    	this_mem.setPass(tokens[1]);
		    	this_mem.setFirstName(tokens[2]);
		    	this_mem.setLastName(tokens[3]);
		    	this_mem.setEmail(tokens[4]);
	    	    mem.add(this_mem);
	    }
	    br.close();
	}

	public boolean CustomerRead (String id, String pass)throws IOException{

		boolean same_id = false;
		boolean same_pass = false;
		String []tokens =  new String[2];
		BufferedReader br = new BufferedReader(new FileReader(cus));
	    String line = null;
	    while ((line = br.readLine()) != null) 
	    {
	       tokens =  line.split("/");
	       Member this_mem = new Member();
	    	   this_mem.setId(tokens[0]);
	    	  
	    	   if(Objects.equals(id, tokens[0]))
	    		  same_id = true;
	    	   
	    	   this_mem.setPass(tokens[1]);
	    	   if(Objects.equals(pass, tokens[1]))
	    		   same_pass = true;
	    }
	    br.close();

	    if(same_id&&same_pass)
	    {
	    		return true;
	    }
	    
	    return false;
	    
	    
}
	public void displayCustomers()
	{
		
		System.out.println();
		System.out.printf("%-12s %-14s %-14s %-12s %-30s \n", "Id", "Password","FirstName","LastName","Email");

		for(int i=0;i<mem.size();i++) {
			if(mem.get(i).getId() == null)
				break;
			else  
			{
				System.out.printf("%-12s %-14s %-14s %-12s %-30s",mem.get(i).getId(),mem.get(i).getPass(),
						mem.get(i).getFirstName(),mem.get(i).getLastName(),mem.get(i).getEmail());
				System.out.println();
			}
		}
		System.out.println();
	}
	
	public void addCustomer()
	{
		String []tokens =  new String[6];
		Scanner s = new Scanner(System.in);
		Scanner s1 = new Scanner(System.in);
		try(FileWriter fw = new FileWriter(cus, true);
			    BufferedWriter bw = new BufferedWriter(fw);
			    PrintWriter out = new PrintWriter(bw))
			{
			
				if(cus.length()==0)
				{
					System.out.print("\nPlease input user Id: ");
				    tokens[0] = s.next();
				    out.print(tokens[0] + "/");
				}
				else
				{
					System.out.print("\nPlease input user Id: ");
				    tokens[0] = s.next();
				    out.print("\n" + tokens[0] + "/");
				}
			    
				
				do 
				{
					System.out.print("Please input password: ");
				    tokens[1] = s.next();
				    System.out.print("Please input password again: ");
				    tokens[2] = s1.next();
				    
				    if(!(Objects.equals(tokens[1], tokens[2])))
				    {
				    		System.out.println("\nPassword does not match. Try again\n");
				    		continue;
				    }
				    else
				    		break;
				    
				}while(true);
			    
			    out.print(tokens[1] + "/");
			    
			    System.out.print("Please input your first name: ");
			    tokens[3] = s.next();
			    out.print(tokens[3] + "/");
			    
			    System.out.print("Please input your last name: ");
			    tokens[4] = s.next();
			    out.print(tokens[4]+"/");
			    
			    System.out.print("Please input your email: ");
			    tokens[5] = s.next();
			    out.print(tokens[5]);

			} catch (IOException e) {
			    //exception handling left as an exercise for the reader
			}
	}
	
	public void deleteUser() throws IOException
	{
		Scanner s = new Scanner(System.in);
		String delete = null;
		displayCustomers();
		int index=0;
		outerloop:
		do
		{
			System.out.print("Please input ID: ");
			delete = s.next();
			for(int i=0; i<mem.size(); i++)
			{
				if(delete.matches(mem.get(i).getId()))
				{
					index = i;
					break outerloop;
				}
			}
			System.out.println("\nWrond ID. Please try again\n");
		}while(true);
		
		System.out.println("\n" + mem.get(index).getId() + " has been deleted!");
		
		mem.remove(index);
		
		rewrite();
		CustomerRead();
		displayCustomers();
		
	}
	public void updateUser() throws IOException
	{
		Scanner s = new Scanner(System.in);
		int choice = 0;
		int index = 0;
		String id = null;
		String update = null;
		displayCustomers();
		
		do
		{
			System.out.print("\nPlease input ID: ");
			id = s.next();
			for(int i=0; i<mem.size(); i++)
			{
				if(!(Objects.equals(mem.get(mem.size()-1).getId(), id))) 
				{
					System.out.println("\nID does not exist. Please try again");
					break;
				}
				if(Objects.equals(mem.get(i).getId(), id))
				{
					index = i;
					break;
				}
			}
		}while(!(Objects.equals(mem.get(index).getId(), id)));
			
		System.out.println("\n1. Update password");
		System.out.println("2. Update first name");
		System.out.println("3. Update last name");
		System.out.println("4. Update email");
		System.out.print("\nPlease input: ");
		choice = s.nextInt();
		
		if(choice == 1)
		{
			System.out.print("\nPlease input new password: ");
			update = s.next();
			mem.get(index).setPass(update);
		}
		else if(choice == 2)
		{
			System.out.print("\nPlease input new first name: ");
			update = s.next();
			mem.get(index).setFirstName(update);
		}
		else if(choice == 3)
		{
			System.out.print("\nPlease input new last name: ");
			update = s.next();
			mem.get(index).setLastName(update);
		}
		else
		{
			System.out.print("\nPlease input new email: ");
			update = s.next();
			mem.get(index).setEmail(update);
		}
		
		rewrite();
		displayCustomers();

		
	}
	
	public void rewrite() throws IOException
	{
		
		FileWriter fooWriter = new FileWriter(cus, false); 
		                                                
		for(int i=0; i<mem.size(); i++)
		{
			if(i == (mem.size()-1)) 
			{
				fooWriter.write(mem.get(i).getId() + "/" +mem.get(i).getPass() + "/" +
					    mem.get(i).getFirstName() + "/"+mem.get(i).getLastName() + "/" + mem.get(i).getEmail());
			}
			else
			{
				fooWriter.write(mem.get(i).getId() + "/" +mem.get(i).getPass() + "/" +
					    mem.get(i).getFirstName() + "/"+mem.get(i).getLastName() + "/" + mem.get(i).getEmail() + "\n");
			}
			
		}
		
		fooWriter.close();
	}
}