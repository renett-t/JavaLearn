package ru.kpfu.itis.tyapkina.entities;

import java.util.Scanner;
import java.io.File;
import java.io.*;
import java.util.Calendar;
import java.io.FileNotFoundException;

public class UsageOfClasses {
    public static void main(String[] args) throws FileNotFoundException {

        Calendar date = Calendar.getInstance();
        date.set(2020, 8, 12);
        File file = new File("./ru/kpfu/itis/tyapkina/shopdata.txt");

        Good milk = new Good("milk", 0.9, date, "milkystation");

        milk.printInfo();

        milk.setPrice(9);
        milk.printInfo();
        milk.getInfoFromFile(file);
        milk.printInfo();
    }
}
