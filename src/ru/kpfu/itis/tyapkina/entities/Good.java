package ru.kpfu.itis.tyapkina.entities;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Calendar;

public class Good extends Product {
    protected Calendar date = Calendar.getInstance();
    protected String producerName;
    protected int count;             //how much the customer wants to buy
    protected int stock;             //how much of goods left in the stock of the shop
    protected boolean available;     //availability indicator

    public Good(String name) {
        super(name);
    }

    public Good(String name, double price) {
        super(name, price);
    }

    public Good(String name, double price, Calendar date, String producerName) {
        this(name, price);
        this.setDate(date);
        this.setProducerName(producerName);
    }

    public void setDate(Calendar date) {
        if (!this.date.before(date)) {
            this.date = date;
        }
    }

    public Calendar getDate() {
        return this.date;
    }

    public void setProducerName(String producerName) {
        if (producerName.length() > 2) {
            this.producerName = producerName;
        }
    }

    public String getProducerName() {
        return this.producerName;
    }

    public void setCount(int count) {
        if (count > 0) {
            this.count = count;
        }
    }

    public int getCount() {
        return this.count;
    }

    public void setStock(int stock) {
        if (stock >= 0) {
            this.stock = stock;
        }
    } 

    public int getStock() {
        return this.stock;
    }

    public void setAvailable(boolean available) {
        if ((available) && (this.stock >= this.count)) {
            this.available = available;
        }
        if ((!available) && (this.stock < this.count)) {
            this.available = available;
        }
    }

    public boolean isAvailable() {
        return available;
    }

    public void showDate() {
        System.out.printf("%S.%S.%S", this.date.get(Calendar.YEAR), (this.date.get(Calendar.MONTH) + 1), this.date.get(Calendar.DATE));
    }

    public boolean checkStock() {
        boolean isInStock;
        if (this.stock == 0) {
            isInStock = false;
        } else {
            isInStock = true;
        }
        return isInStock;
    }

    public void printInfo() {
        System.out.printf("product: %s, price: %.2f $\n", this.name, this.price);
        System.out.printf("it was produced by \'%s\' at ", this.producerName);
        this.showDate();
        System.out.printf("\nin stock left: %d, is available to buy: %b\n", this.stock, this.available);
    }

    public void getInfoFromFile(File file) throws FileNotFoundException {
        Scanner scn = new Scanner(file);
        boolean flag = false;
        Calendar dateProd = Calendar.getInstance();

        while ((scn.hasNextLine()) && (!flag)) {
            String line = scn.nextLine();
            String[] data = line.split(";");

            if (data[0].equals(this.name)) {
                flag = true;
                try {
                    this.setPrice(Double.parseDouble(data[1]));
                    dateProd.set(Integer.parseInt(data[2]), Integer.parseInt(data[3]), Integer.parseInt(data[4]));
                    this.setDate(dateProd);
                    this.stock = Integer.parseInt(data[5]);
                    this.producerName = data[6];
                } catch (NumberFormatException e) {
                    System.out.println("Error: unable to get data, there're some mistakes in the store. Call the administration to fix it");
                }
            }
        }
        scn.close();
    }      
}
