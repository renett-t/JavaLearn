public class IndexOfProg {

	public static void main(String args[]) {

		if (args.length != 2) {
			System.out.println("please input 2 parametres: a string and a substring");
		} else {
			String str = String.valueOf(args[0]);
		    String str1 = String.valueOf(args[1]);
		    char[] strA = str.toCharArray();
			char[] str1A = str1.toCharArray();

			if ( strA.length < str1A.length ) {
			System.out.println("a substring can't be longer that an actual string");
			} else {

				int ind = -1;
				
				System.out.println("indexOf: " + str.indexOf(str1));
				System.out.print("My code: ");

				for (int i = 0; i <= strA.length-1; i++) {
					if (strA[i] == str1A[0] ) {            //прохожусь по символам строки до совпадения с 1 симв подстроки
						ind = i;                           //запоминаю индекс строки, чтобы проверить всю подстроку
						int i1 = i;
						int j = 0;
						boolean flag = true;

						int count = 1;

						while (count <= str1A.length && flag == true) {
							if (  (i1 > strA.length-1) || (strA[i1] != str1A[j]) ) {   // если строка закончилась (выход будет) 
								ind = -1; 											  // или соответ символ строки != сиволу подстроки
								flag = false;										  // флаг = фолс, искомый индекс к начальному значению
							} else {
	                                                                     // увеличение индексов строки и подстроки для соответ сравнения
								j += 1;
								i1 = i1 + 1;
								count++;
							}
						}

						if (count == str1A.length + 1 ) {     // если полностью выполнился цикл while, значит было найдено ind, break из всего цикла поиска
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
}