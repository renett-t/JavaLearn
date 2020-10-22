import java.util.Formatter;

public class Task11_MultiplicationTable {

	public static void main(String[] args){

		if (args.length != 1) {
			System.out.println("please input max multiplier");
		} else {

			double n0 = Double.parseDouble(args[0]);
			if (n0 < 1 || n0 % 1 != 0) {
				System.out.println("input a natural number");
			} 
			else {

				int n = (int) Math.round(n0);
				System.out.println();

				long length = (long) Math.ceil(Math.log10(n*n));
				System.out.println("length = " + length + " n= " + (n*n));

				for (int i = 1; i <= n; i++) {
	
					for (int j = 1; j <= n; j++) {
						String a = String.format(" %" + length + "d ", i*j);
						System.out.print(a);
			
					}

					System.out.println();
					
				}

			}

		}

	}
}