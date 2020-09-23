public class Task3_MultiplyToGetPI {
	
	public static void main(String[] args){
		
		double pi = 1d;

		if (args.length != 1) {
			System.out.println("please input one number of multipliers");
		}
		else {

			double t = Double.valueOf(args[0]);

			if (t % 1  != 0 || t < 1) {
				System.out.println("please input a NATURAL number of myltipliers");
			}
			else {		
				int count = 1;
				int n = (int) Math.round(t);

				for (int i = 1; i <= n; i++) {

		 			pi = pi * (2 * i) * (2 * i) / (2 * i - 1) /(2 * i + 1);

				}

				System.out.println();
				System.out.print("PI = ");
				System.out.println(2*pi);
				System.out.println();
			
        	}
		}
	}
}