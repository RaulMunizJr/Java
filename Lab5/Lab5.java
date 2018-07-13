
//Raul Muniz
//Feb 5, 2018
//Lab 5-1

public class Lab5 {

	public static void main(String[] args) {
		char [] arr1 = {'H','E','L','L','O'};
		char [] arr2 = {'H','E','L','L','O'};
		
		for(int i=0; i<arr1.length;i++)
		{
			if(arr1[i]!=arr2[i])
			{
				System.out.print("0");
				break;
			}
			else if(i == arr1.length-1)
			{
				System.out.print("1");
			}
		}
		
		}
	}
