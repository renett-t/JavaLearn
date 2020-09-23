public class Task10_DrawSquare {

	public static void main(String[] args){

		if (args.length != 1) {
			System.out.println("please input the width or height of our square");
		}

		else {

			double n0 = Double.parseDouble(args[0]);

			if (n0 < 1 || n0 % 1 != 0) {
				System.out.println("input a natural number");
			}
			else {

				int n = (int) Math.round(n0);
				for (int i = 1; i <= n; i++) {
					for (int j = 1; j <= n; j++) {
						System.out.print("* ");
					}
					System.out.println();
				}

			}

		}

	}
}