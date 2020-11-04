package ru.kpfu.itis.tyapkina.entities;

import java.util.Calendar;

public class GoodsClothes extends Good {
    private String color;
    private String size;
    private String category;

    public GoodsClothes(String name, double price) {
        super(name, price);
    }

    public GoodsClothes(String name, double price, Calendar date, String producerName, String color, String size) {
        super(name, price, date, producerName);
        this.setColor(color);
        this.setSize(size);
    }

    public void setColor(String color) {
        if (color.length() > 2) {
            this.color = color;
        }
    }

    public String getColor() {
        return this.color;
    }

    public void setSize(String size) {
        if ((size.length() >= 1) && (size.length() <= 4)) {
            this.size = size;
        }
    }

    public String getSize() {
        return this.size;
    }

    public void setCategory(String category) {
        if (category.length() > 2) {
            this.category = category;
        }
    }

    public String getCategory() {
        return this.category;
    }
}
