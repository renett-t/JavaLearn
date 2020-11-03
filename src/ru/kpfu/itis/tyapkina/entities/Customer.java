package ru.kpfu.itis.tyapkina.entities;

import java.util.Calendar;

public class Customer extends Human {
    protected String address;
	private ShoppingCart cart;
    
    public Customer(String name, Calendar birthDate, boolean gender, String address) {
        super(name, birthDate, gender);
        if (address.length() > 2) {
            this.address = address;
        }
    }

    public void setAddress(String address) {
        if (address.length() > 2) {
            this.address = address;
        }
    }

    public String getAddress() {
        return this.address;
    }

    public ShoppingCart getCart() {
        return this.cart;
    }

    public void setCart(ShoppingCart cart) {
        this.cart = cart;
    }
}
