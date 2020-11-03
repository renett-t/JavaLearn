package ru.kpfu.itis.tyapkina;

import ru.kpfu.itis.tyapkina.entities.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Calendar;

public class Main {
    public static void main(String[] args) {

        Good milk = new Good("milk");                                              
        Calendar dateOfProductionOfMilk = Calendar.getInstance();
        dateOfProductionOfMilk.set(2020, 10, 1);

        milk.setProducerName("Prostokvashino");
        milk.setDate(dateOfProductionOfMilk);
        milk.setPrice(0.5);

        System.out.println("enter how many bottles of milk do you want to buy: ");
        String request = "enter a natural value, a number of bottles";
        milk.setCount(inputNaturalValue(request));

        int stockCount = (int) (Math.random() * 10);
        milk.setStock(stockCount);

        milk.setAvailable(milk.checkStock());

        System.out.println();
        milk.printInfo();
    }

    public static int inputNaturalValue(String request) {
        Scanner scn = new Scanner(System.in);
        int num = 1;
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
        scn.close();
        return num;
    }
}