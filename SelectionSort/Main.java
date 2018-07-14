//Raul Muniz
//2-28-18
//Lab10
public class Main {
	public static void main(String[] args)
	{
		
		int[] unsortedarr = {1, 0, 45, 3, 100, -1};
		MySelectionSort.selSort(unsortedarr);
		for(int i = 0; i < unsortedarr.length; i++)
		{
			System.out.print(unsortedarr[i]+" ");
		}
	}

}
