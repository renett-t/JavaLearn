import java.util.Scanner;

public class Task20v2 {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		System.out.print("Input a number: ");
		if (!scn.hasNextInt()) {
			System.out.println("input a natural number");
			System.exit(1);
		} 
		
		int n = scn.nextInt();
		if (n < 1) {
			System.out.println("input a positive natural number");
			System.exit(1);
		} 

		for (int i = 1; i <= Math.sqrt(n) ; i++) {
			if (i*i == n) {
				System.out.println(i + " ");
			}
			else if (n % i == 0) {
				System.out.println(i + " " + n/i + " ");
			}
		}
	}
		
}
