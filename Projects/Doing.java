public class Doing{
	public static void main(String[] args){

		int m = Integer.valueOf(args[0]);
		int fac1 = 1;

		if (m == 0){
			fac1 = 1;
		}
		else {
			for (int i = 1; i <= m ; i++){
				fac1 = fac1 * i;
			}
		}

		
		System.out.println(fac1);






	    /*
		final int FIRST_CONST = 1;  //объявление константы
		boolean a = true;
		boolean b = false;
		if ( (a != b) && (a = false) ){  //оптимизация кода, здесь выполняется a false
			System.out.println("BRUH");
		}

	    if ( (a == b) && (a = false) ){  //оптимизация кода, здесь не выполняется, a остаётся равна true
			System.out.println("BRUH");
		}
		*/


	}
}