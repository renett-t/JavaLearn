public class Task2_CircleCalc{

	public static void main(String[] args) {

		if (args.length != 1 ) {
			System.out.println("input the value of radius, just one number");
		}
		else {
			double r = Double.valueOf(args[0]);

			if (r < 0) {
				System.out.println("radius can have only positive value, try again");
			}
			
			else {

				double c = 0;
				c = 2*Math.PI*r;
				double s= 0;
				s = Math.PI*r*r;

				System.out.print("Circumference = ");
				System.out.println(c);

				System.out.print("Circle area = ");
				System.out.println(s);

			}
			
		}
		
	}

}