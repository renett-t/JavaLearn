import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

public class Task20_Multipliers {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		System.out.print("Input a number: ");
		if (!scn.hasNextInt()) {
			System.out.println("input a natural number");
			System.exit(0);
		} 
		
		int n = scn.nextInt();
		ArrayList<Integer> mults = new ArrayList<>();

		for (int i = 1; i <= n/2 ; i++) {
			if (n%i == 0) {
				if (!mults.contains(i)) {
					mults.add(i);
				}
				if (!mults.contains(n/i)) {
					mults.add(n/i);
				}
			}
		}
		
		//from List -> to multsarray 
		//int[] multip = mults.stream().tomultsarray(int[]::new); ????????? how does it work?
		int[] multsarr = new int[mults.size()];

		for (int i = 0; i < mults.size(); i++) {
   			multsarr[i] = mults.get(i);
		}

		for (int l = 1 ; l <= multsarr.length - 1 ; l++) {
			for (int i = 0; i <= multsarr.length - 2 ; i++) {
				if (multsarr[i] > multsarr[i+1]) {
					int t = multsarr[i];
					multsarr[i] = multsarr[i+1];
					multsarr[i+1] = t;
				}
			}
		}
		System.out.println(Arrays.toString(multsarr));
	}
}