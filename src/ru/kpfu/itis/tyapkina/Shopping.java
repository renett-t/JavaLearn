package ru.kpfu.itis.tyapkina;

import ru.kpfu.itis.tyapkina.entities.*;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Calendar;

public class Shopping {
	public static void main(String[] args) throws FileNotFoundException {

		int totalAmount = 0;
		int i = 0;
		Scanner scn = new Scanner(System.in);
		File file = new File("./ru/kpfu/itis/tyapkina/shopdata.txt");

		Calendar birthDate = Calendar.getInstance();
		birthDate.set(2002, 10, 21);
		Customer cust1 = new Customer("Pizzalover", birthDate, false, "Russia, Kazan");
		
		String demand = " Enter how many products do you want to buy";
		System.out.println(demand);
		totalAmount = inputNaturalValue(scn, demand);
		cart = new ShoppingCart(totalAmount);
		cust1.setCart();

		while (i < totalAmount) {
			System.out.println("\n Enter WHAT you want to buy");
			cust1.getCart().getGoods(i) = new Good(scn.nextLine());
			cust1.getCart().setNumberOfGoods(cust1.getCart().getNumberOfGoods() + 1);

			System.out.println(" Enter HOW MUCH you want to buy");
			demand = " Enter the quantity of wanted product (number of pieces, boxes, kilos)";
			cust1.getCart().getGoods(i).setCount(inputNaturalValue(scn, demand));

			cust1.getCart().getGoods(i).getInfoFromFile(file);
			cust1.getCart().getGoods(i).setIsLeft(cust1.getCart().getGoods(i).checkStock());
			cust1.getCart().getGoods(i).printInfo();

			if (cust1.getCart().getGoods(i).getIsLeft()) {
				i = makeDecision(cust1.getCart(), scn, i);
			}
			else {
				System.out.println("Sorry, we don't have '" + cust1.getCart().getGoods(i).getName() + "' in our shop at the moment. Try to search for something else");
				cust1.getCart().getGoods(i) = null;
				cust1.getCart().setNumberOfGoods(cust1.getCart().getNumberOfGoods() - 1);
			}
		}

		printBill(cust1.getCart());
		System.out.println("\nMake a payment, please");     //this part is just for fun =)
		String payment = scn.nextLine();
		System.out.println("Processing data, wait a second");
		System.out.println("Operation completed successfully. Thank you for visiting our shop!");
	}

	public static int inputNaturalValue(Scanner scn, String demand) {
		int num = 1;
		boolean flag = false;
		while (!flag) {
			try {
				num = Integer.parseInt(scn.nextLine());
				flag = true;
			} catch (NumberFormatException e) {
				System.out.println(demand);
			}

			if (num < 1) {
				System.out.println("Input a natural number, please");
				flag = false;
			}
		}
		return num;
	}

	public static void printBill(ShoppingCart cart) {
		System.out.println("\n-------------------------------");
		int n = cart.getNumberOfGoods();
		System.out.println("Your bill: ");
		System.out.println("products         quant   price");
		for (int j = 0; j < n; j++) {
			System.out.printf("%13s   %5d   %5.2f $ \n", cart.goods[j].getName(), cart.goods[j].getCount(), cart.goods[j].getPrice());
		}

		System.out.println("total amount: " + cart.countCheque() + "$");
		System.out.println("-------------------------------");
	}

	public static int makeDecision(ShoppingCart cart, Scanner scn, int count) {
		boolean flag = false;
		while (!flag) {
			System.out.printf("Do you want to buy %d p. %s, which costs %.2f? enter YES or NO \n", cart.goods[count].getCount(), cart.goods[count].getName(), (cart.goods[count].getCount()*cart.goods[count].getPrice()));
			String decision = scn.nextLine();
			switch (decision) {
				case "YES":
					count += 1;
					flag = true;
					break;

				case "NO":
					cart.removeFromCart(cart.goods[count]);
					flag = true;
					break;

				default:
					System.out.print(" Error: wrong input, try again. ");
			}
		}
		return count;
	}	
}
