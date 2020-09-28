public class IndexOfProgV2 {

	public static void main(String args[]) {

		if (args.length != 2) {
			System.out.println("please input 2 parametres: a string and a substring");
		} else {
			String str = String.valueOf(args[0]);
		    String str1 = String.valueOf(args[1]);
		    int l1 = str1.length();
			int l = str.length();
			int ind = -1;

			if ( l < l1 ) {
				System.out.println("a substring can't be longer that an actual string");

			} else {
				
				System.out.println("indexOf: " + str.indexOf(str1));
				System.out.print("my code: ");


				for (int i = 0; i <= l - l1; i++) {
						if (str.substring(i , i + l1).equals(str1)) {
							ind = i;
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
