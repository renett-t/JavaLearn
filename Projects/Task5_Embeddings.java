public class Task5_Embeddings {

	public static void main(String[] args){
		
		if (args.length != 2) {
			System.out.println("please input 2 parametres: number of embeddings and value of variable x");
		}
		else {
			double n0 = Double.valueOf(args[0]);
			double x = Double.valueOf(args[1]);
			int n = (int) Math.round(n0);

		 	if (n0 % 1 != 0 || n0 < 1) {
				System.out.println("please input a NATURAL number of embeddings");
			}
			else if (x == n*(n+1)*(-1)) {
				System.out.println("impossible to count sum when n = " + n + " and x = " + x);
			} 
			else {

				int count = n + 1;
				double val = 1d;

				for (int i = 1; i <= n; i++) {

	 				if (i == 1) {
	 					val = x / count + (count - 1);
	 					count = count - 1;
	 				}
	 				else {
	 					val = x / val + (count - 1);
	  					count = count - 1;

	 				}
				}

				System.out.println();
				System.out.println(" n =  " + n);
				System.out.println(" x = " + x);
				System.out.println(" value = " + val);
				System.out.println();
 			}
 		}
			

	}
}