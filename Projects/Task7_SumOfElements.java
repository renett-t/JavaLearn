public class Task7_SumOfElements{
	
	public static void main(String[] args) {

		if (args.length != 1 ) {
			System.out.println(" input one NUMBER of elements");
		}
		else {

			double n = Double.valueOf(args[0]);

			if (n < 0){
				System.out.println("input a natural number of elements, bro");
			}
			else {

				int count = 1;
				double sum = 0;
				double st = 0;

				while (count <= n){
					st = Math.pow(-1,count-1);
					sum = sum + st / (2*count-1) / (2*count-1);
					st = 0;
					count += 1;
				}

				System.out.println();
				System.out.println("sum of elements = " + sum);
				System.out.println();
			}

		}
	}
}