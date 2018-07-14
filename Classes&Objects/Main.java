//Raul Muniz
//2-28-18
//Lab9-1
public class Main {

	public static void main(String[] args) {
		Sports_car sc = new Sports_car();
		sc.brand = "Toyota";
		sc.model = "Camry";
		sc.price = 1000;
		sc.miles = 500;
		sc.spoiler = true;
		
		sc.display();
		sc.displaySpoiler();
		System.out.println();
		
		Mini_van mv = new Mini_van();
		mv.brand = "Ford";
		mv.model = " F150";
		mv.price = 200;
		mv.miles = 50000;
		mv.auto_sliding_door = true;
		
		mv.display();
		mv.displayDoor();
	}

}
