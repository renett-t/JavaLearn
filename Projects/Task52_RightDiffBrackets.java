import java.util.Scanner;

public class Task52_RightDiffBrackets {
	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		System.out.println("Enter a line with some brackets");

		String str = scn.nextLine();
		scn.close();

		System.out.printf("\nAre brackets placed correctly? \n\t\t%B", findBrackets(str));
	}

// ------------------------------------ STARTING POINT
	public static boolean findBrackets(String str) {
		boolean flag = false;

		int factRoundCount = calcHowMuchBrackets(str, '(', ')');
		int factCurlyCount = calcHowMuchBrackets(str, '{', '}');
		int factSquareCount = calcHowMuchBrackets(str, '[', ']');

		if ( (factRoundCount == 0) && (factCurlyCount == 0) && (factSquareCount == 0) ) {
			return true;
		}
		if ( (factRoundCount % 2 != 0) || (factCurlyCount % 2 != 0) || (factSquareCount % 2 != 0)){
			return false;
		}

		int roundCount = 0;                                                   // counting pairs of brackets
		int curlyCount = 0;
		int squareCount = 0;

		if ( (str.charAt(0) == '(') ) {
			roundCount += 1;
			return findRoundBrackets(str.substring(1), factRoundCount, roundCount, factCurlyCount, curlyCount, factSquareCount, squareCount);
		}

		if (str.charAt(0) == ')') {
			return false;
		}

		if ( (str.charAt(0) == '{') ) {
			curlyCount += 1;
			return findCurlyBrackets(str.substring(1), factRoundCount, roundCount, factCurlyCount, curlyCount, factSquareCount, squareCount);
		}

		if (str.charAt(0) == '}') {
			return false;
		}

		if ( (str.charAt(0) == '[') ) {
			squareCount += 1;
			return findSquareBrackets(str.substring(1), factRoundCount, roundCount, factCurlyCount, curlyCount, factSquareCount, squareCount);
		}

		if (str.charAt(0) == ']') {
			return false;
		}

		return findBrackets(str.substring(1));

	}

// ------------------------------------ in case of finding a pair and starting to search for another one thruought the left string
	public static boolean findBrackets(String str, int factRoundCount, int roundCount, int factCurlyCount, int curlyCount, int factSquareCount, int squareCount) {
		if (str.length() == 0) {
			if ( (roundCount == factRoundCount)  && (curlyCount == factCurlyCount) && (squareCount == factSquareCount) )  {
				return true;
			}
			else {
				return false;
			}
		}

		if ( (str.charAt(0) == '(') ) {
			roundCount += 1;
			return findRoundBrackets(str.substring(1), factRoundCount, roundCount, factCurlyCount, curlyCount, factSquareCount, squareCount);
		}

		if (str.charAt(0) == ')') {
			roundCount += 1;
			if (roundCount % 2 == 0) {
				return findBrackets(str.substring(1), factRoundCount, roundCount, factCurlyCount, curlyCount, factSquareCount, squareCount);
			}
			else {
				return false;
			}
		}

		if ( (str.charAt(0) == '{') ) {
			curlyCount += 1;
			return findCurlyBrackets(str.substring(1), factRoundCount, roundCount, factCurlyCount, curlyCount, factSquareCount, squareCount);
		}

		if (str.charAt(0) == '}') {
			curlyCount += 1;
			if (curlyCount % 2 == 0) {
				return findBrackets(str.substring(1), factRoundCount, roundCount, factCurlyCount, curlyCount, factSquareCount, squareCount);
			}
			else {
				return false;
			}
		}

		if ( (str.charAt(0) == '[') ) {
			squareCount += 1;
			return findSquareBrackets(str.substring(1), factRoundCount, roundCount, factCurlyCount, curlyCount, factSquareCount, squareCount);
		}

		if (str.charAt(0) == ']') {
			squareCount += 1;
			if (squareCount % 2 == 0) {
				return findBrackets(str.substring(1), factRoundCount, roundCount, factCurlyCount, curlyCount, factSquareCount, squareCount);
			}
			else {
				return false;
			}
		}

		return findBrackets(str.substring(1), factRoundCount, roundCount, factCurlyCount, curlyCount, factSquareCount, squareCount);

	}


// ------------------------------------ SEARCHING FOR THE RIGHT ROUND BRACKETS
	public static boolean findRoundBrackets(String str, int factRoundCount, int roundCount, int factCurlyCount, int curlyCount, int factSquareCount, int squareCount) {
		if (str.length() == 0) {
			return false;
		}

		if  (str.charAt(0) == ')') {
			roundCount = roundCount + 1;
			return findBrackets(str.substring(1), factRoundCount, roundCount, factCurlyCount, curlyCount, factSquareCount, squareCount);
		}
		
		if  (str.charAt(0) == '(') {
			roundCount += 1;
			return findRoundBrackets(str.substring(1), factRoundCount, roundCount, factCurlyCount, curlyCount, factSquareCount, squareCount);
		}

		if  (str.charAt(0) == '}') {
			curlyCount += 1;
			return false;
		}
		
		if  (str.charAt(0) == '{') {
			curlyCount += 1;
			return findCurlyBrackets(str.substring(1), factRoundCount, roundCount, factCurlyCount, curlyCount, factSquareCount, squareCount);
		}

		if  (str.charAt(0) == ']') {
			squareCount += 1;
			return false;
		}
		
		if  (str.charAt(0) == '[') {
			squareCount += 1;
			return findSquareBrackets(str.substring(1), factRoundCount, roundCount, factCurlyCount, curlyCount, factSquareCount, squareCount);
		}

		return findRoundBrackets(str.substring(1), factRoundCount, roundCount, factCurlyCount, curlyCount, factSquareCount, squareCount);
		
	}

// ------------------------------------ SEARCHING FOR THE RIGHT CURLY BRACKETS
	public static boolean findCurlyBrackets(String str, int factRoundCount, int roundCount, int factCurlyCount, int curlyCount,int factSquareCount, int squareCount) {
		if (str.length() == 0) {
			return false;
		}

		if  (str.charAt(0) == '}') {
			curlyCount = curlyCount + 1;
			return findBrackets(str.substring(1), factRoundCount, roundCount, factCurlyCount, curlyCount, factSquareCount, squareCount);
		}
		
		if  (str.charAt(0) == '{') {
			curlyCount += 1;
			return findCurlyBrackets(str.substring(1), factRoundCount, roundCount, factCurlyCount, curlyCount, factSquareCount, squareCount);
		}


		if  (str.charAt(0) == ')') {
			roundCount += 1;
			return false;
		}
		
		if  (str.charAt(0) == '(') {
			roundCount += 1;
			return findRoundBrackets(str.substring(1), factRoundCount, roundCount, factCurlyCount, curlyCount, factSquareCount, squareCount);
		}

		if  (str.charAt(0) == ']') {
			squareCount += 1;
			return false;
		}
		
		if  (str.charAt(0) == '[') {
			squareCount += 1;
			return findSquareBrackets(str.substring(1), factRoundCount, roundCount, factCurlyCount, curlyCount, factSquareCount, squareCount);
		}

		return findCurlyBrackets(str.substring(1), factRoundCount, roundCount, factCurlyCount, curlyCount, factSquareCount, squareCount);	
	}


// ------------------------------------ SEARCHING FOR THE RIGHT SQUARE BRACKETS
	public static boolean findSquareBrackets(String str, int factRoundCount, int roundCount, int factCurlyCount, int curlyCount,int factSquareCount, int squareCount) {
		if (str.length() == 0) {
			return false;
		}

		if  (str.charAt(0) == ']') {
			squareCount = squareCount + 1;
			return findBrackets(str.substring(1), factRoundCount, roundCount, factCurlyCount, curlyCount, factSquareCount, squareCount);
		}
		
		if  (str.charAt(0) == '[') {
			squareCount += 1;
			return findSquareBrackets(str.substring(1), factRoundCount, roundCount, factCurlyCount, curlyCount, factSquareCount, squareCount);
		}

		if  (str.charAt(0) == '}') {
			curlyCount += 1;
			return false;
		}
		
		if  (str.charAt(0) == '{') {
			curlyCount += 1;
			return findCurlyBrackets(str.substring(1), factRoundCount, roundCount, factCurlyCount, curlyCount, factSquareCount, squareCount);
		}

		if  (str.charAt(0) == ')') {
			roundCount += 1;
			return false;
		}
		
		if  (str.charAt(0) == '(') {
			roundCount += 1;
			return findRoundBrackets(str.substring(1), factRoundCount, roundCount, factCurlyCount, curlyCount, factSquareCount, squareCount);
		}

		return findSquareBrackets(str.substring(1), factRoundCount, roundCount, factCurlyCount, curlyCount, factSquareCount, squareCount);
	}


	public static int calcHowMuchBrackets(String str, char br1, char br2) {
		char[] arr = str.toCharArray();
		int count = 0;
		for (char s : arr) {
			if ( (s == br1) || (s == br2) ) {
				count += 1;
			}
		}
		return count;
	}
}