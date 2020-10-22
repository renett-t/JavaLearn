public class Task9_IsPointOnCircle{

	static final double EPS = 1e-8;

	public static void main(String[] args){

		if (args.length != 5) {
			System.out.println("input 5 parametres: X0 and Y0 of point, R - radius of circumference, X and Y - center of circ.");
		}
		else {
			double x0 = Double.parseDouble(args[0]);
			double y0 = Double.parseDouble(args[1]);
			double r = Double.parseDouble(args[2]);
			double x = Double.parseDouble(args[3]);
			double y = Double.parseDouble(args[4]);

			if ( r < 0 ) {
				System.out.println("radius can only be a positive number, try again");
			}
			else {

				if ( Math.abs((x - x0)*(x - x0) + (y - y0)*(y - y0) - r*r) < EPS) {

					System.out.println("the point ( " + x +" , " + y + " ) is on the circumference");

				}
				else {

					System.out.println("the point ( " + x +" , " + y + " ) is NOT on the circumference");
					
				}

			}
		}

	}
}