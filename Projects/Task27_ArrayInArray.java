import java.util.Scanner;
import java.util.Arrays;

public class Task27_ArrayInArray {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		System.out.println("Input SubArray's size and its elements");
		if (!scn.hasNextInt()) {
			System.out.println("Size must be a natural number");
			System.exit(1);
		}

		int n2 = scn.nextInt();
		String subarr[] = new String[n2];
		String trash = scn.nextLine();

		for (int i = 0 ; i <= n2 - 1 ; i++) {
			subarr[i] = scn.nextLine();
		}
		System.out.println(Arrays.toString(subarr));

		System.out.println("Input Array's size and its elements");
		if (!scn.hasNextInt()) {
			System.out.println("Size must be a natural number");
			System.exit(1);
		}

		int n1 = scn.nextInt();
		if ( n1 < n2 ) {
			System.out.println("the size of SubArray is greater then the size of Array. Think and input again.");
			System.exit(1);
		}

		String arr[] = new String[n1];
		trash = scn.nextLine();

		for (int i = 0 ; i <= n1 - 1 ; i++) {
			arr[i] = scn.nextLine();
		}
		System.out.println(Arrays.toString(arr));

		
		int index = -1;

		for (int j = 0; j <= arr.length-1 ; j++ ) {
			if (arr[j].equals(subarr[0])) {
				index = j;

				boolean flag = true;
				int s1 = j+1;
				for (int k = 1 ; k <= subarr.length-1; k++) {
					if ( (s1 > arr.length-1) || (!arr[s1].equals(subarr[k])) ) {
						index = -1;
						flag = false;
						break;
					}
					else {
						s1 += 1;
					}

				}

				if (flag) {
					break;
				}

			}

		}
		
		System.out.println(index);
	}
}
