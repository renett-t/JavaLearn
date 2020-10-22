import java.util.Scanner;

public class Task26_PascalTriangle {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		System.out.println("Input number of lines ");
		if (!scn.hasNextInt()) {
			System.out.println("input a natural number of lines");
			System.exit(1);
		}
		int n = scn.nextInt();
		if ( n < 1 ) {
			System.out.println("input a POSITIVE natural number of lines");
			System.exit(1);
		}

		long[] arr = new long[n+1];
		for (int i = 0; i <= arr.length-1 ; i++) {
			arr[i] = 0;
		}
		
		long t1 = 0;
		long t2 = 0;
		

		double number = calcCombination(n, n / 2);
		int numLength = (int) Math.ceil(Math.log10(number+0.5)) + 2;
		numLength = numLength + numLength%2;

		int pp = ( (n + 1) * (numLength) ) / 2 - 2;

		for (int i = 0; i <= n; i++) {
			System.out.printf("\t");
			for (int h = 1; h <= pp ; h++) {
				System.out.print(" ");
			}
			if (n < 4) {
				pp = pp - 2;
			}
			else {
				pp = pp - (int) Math.floor(Math.sqrt(n));
			}
			for (int j = 0; j <= i; j++) {
			 	t1 = t2;
			 	t2 = arr[j];

			 	if ( (j == 0) || (j == i) ) {
			 		arr[j] = 1;
			 	}
			 	else {
			 		arr[j] = t1 + t2;
			 	}

				System.out.printf("%" + numLength + "d", arr[j]);
			 	
			 }
			 System.out.println();
		}

	}


	public static double calcCombination(int n, int k) {

		double nFact = 1d;
		double kFact = 1d;
	
		for (int i = 2; i <= k ; i++) {
				kFact = kFact * i;
			} 

		for (int i = n-k+1 ; i <= n ; i++) {
			nFact = nFact * i;
		}

		return (nFact/kFact);
	}

}
