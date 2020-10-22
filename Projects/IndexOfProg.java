import java.util.Scanner;

public class IndexOfProg {

	public static void main(String args[]) {

		Scanner scn = new Scanner(System.in);
		System.out.println("Input 2 strings: a main one and a substring");
		String str = scn.nextLine();
		String str1 = scn.nextLine();

		char[] strA = str.toCharArray();
		char[] str1A = str1.toCharArray();

		for (int i = 0 ; i <= strA.length - 1 ; i++) {                          //lowering case of string and substring
			if ( (strA[i] >= 'A') && (strA[i] <= 'Z') ) {
				strA[i] = (char) (strA[i] - ('A') + ('a'));
			}
		}
		for (int i = 0 ; i <= str1A.length - 1 ; i++) {
			if ( (str1A[i] >= 'A') && (str1A[i] <= 'Z') ) {
				str1A[i] = (char) (str1A[i] - ('A') + ('a'));
			}
		}

		if ( str.length() < str1.length() ) {
			System.out.println("a substring can't be longer than an actual string");
		} 
		else {

			int ind = -1;
			
			System.out.println("indexOf: " + str.toLowerCase().indexOf(str1));
			System.out.print("My code: ");

			for (int i = 0; i <= strA.length-1; i++) {
				if (strA[i] == str1A[0] ) {                                       //going through all symbols of str until finding the one
					ind = i;                                                      //that's the same with the 1st symbol of substring
					int i1 = i;													  //remembering the index to check if the whole substring is in string
					int j = 0;
					boolean flag = true;

					int count = 1;

					while (count <= str1A.length && flag == true) {
						if (  (i1 > strA.length-1) || (strA[i1] != str1A[j]) ) {  // if there are no symbols in string left
							ind = -1; 											  // or symbol of string != symbol of substring
							flag = false;										  // return flag = true, ind = initial value
						} 
						else {
							j += 1;                                               // increasing indexes of str and str1 for respective comparison
							i1 = i1 + 1;
							count++;
						}
					}

					if (count == str1A.length + 1 ) {                            //if while cycle was fully implemented, then it means index was founded, break from the whole searcing cycle
						break;
					}

				}
			}
			if (ind == -1) {
				System.out.println("\'" + str1 +"\'" + " is not a substring of \'" + str + "\'");
			} else {
				System.out.println(ind);
			}
		}	 	
	}
}