import java.util.Scanner;

public class Task52_RightBrackets {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		System.out.println("Enter a line with some brackets");

		String str = scn.nextLine();
		scn.close();

		System.out.println("\nTHE ANSWER: " + findBrackets(str));
	}

// STARTING POINT
	public static boolean findBrackets(String str) {
		boolean flag = false;

		int fact_count = calcHowMuchBrackets(str);
		if (fact_count == 0) {
			return true;
		}
		if (fact_count % 2 != 0) {
			return false;
		}

		fact_count = fact_count / 2;
		int count = 0;

		if ( (str.charAt(0) == '(') ) {
			return findBracketsRight(str.substring(1), fact_count, count);
		}

		if (str.charAt(0) == ')') {
			return false;
		}

		return findBrackets(str.substring(1));

	}

// SEARCHING FOR THE RIGHT BRACKET
	public static boolean findBracketsRight(String str, int fact_count, int count) {

		if (str.length() == 0) {
			if (count == fact_count) {
				return true;
			}
			else {
				return false;
			}
		}

		if  (str.charAt(0) == ')') {
			count = count + 1;
			return findBracketsRight(str.substring(1), fact_count, count);
		}
		
		if  (str.charAt(0) == '(') {
			return findBracketsRight(str.substring(1), fact_count, count);
		}

		return findBracketsRight(str.substring(1), fact_count, count);
		
	}

	public static int calcHowMuchBrackets(String str) {
		char[] arr = str.toCharArray();
		int count = 0;
		for (char s : arr) {
			if ( (s == ')') || (s == '(') ) {
				count += 1;
			}
		}
		return count;
	}
}