// THE ALGORYTHM NEEDS IMPROVEMENT

import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

public class Task21_LCM {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);

		System.out.println("Input 2 numbers: ");
		if (!scn.hasNextI nt()) {
			System.out.println("input only natural numbers");
			System.exit(1);
		}
		int n1 = scn.nextInt();

		if (!scn.hasNextInt()) {
			System.out.println("input 2nd natural numbers");
			System.exit(1);
		}
		int n2 = scn.nextInt();

		ArrayList<Integer> multsN1 = new ArrayList<>();
		ArrayList<Integer> multsN2 = new ArrayList<>();

		for (int i = 1; i <= n1/2 ; i++)  {
			if( n1 % i == 0 ) {
				if (! multsN1.contains(i)) {
					multsN1.add(i);
				}
				if (! multsN1.contains(n1/i)) {
					multsN1.add(n1/i);			
				}
			}
		}
		for (int i = 1; i <= n2/2 ; i++) {
			if( n2 % i == 0 ) {
				if (! multsN2.contains(i)) {
					multsN2.add(i);
				}
				if (! multsN2.contains(n2/i)) {
					multsN2.add(n2/i);			
				}
			}
		}

		int gcd = 1;
		for (int j = 0; j <= multsN1.size() - 1 ; j++) {
			for (int k = 0; k <= multsN2.size() -1 ; k++) {
				if ( (multsN1.get(j) == multsN2.get(k)) && (multsN1.get(j) > gcd) ) {
					gcd = multsN1.get(j);
				}
			}
		}

		int lcm = n1*n2/gcd;		
		System.out.println("least common multiple = " + lcm);
	}
}