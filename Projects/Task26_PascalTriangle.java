import java.util.Scanner;

public class Task26_PascalTriangle {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		if (!scn.hasNextInt()) {
			System.out.println("input a natural number of lines");
			System.exit(0);
		}
		int n = scn.nextInt();
		scn.close();

		long[] arr = new long[n+1];
		for (int i = 0; i <= arr.length-1 ; i++) {
			arr[i] = 0;
		}
		
		long t1 = 0;
		long t2 = 0;
		int pp = 0;

		if ( n < 13 ) {
			pp = n*2;
		} 
		else if (n < 20) {
			pp = n*3;
		}
		else if (n < 27) {
			pp = n*4;
		}
		else {
			pp = n*5;
		}

		/*
		long number = 0;
	
		*/

		for (int i = 0; i <= n; i++) {

			for (int h = 1; h <= pp ; h++) {
				System.out.print(" ");
			}
			if ( n<13 ) {
						pp = pp - 2;
					} 
					else if ( n < 20 ) {
						pp = pp - 3;
					}
					else if (n < 27) {
						pp = pp - 4;
					}
					else {
						pp = pp - 5;
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

			 	if ( n < 13 ) {
						System.out.printf("%4d", arr[j]);
					} 
					else if ( n < 20) {
						System.out.printf("%6d", arr[j]);
					}
					else if (n < 27) {
						System.out.printf("%8d", arr[j]);
					}
					else {
						System.out.printf("%10d", arr[j]);
					}
			 	
			 }
			 System.out.println();
		}

	}

	public static long combination(int n, int k) {
		for () 
	}
}



		// -1672712-1792148471-690908188 556650734-1048833900-1389517357-496544288-1515254800-496544288-1389517357-1048833900 556650734-690908188-1792148471
		// //вычисление длины последней строки треугольника
		// String last = "1 ";
		// int k = n;
		
		// for (int j = 0; j <= k-1; j++) {
		// 		int x = 1;
		// 		int f = 1;

		// 		int c = j;
		// 	 	while (c >= 0) {
		// 	 		x = x * (k-c);
		// 	 		c -= 1;
		// 	 	}

		// 	 	for (int i = 1; i <= j+1; i++) {
		// 	 		f = f * i;
		// 	 	}

		// 	 	x = x / f;
			 	
		// 	 	last = last + x + " ";
		// }
		// last = last.substring(0, last.length()-1);
		// System.out.printf("'%2s' \n", last);

		// int len = last.length();
		// System.out.println(len);