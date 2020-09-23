public class Task1_WellDepthCalc{
	public static void main(String[] args) {

		if (args.length != 1 ) {
			System.out.println(" input one number of seconds");
		}
		else {
			double check = Double.valueOf(args[0]);

			if (check < 0) {
				System.out.println("number of seconds can't be negative, try again");
			}
			
			else {

				double t;
				t = check;
				double g = 9.81;
				double h = g*t*t / 2;
				System.out.print("Length = ");
				System.out.println(h);

			}
			
		}
		
	}
}