package ru.kpfu.itis.tyapkina;

import ru.kpfu.itis.tyapkina.entities.*;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Calendar;

public class Shopping {
	public static void main(String[] args) throws FileNotFoundException {

		int i = 0;
        
		Scanner scn = new Scanner(System.in);
		File file = new File("./ru/kpfu/itis/tyapkina/shopdata.txt");

		Calendar birthDate = Calendar.getInstance();
        birthDate.clear();
        birthDate.set(2002, 10, 21);
        Customer cust1 = new Customer("Pizzalover", birthDate, false, "Russia, Kazan, Universiade Village, 18");

        String request = " Enter how many products do you want to buy";
        System.out.println(request);
        int totalAmount = inputNaturalValue(scn, request);
        cust1.getCart().setGoods(totalAmount);

        while (i < totalAmount) {
            System.out.println("\n Enter WHAT you want to buy");
            Good newGood = new Good(scn.nextLine());
            cust1.getCart().setGood(i, newGood);

            System.out.println(" Enter HOW MUCH you want to buy");
            request = " Enter the quantity of wanted product (number of pieces, boxes, kilos)";
            cust1.getCart().getGood(i).setCount(inputNaturalValue(scn, request));

            cust1.getCart().getGood(i).getInfoFromFile(file);
            cust1.getCart().getGood(i).setAvailable(cust1.getCart().getGood(i).checkStock());
            if(cust1.getCart().getGood(i).isAvailable()) {
                cust1.getCart().getGood(i).printInfo();
            }

            if (cust1.getCart().getGood(i).isAvailable()) {
                i = makeDecision(cust1.getCart(), scn, i);
            }
            else {
                System.out.println("Sorry, we don't have enough '" + cust1.getCart().getGood(i).getName() + "' in our store at the moment.");
                System.out.println("Try to buy less or search for something else");
                cust1.getCart().setGood(i, null);           }
        }

        printBill(cust1.getCart());
        System.out.println("\nMake a payment, please");     //this part is just for fun =)
        String payment = scn.nextLine();
        System.out.println("Processing data, wait a second");
        System.out.println("Operation completed successfully. Thank you for visiting our shop!");
        scn.close();
    }

    public static int inputNaturalValue(Scanner scn, String request) {
        int num = -1;
        boolean flag = false;
        while (!flag) {
            try {
                num = Integer.parseInt(scn.nextLine());
                flag = true;
            } catch (NumberFormatException e) {
                System.out.println(request);
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
        System.out.println("     products   quant    price");
        for (int j = 0; j < n; j++) {
            System.out.printf("%13s   %5d   %5.2f$ \n", cart.getGood(j).getName(), cart.getGood(j).getCount(), cart.getGood(j).getPrice());
        }

        System.out.println("\ntotal cost: " + cart.countCheque() + "$");
        System.out.println("-------------------------------");
    }

    public static int makeDecision(ShoppingCart cart, Scanner scn, int count) {
        boolean flag = false;
        while (!flag) {
            System.out.printf("Do you want to buy %d p. %s, which costs %.2f$? enter YES or NO \n", cart.getGood(count).getCount(), cart.getGood(count).getName(), (cart.getGood(count).getCount()*cart.getGood(count).getPrice()));
            String decision = scn.nextLine();
            switch (decision) {
                case "YES":
                    count += 1;
                    cart.setNumberOfGoods(cart.getNumberOfGoods() + 1);
                    flag = true;
                    break;

                case "NO":
                    cart.removeFromCart(cart.getGood(count));
                    cart.setNumberOfGoods(cart.getNumberOfGoods() - 1);
                    flag = true;
                    break;

                default:
                    System.out.print(" Error: wrong input, try again. ");
            }
        }
        return count;
    }   
}
