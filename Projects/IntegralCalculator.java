import java.io.*;
import java.util.Scanner;

public class IntegralCalculator {
	public static void main(String[] args) throws IOException {

		FileWriter writer = new FileWriter("Integral.txt", true);
		writer.write("--------------------------------------\n");
		writer.close();

		Scanner scn = new Scanner(System.in);

		System.out.print("Please, enter a, b and n, where the number \"a\" is a lower limit of the integral, the number \"b\" - ");
		System.out.print("upper limit of the integral, \"n\" - number of segments\n");
		String input1 = scn.nextLine();
		String input2 = scn.nextLine();
		String input3 = scn.nextLine();
		double xa = 0.0;
		double xb = 0.0;
		double n = 0.0;
		try {
			xa = Double.parseDouble(input1);
			xb = Double.parseDouble(input2);		
			n = Double.parseDouble(input3);
		} catch (NumberFormatException e) {
			System.out.println("Wrong input, try again. You should enter numbers");
			System.exit(1);
		}

		double val1 = 0.0;
		double val2 = 0.0;
		double val3 = 0.0;

		if ( (n < 1) || (n % 1 != 0) ) {
			System.out.println("number of segments should have a natural value");
			System.exit(1);
		}

		System.out.println("Please, choose a method of calculating square: 'rectangle', 'trapeze', 'simpson' or 'all' ");
		String method = scn.nextLine();
		switch (method) {
			case "rectangle":
				val1 = roundValue(calcSquareByRectangle(xa, xb, n));
				System.out.println("square by RECTANGLE METHOD: " + val1);
				writeFile(val1, method);
				break;

			case "trapeze":
				val2 = roundValue(calcSquareByTrapeze(xa, xb, n));
				System.out.println("square by TRAPEZE METHOD: " + val2);
				writeFile(val2, method);
				break;

			case "simpson":
				val3 = roundValue(calcSquareBySimpson(xa, xb, n));
				System.out.println("square by SIMPSON'S METHOD: " + val3);
				writeFile(val3, method);
				break;

			case "all":
				val1 = roundValue(calcSquareByRectangle(xa, xb, n));
				val2 = roundValue(calcSquareByTrapeze(xa, xb, n));
				val3 = roundValue(calcSquareBySimpson(xa, xb, n));
				System.out.println("square by RECTANGLE METHOD: " + val1);
				System.out.println("square by TRAPEZE METHOD: " + val2);
				System.out.println("square by SIMPSON'S METHOD: " + val3);
				writeFile(val1, "rectangle");
				writeFile(val2, "trapeze");
				writeFile(val3, "simpson's");
				break;

			default:
				System.out.println("wrong input, try again");
		}
	}

	public static double calcSquareByRectangle(double xa, double xb, double n) {
		double dx = (xb - xa) / n;
		double sum = 0.0;
		double x0 = xa;
		while (x0 < xb) {
			sum += calcFunction(x0);
			x0 += dx;
		}

		return dx*sum;

	}

	public static double calcSquareByTrapeze(double xa, double xb, double n) {
		double dx = (xb - xa) / n;
		double sum = (calcFunction(xa) + calcFunction(xb)) / 2.0;
		double x0 = xa + dx;
		xb = xb - dx;
		while (x0 < xb) {
			sum += calcFunction(x0);
			x0 += dx;
		}

		return dx*sum;
	}

	public static double calcSquareBySimpson(double xa, double xb, double n) {
		double sum = 0.0;
		sum = calcFunction(xa) + 4*calcFunction((xa + xb) / 2.0) + calcFunction(xb);
		double f = ((xb - xa) / 6) * sum;
		return f;
	}

	public static double calcFunction(double x) {
		return x*x;
	}

	public static void writeFile(double value, String method) throws IOException {
		FileWriter writer = new FileWriter("Integral.txt", true);
		writer.write("square by " + method + " method = " + value + "\n");
		writer.close();
	}
	
	public static double roundValue(double value) {
		double roundedValue = Math.round(value*100.0)/100.0;
		return roundedValue;
	}
}

