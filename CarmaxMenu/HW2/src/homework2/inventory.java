package homework2;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.Arrays;

public class inventory {

	ArrayList<car> car = new ArrayList<car>(0);
	String[] tokens = new String[8];
	File inv = new File("inventory.txt");
	
	public inventory() throws IOException {
		
		inventoryRead();
		
	}
	public void inventoryRead()throws IOException // Read inventory.txt and initialize Car array
	{
		BufferedReader br = new BufferedReader(new FileReader(inv));
	    String line = null;
     	car.clear();
	    while ((line = br.readLine()) != null) 
	    {
	       tokens =  line.split("/");
	       car this_car = new car();
	    	   this_car.setVin(tokens[0]);
	    	   this_car.setBrand(tokens[1]);
	    	   this_car.setModel(tokens[2]);
	    	   this_car.setYear(Integer.parseInt(tokens[3]));
	    	   this_car.setMileage(Integer.parseInt(tokens[4]));
	    	   this_car.setPrice(Double.valueOf(tokens[5]));
	    	   this_car.setColor(tokens[6]);
	    	   this_car.setBland(tokens[7].charAt(0));
	    	   car.add(this_car);
	    }
	    br.close();
	}
		    
	public void displayInventory(int v) // If want to find if new or used
	{
		System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s \n", "VIN", 
				"Brand", "Model", "Year", "Mileage", "Price", "Color", "New");
		
		if(v == 1)
		{
			for(int i=0;i<car.size();i++) 
			 {
				 if(car.get(i).getVin()==null)
				 {
					 break;
				 }
				 else if(car.get(i).getBland()=='N')
				 {
					 continue;
				 }
				 
				 printCar(car.get(i));
			 }
			
		}
		else
		{
			for(int i=0;i<car.size();i++) 
			 {
				 if(car.get(i).getVin()==null)
				 {
					 break;
				 }
				 else if(car.get(i).getBland()=='Y')
				 {
					 continue;
				 }
				 
				 printCar(car.get(i));
			 }
		}
	}
	
	public void updateInventoryFile(int fn) throws IOException
	{
		Scanner s = new Scanner(System.in);
		try(FileWriter fw = new FileWriter(inv, true); // True to append
			    BufferedWriter bw = new BufferedWriter(fw);
			    PrintWriter out = new PrintWriter(bw))
			{
			
				if(inv.length()==0)
				{
					System.out.print("VIN: ");
				    tokens[0] = s.next();
				    out.print(tokens[0] + "/");
				}
				else
				{
					System.out.print("VIN: ");
				    tokens[0] = s.next();
				    out.print("\n" + tokens[0] + "/");
				}
				
			    System.out.print("Brand: ");
			    tokens[1] = s.next();
			    out.print(tokens[1] + "/");
			    
			    System.out.print("Model: ");
			    tokens[2] = s.next();
			    out.print(tokens[2] + "/");
			    
			    System.out.print("Year: ");
			    tokens[3] = s.next();
			    out.print(tokens[3] + "/");
			    
			    System.out.print("Mileage: ");
			    tokens[4] = s.next();
			    out.print(tokens[4] + "/");
			    
			    System.out.print("Price: ");
			    tokens[5] = s.next();
			    out.print(tokens[5] + "/");
			    
			    System.out.print("Color: ");
			    tokens[6] = s.next();
			    out.print(tokens[6] + "/");
			    
			    System.out.print("New: ");
			    tokens[7] = s.next();
			    out.print(tokens[7]);

			} catch (IOException e) {
			    //exception handling left as an exercise for the reader
			}
		System.out.println();
		System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s \n", "VIN", 
				"Brand", "Model", "Year", "Mileage", "Price", "Color", "New");
		System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s \n", tokens[0], 
				tokens[1],tokens[2], tokens[3],tokens[4], tokens[5],tokens[6], tokens[7]);
		System.out.println("\nSuccessfully this car has been added.");
		
		inventoryRead();
		displayInventory();
		
	}
	
	public void deleteCar() throws IOException
	{
		Scanner s = new Scanner(System.in);
		String delete = null;
		displayInventory();
		int index=0;
		outerloop:
		do
		{
			System.out.print("\nPlease input the VIN to delete: ");
			delete = s.next();
			for(int i=0; i<car.size(); i++)
			{
				if(delete.matches(car.get(i).getVin()))
				{
					index = i;
					break outerloop;
				}
			}
			System.out.println("\nWrong VIN. Please Try again");
		}while(true);
		

			if(Objects.equals(car.get(index).getVin(), delete))
			{
				System.out.println();
				System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s \n", "VIN", 
						"Brand", "Model", "Year", "Mileage", "Price", "Color", "New");
				System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s \n", car.get(index).getVin(),
						car.get(index).getBrand(), car.get(index).getModel(), car.get(index).getYear(),
						car.get(index).getMileage(), car.get(index).getPrice(), car.get(index).getColor(),
						car.get(index).getBland());
				System.out.println("\nSuccessfully this car has been deleted.\n");
				
				car.remove(index);
			}

		
		rewrite();
		inventoryRead();
		displayInventory();
		
		
	}
	
	public void updateCar() throws IOException
	{
		Scanner s = new Scanner(System.in);
		Scanner n = new Scanner(System.in);
		int choice = 0;
		int index = 0;
		double price = 0.00;
		String vin = null;
		String update = null;
		displayInventory();
		
		
		do
		{
			System.out.print("\nPlease input the VIN: ");
			vin = s.next();
			for(int i=0; i<car.size(); i++)
			{
				if(!(Objects.equals(car.get(car.size()-1).getVin(), vin))) // If vin gets to last line, and not equal: "Car not Found"
				{
					System.out.println("\nCar does not exist. Please try again");
					break;
				}
				if(Objects.equals(car.get(i).getVin(), vin))
				{
					index = i;
					break;
				}
			}
		}while(!(Objects.equals(car.get(index).getVin(), vin)));
			
		System.out.println("\n1. Update Brand");
		System.out.println("2. Update Model");
		System.out.println("3. Update Year");
		System.out.println("4. Update Mileage");
		System.out.println("5. Update Price");
		System.out.println("6. Update Color");
		System.out.print("\nPlease input option: ");
		choice = n.nextInt();
		
		//Find index of car by VIN
		
		if(choice == 1)
		{
			System.out.print("\nPlease input brand: ");
			update = s.next();
			car.get(index).setBrand(update);
		}
		else if(choice == 2)
		{
			System.out.print("\nPlease input model: ");
			update = s.next();
			car.get(index).setModel(update);
		}
		else if(choice == 3)
		{
			System.out.print("\nPlease input year: ");
			choice = n.nextInt();
			car.get(index).setYear(choice);
		}
		else if(choice == 4)
		{
			System.out.print("\nPlease input mileage: ");
			choice = n.nextInt();
			car.get(index).setMileage(choice);
		}
		else if(choice == 5)
		{
			System.out.print("\nPlease input price: ");
			price = n.nextDouble();
			car.get(index).setPrice(price);
		}
		else
		{
			System.out.print("\nPlease input color: ");
			update = s.next();
			car.get(index).setColor(update);
		}
		
		System.out.println("\nIt's updated. Thank you!");
		
		rewrite();
		displayInventory();

		
	}
	
	public void sortCars()
	{
		Scanner s = new Scanner(System.in);
		int choice = 0;
		
		System.out.println("\n1. Sort by VIN");
		System.out.println("2. Sort by Brand");
		System.out.println("3. Sort by Model");
		System.out.println("4. Sort by Year");
		System.out.println("5. Sort by Mileage");
		System.out.println("6. Sort by Price");
		System.out.println("7. Sort by Color");
		System.out.println("\nPlease input your choice: ");
		choice = s.nextInt();
		
		
		if(choice == 1)
		{
			sortVin();
			displayInventory();
		}
		else if(choice == 2)
		{
			sortBrand();
			displayInventory();
		}
		else if(choice == 3)
		{
			sortModel();
			displayInventory();
		}
		else if(choice == 4)
		{
			sortYear();
			displayInventory();
		}
		else if(choice == 5)
		{
			sortMileage();
			displayInventory();
		}
		else if(choice == 6)
		{
			sortPrice();
			displayInventory();
		}
		else
		{
			sortColor();
			displayInventory();
		}
		
		
	}
	public void sortVin()
	{
		String[] arr = new String[car.size()];
		
		for(int i=0; i<car.size(); i++)
		{
			arr[i] = car.get(i).getVin();
		}
		
        Arrays.sort(arr);
        for(int i = 0; i < arr.length; i++)
        {
        		ArrayList<car> temp = new ArrayList <car>();
        		temp.clear();
        		for(int j=0; j<arr.length; j++)
	        		if(Objects.equals(arr[i], car.get(j).getVin()))
	        		{
	        			temp.add(0, car.get(j));
	        			car.set(j, car.get(i));
	        			car.set(i, temp.get(0));
	        		}
        }
			
			
	}
	public void sortBrand()
	{
		String[] arr = new String[car.size()];
		
		for(int i=0; i<car.size(); i++)
		{
			arr[i] = car.get(i).getBrand();
		}
		
        Arrays.sort(arr);
        for(int i = 0; i < arr.length; i++)
        {
        		ArrayList<car> temp = new ArrayList <car>();
        		temp.clear();
        		for(int j=0; j<arr.length; j++)
	        		if(Objects.equals(arr[i], car.get(j).getBrand()))
	        		{
	        			temp.add(0, car.get(j));
	        			car.set(j, car.get(i));
	        			car.set(i, temp.get(0));
	        		}
        }
		
	}
	public void sortModel()
	{
		String[] arr = new String[car.size()];
		
		for(int i=0; i<car.size(); i++)
		{
			arr[i] = car.get(i).getModel();
		}
		
        Arrays.sort(arr);
        for(int i = 0; i < arr.length; i++)
        {
        		ArrayList<car> temp = new ArrayList <car>();
        		temp.clear();
        		for(int j=0; j<arr.length; j++)
	        		if(Objects.equals(arr[i], car.get(j).getModel()))
	        		{
	        			temp.add(0, car.get(j));
	        			car.set(j, car.get(i));
	        			car.set(i, temp.get(0));
	        		}
        }
	}
	public void sortYear()
	{
		for(int i=0; i<car.size()-1; i++)
		{
			int min = i;
			for(int j=i+1; j<car.size(); j++)
				if(car.get(j).getYear()<car.get(min).getYear())
					min = j;
			car smaller = car.get(min);
			car.set(min, car.get(i));
			car.set(i, smaller);
			
		}
	}
	public void sortMileage()
	{
		for(int i=0; i<car.size()-1; i++)
		{
			int min = i;
			for(int j=i+1; j<car.size(); j++)
				if(car.get(j).getMileage()<car.get(min).getMileage())
					min = j;
			car smaller = car.get(min);
			car.set(min, car.get(i));
			car.set(i, smaller);
			
		}
	}
	public void sortPrice()
	{
		for(int i=0; i<car.size()-1; i++)
		{
			int min = i;
			for(int j=i+1; j<car.size(); j++)
				if(car.get(j).getPrice()<car.get(min).getPrice())
					min = j;
			car smaller = car.get(min);
			car.set(min, car.get(i));
			car.set(i, smaller);
			
		}
	}
	
	public void sortColor()
	{
		String[] arr = new String[car.size()];
		
		for(int i=0; i<car.size(); i++)
		{
			arr[i] = car.get(i).getColor();
		}
		
        Arrays.sort(arr);
        for(int i = 0; i < arr.length; i++)
        {
        		ArrayList<car> temp = new ArrayList <car>();
        		temp.clear();
        		for(int j=0; j<arr.length; j++)
	        		if(Objects.equals(arr[i], car.get(j).getColor()))
	        		{
	        			temp.add(0, car.get(j));
	        			car.set(j, car.get(i));
	        			car.set(i, temp.get(0));
	        		}
        }
	}
	
	public void displayInventory()
	{
		System.out.println();
		System.out.printf("%-10s %-10s %-10s %-10s %-10s %10s %-5s %-10s %-10s\n", "VIN", 
				"Brand", "Model", "Year", "Mileage", "Price","", "Color", "New");
		 for(int i=0;i<car.size();i++) 
		 {
			 if(car.get(i).getVin()==null)
			 {
				 break;
			 }

			 printCar(car.get(i));
		 }
		
	}
	
	public void rewrite() throws IOException
	{
		File myFoo = new File("inventory.txt");
		FileWriter fooWriter = new FileWriter(myFoo, false); 
		                                               
		for(int i=0; i<car.size(); i++)
		{
			if(i == (car.size()-1)) 
			{
				fooWriter.write(car.get(i).getVin() + "/" +car.get(i).getBrand() + "/" +
					    car.get(i).getModel() + "/"+car.get(i).getYear() + "/" + car.get(i).getMileage() + "/" +
					    car.get(i).getPrice() + "/"+ car.get(i).getColor() + "/" + car.get(i).getBland());
			}
			else
			{
				fooWriter.write(car.get(i).getVin() + "/" +car.get(i).getBrand() + "/" +
					    car.get(i).getModel() + "/"+car.get(i).getYear() + "/" + car.get(i).getMileage() + "/" +
					    car.get(i).getPrice() + "/"+ car.get(i).getColor() + "/" + car.get(i).getBland() + "\n");
			}
			
		}
		
		fooWriter.close();
	}
	
	public void printCar(car car)
	{
		System.out.printf("%-10s %-10s %-10s %-10s %-10s %10.2f %-5s %-10s %-10s\n", car.getVin(), car.getBrand(),
				  car.getModel(), car.getYear(), car.getMileage(), car.getPrice(),"", car.getColor(), car.getBland());
	}
}