//Raul Muniz
//Jan 31, 2018
//Lab 4-3

public class Lab4_3 {

	public static void main(String[] args) {
		for (int y = 0; y < 5; y++) {
		    for (int x = 0; x < 5; x++) {
		        System.out.print((x >= y) ? "*" : " ");
		    }

		    System.out.println();
		}
	}

}
