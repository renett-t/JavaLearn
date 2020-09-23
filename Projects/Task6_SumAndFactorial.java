public class Task6_SumAndFactorial {

	public static void main(String[] args){
		
		if (args.length != 1) {
			System.out.println("please input one number of elements");
		}
		else {
			
			double n0 = Double.parseDouble(args[0]);

			if (n0 % 1 != 0 || n0 < 1) {
				System.out.println("please input a NATURAL number");
			} 
			else {	
				int n = (int) Math.round(n0);
				double sum = 0d;
				double fa1 = 1;					
				double fa2 = 1;

				for (int m = 1; m <= n; m++) {

					for (int i = 1; i <= (m-1) ; i++) {
						fa1 = fa1 * i;
					}

					for (int k = 1; k <= 2*m ; k++) {
						fa2 = fa2 * k;
					}

	            	sum = sum + fa1 * fa1 / fa2;
					fa1 = 1;
					fa2 = 1;
				}

				System.out.println();
				System.out.println(" sum = " + sum);
				System.out.println();
			}
	 	}	
	}
}