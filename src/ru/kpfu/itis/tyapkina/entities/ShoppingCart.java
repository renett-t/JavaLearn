package ru.kpfu.itis.tyapkina.entities;

public class ShoppingCart {
    protected int numberOfGoods;
    protected Good[] goods;

    public void setNumberOfGoods(int numberOfGoods) {
        if (numberOfGoods >= 0) {
            this.numberOfGoods = numberOfGoods;
        }
    }

    public int getNumberOfGoods() {
        return this.numberOfGoods;
    }

    public void setGoods(int n) { //not that typical??? setter
        if (n > 0) {
            this.goods = new Good[n];    
        }    
    }

    public Good[] getGoods(){
        return this.goods;
    }

    public void setGood(int i, Good good) {
        if ((i >= 0) && (i < this.goods.length)) {
            this.goods[i] = good;
        }
    }

    public Good getGood(int i) {
        if ((i >= 0) && (i < this.goods.length)) {
            return this.goods[i];
        }               //can i create a getter with a parameter? is it even considered a getter cause i just call for 1 element of array goods[]
        return null;    //костыль
    }

    public double countCheque() {
        double sum = 0;
        for (int i = 0; i < this.numberOfGoods ; i++) {
            sum += this.goods[i].getPrice() * this.goods[i].getCount();
        }
        return Math.round(sum * 100.0) / 100.0;
    }

    public void removeFromCart(Good good) {
        good = null;
        setNumberOfGoods(this.numberOfGoods - 1);
    }
}
