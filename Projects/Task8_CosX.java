public class Task8_CosX {

	public static void main(String[] args){

		if (args.length != 2) {
			System.out.println("input 2 numbers: N and X in degrees");
		}
		else {

			double n0 = Double.parseDouble(args[0]);
			double x = Double.parseDouble(args[1]);

			if (n0 % 1 != 0 || n0 < 1) {
				System.out.println("input a natural number of embeddings");
			}
			else {
				int n = (int) Math.round(n0);
				double radX = Math.toRadians(x);
				double val = 0D;

				for( int i = 1; i <= n ; i++) {

					if (x == 90.0) {
						val = 0;
					}
					else {
						val = Math.cos(radX + val);
					}

				}

				System.out.println();
				System.out.println("cosine = " + val);
				System.out.println();

			}
		}
	}
}