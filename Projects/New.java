public class New{
	public static void main(String[] args){

		if (args.length != 2) {
			System.out.println("input 2 numbers");
		}
		else {
			int n = Integer.parseInt(args[0]);
			double x = Double.parseDouble(args[1]);
		
		
		System.out.println("n = " + n + " x = " + x);
		}
	}
}