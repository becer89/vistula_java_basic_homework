package org.vistula.basket;

public class PromoItem extends BasketItem{
    double sale = 0.2  ;

    public PromoItem() {
    }

    public PromoItem(String name, float price, boolean ageRestrictedItem, double sale) {
        super(name, price, ageRestrictedItem);
        this.sale = sale;
    }

    public PromoItem(String name, float price, boolean ageRestrictedItem) {
        super(name, price, ageRestrictedItem);
    }


    public double getSale() {
        return sale;
    }

    public void setSale(double sale) {
        this.sale = sale;
    }



}
