import java.util.Scanner;

public class Task52_Brackets {
	public static void main(String[] args) {

		System.out.println("1) false =  " + searchBrack("(a)a)"));
		System.out.println("2) true =  " + searchBrack("a(a)"));
		// System.out.println("3) false =  " + searchBrack("a)a()"));
		// System.out.println("4) false =  " + searchBrack("aj[]a[iy{7666]97}"));
		// System.out.println("5) false =  " + searchBrack("a{k}a"));
		// System.out.println("6) false =  "  + searchBrack("a)((a"));
		// System.out.println("7) true =  " +searchBrack("akjhkjhg(a)"));
		// System.out.println("8) true =  " + searchBrack("a()a"));
		// System.out.println("9) false =  " + searchBrack("aa((("));
		// System.out.println("10) false =  " + searchBrack("ava) vyavy ("));
		// System.out.println("11) true =  " + searchBrack("(aa(kjh))"));
	}




	public static boolean searchBrack (String str) {

		int fl1 = 0;
		int fl2 = 0;

		System.out.print(fl1 +  " " + fl2 + "\n");

		char[] strArr = str.toCharArray();

		for (int i = 0 ; i < strArr.length ; i++) {
			if (strArr[i] == ')') {
				fl1 = fl1 + 1;
			}

			if (strArr[i] == '(') {
				fl2 = fl2 + 1;
			}
		}

		System.out.print(fl1 + " " + fl2 + "\n");



		if (strArr.length == 0) {
			if (fl1 == fl2) {
				return true; 
			} 
			else {
				return false;
			}
		}


		String str1 = new String();
		str1 = str.substring(0, str.length()-1);
		System.out.printf("before: %s, now: %s \n", str, str1);
		System.out.println("----------------------------");
		return searchBrack(str1, fl1, fl2);
	}

	public static boolean searchBrack (String str, int fl1, int fl2) {

		System.out.print(fl1 + " " + fl2 + "\n");

		char[] strArr = str.toCharArray();

		for (int i = 0 ; i < strArr.length ; i++) {
			if (strArr[i] == ')') {
				fl1 = fl1 + 1;
			}

			if (strArr[i] == '(') {
				fl2 = fl2 + 1;
			}
		}

		System.out.print(fl1 + " " + fl2 + "\n");



		if (strArr.length == 0) {
			if (fl1 == fl2) {
				return true; 
			} 
			else {
				return false;
			}
		}


		String str1 = new String();
		str1 = str.substring(0, str.length()-1);
		System.out.printf("before: %s, now: %s \n", str, str1);
		System.out.println("----------------------------");
		return searchBrack(str1, fl1, fl2);
	}
}