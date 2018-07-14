//Raul Muniz
//2-28-18
//Lab9-2
public class Main {

	public static void main(String[] args) {
		
		Sports_car sc = new Sports_car();
		sc.brand = "Tesla";
		sc.model = "Roadster";
		sc.price = 150000;
		sc.miles = 0;
		sc.Spoiler = true;
		
		sc.display();
		
		Mini_van mv = new Mini_van();
		mv.brand = "Honda";
		mv.model = "Accord";
		mv.price = 1102;
		mv.miles = 214356;
		mv.ASD = true;
		
		mv.display();
	}

}
