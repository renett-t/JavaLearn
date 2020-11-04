package ru.kpfu.itis.tyapkina.entities;

public class Product {
    protected String name;
    protected double price;

    public Product(String name) {
        this.setName(name);
    }

    public Product(String name, double price) {
        if (name.length() > 2) {
            this.name = name;
        }
        if (price > 0) {
            this.price = price;
        }
    }

    public void setName(String name) {
        if (name.length() > 2) {
            this.name = name;
        }
    }

    public String getName() {
        return this.name;
    }

    public void setPrice(double price) {
        if (price > 0) {
            this.price = price;
        }
    }

    public double getPrice() {
        return this.price;
    }
}
