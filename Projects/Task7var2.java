public class Task7var2{
	public static void main(String[] args) {

		double n = Double.valueOf(args[0]);
		if (n <= 0) {
			System.out.println("inputing errors, please try again. input only NUMBER of elements");
		}
		else {
			int count = 1;
			double sum = 0;
			while (count <= n){

				if (count%2 == 0){
					sum = sum - 1/(2*count-1) / (2*count-1);
				}
				else {
					sum = sum + 1/(2*count-1) / (2*count-1);
				}
				
				count++;
			}

			System.out.println(sum);
		}
	}
}