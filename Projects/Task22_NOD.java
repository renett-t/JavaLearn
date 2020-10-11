import java.util.Scanner;
import java.util.ArrayList;

public class Task22_NOD {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("Input 2 natural numbers");

		if (!scan.hasNextInt()) {
			System.out.println("input only natural numbers");
			System.exit(1);
		}
		int n1 = scan.nextInt();

		if (!scan.hasNextInt()) {
			System.out.println("input 2nd NATURAL number");
			System.exit(1);
		}
		int n2 = scan.nextInt();

		//GCD by enumerative technique
		long t00 = System.nanoTime();

		int gcd = 0;
		for (int i = 1; i <= Math.max(n1, n2) ; i++) {
			if ( ( n1 % i == 0 ) && ( n2 % i == 0 ) ) {
				gcd = i;
			}
		}

		long t01 = System.nanoTime();
		//System.out.println(t00 + " " + t01);

		long t10 = System.nanoTime();

		while ( n1*n2 > 0 ) {
			if ( n1 > n2 ) {
				n1 = n1 % n2;
			}
			else {
				n2 = n2 % n1;
			}
		}
		long t11 = System.nanoTime();
		//System.out.println(t10 + " " + t11);

		long time1 = t01 - t00;
		long time2 = t11 - t10;
		System.out.println("GCD by enumerative techniq. = " + gcd + ", time = " + time1);
		System.out.println("GCD by Euclidean algorithm  = " + gcd + ", time = " + time2);

		if (time1 == time2) {
			System.out.printf("both methods took the same time, %d nanosec \n", time1);
			System.exit(0);
		}
		if (time1 < time2) {
			System.out.printf("enumerative technique if faster than Euclidean algorithm by %d nanosec \n", time2-time1 );
		}
		else {
			System.out.printf("Euclidean algorithm if faster than enumerative technique by %d nanosec \n", time1-time2 );
		}

	}
}