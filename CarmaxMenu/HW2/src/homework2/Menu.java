package homework2;
import java.io.IOException;
import java.util.*;
public class Menu {
	
	int choice=0;
	Scanner n = new Scanner(System.in);
	Scanner s = new Scanner(System.in);
	customers c = new customers();

	public Menu() throws IOException
	{
		c.CustomerRead();
		
		Member [] arr = new Member[100];
		
		
		for (int i=0; i < arr.length; i++) { 
			arr[i] = new Member();
	   			}
	}

		
	
	public void main_M() throws IOException
	{
		
		while(true)
		{
			System.out.println("\n1. Log in");
			System.out.println("2. Sign up");
			System.out.println("3. Exit");
			System.out.print("\nPlease input your choice: ");
			choice = n.nextInt();
			
			if(choice == 1)
			{
				login();
				
			}
			else if(choice == 2)
			{
				signup();
				System.out.println("\nThank you for signing up!");
				continue;
			}
			else
				System.out.println("\nThank you!");
				System.exit(0);
		}
		
	}
	public void signup() throws IOException
	{	
		customers c = new customers();
		c.addCustomer();
		
	}
	public void login() throws IOException
	{
		String id;
		String psswd;
		inventory inv = new inventory();
		customers cus = new customers();
		
		System.out.print("\nPlease input user id: ");
		id = s.nextLine();
		System.out.print("Please input password: ");
		psswd = s.nextLine();
		
		if(Objects.equals(id, new String("admin"))&&Objects.equals(psswd, new String("adminpass"))) // If Admin logs in
		{
			System.out.println("\nWelcome back " + id + "!");
			while(true) // Enter to the Admin menu
			{
				
				System.out.println("\n1. Display inventory");
				System.out.println("2. Add Car");
				System.out.println("3. Delete Car");
				System.out.println("4. Update Car");
				System.out.println("5. Display Users");
				System.out.println("6. Add User");
				System.out.println("7. Delete User");
				System.out.println("8. Update User");
				System.out.println("9. Logout");
				System.out.print("\nPlease input: ");
				choice = n.nextInt();
				
				if(choice == 1)
				{
					inv.displayInventory();
				}
				else if(choice == 2)
				{
					inv.updateInventoryFile(choice);
				}
				else if(choice == 3)
				{
					inv.deleteCar();
				}
				else if(choice == 4)
				{
					inv.updateCar();
				}
				else if(choice == 5)
				{
					cus.displayCustomers();
				}
				else if(choice == 6)
				{
					cus.addCustomer();
					cus.CustomerRead();
					cus.displayCustomers();
				}
				else if(choice == 7)
				{
					cus.deleteUser();
				}
				else if(choice == 8)
				{
					cus.updateUser();
				}
				else
				{
					main_M();
				}
				
				
			}
		}
		else 
		{
			
			if(c.CustomerRead(id, psswd)) 
			{
				System.out.println("\nWelcome back " + id + "!");
				while(true)
				{
					System.out.println("\n1. Display inventory");
					System.out.println("2. Sort cars");
					System.out.println("3. Log out");
					System.out.print("\nPlease input your choice: ");
					choice = n.nextInt();
					
					if(choice == 1)
					{
						inv.inventoryRead();
						System.out.println("\n1. New");
						System.out.println("2. Used");
						System.out.print("\nPlease input your choice: ");
						choice = n.nextInt();
						
						if(choice == 1)
						{
							inv.displayInventory(choice);
						}
						else 
						{
							inv.displayInventory(choice);
						}
						
					}
					else if(choice == 2)
					{
						inv.sortCars();
					}
					else
					{
						main_M();
					}
				}
			}
			else
			{
				main_M();
			}	
		}	
	}
	
}