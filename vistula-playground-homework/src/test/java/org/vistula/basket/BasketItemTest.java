package org.vistula.basket;


import org.junit.Test;
import org.vistula.customer.Customer;

import java.util.LinkedList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class BasketItemTest {

    private BasketItem wino = new BasketItem("wino", 28, true);
    private BasketItem wodka = new BasketItem("wodka", 25, true);
    private BasketItem chleb = new BasketItem("chleb", 3, false);
    private BasketItem sok = new BasketItem("sok", 6, false);
    private BasketItem chipsy = new BasketItem("chipsy", 8, false);
    private PromoItem czekolada = new PromoItem("czekolada", 10, false);

    private float totalPricee;

    // ZADANIE 3

    @Test
    public void totalPriceTest() {
        List<BasketItem> basket = new LinkedList<>();
        basket.add(wino);
        basket.add(wodka);
        basket.add(chleb);
        basket.add(sok);
        basket.add(chipsy);
        System.out.println("Ceny poszczególnych produktów:");
        for (int i = 0; i < basket.size(); i++) {
            totalPricee = totalPricee + basket.get(i).getPrice();
            System.out.println( basket.get(i).getName() +" - " + basket.get(i).getPrice()+" zł.");
        }
        System.out.println("Suma: " + totalPricee+" zł.");

        assertThat(totalPricee).isEqualTo(70);
        assertThat(totalPricee).isNotEqualTo(63);
    }

    @Test
    public void buyingRestrictedProductsTest() {
        List<BasketItem> basket = new LinkedList<>();
        basket.add(wino);
        basket.add(wodka);
        basket.add(chleb);
        basket.add(sok);
        basket.add(chipsy);

        Customer Pawel = new Customer();
        Pawel.setAge(17);

        for (int i=0; i<basket.size(); i++) {

            if (Pawel.isImmature() && basket.get(i).isAgeRestrictedItem()) {
                System.out.println("Masz " + Pawel.getAge() + " lat. Nie możesz kupić " + basket.get(i).getName() + "!");
            } else {
                System.out.println("Masz " + Pawel.getAge() + " lat. Możesz kupić " + basket.get(i).getName() + "!");
            }
        }

    }

    // ZADANIE 4 I ZADANIE 5
    @Test
    public void productsAddedToBasket(){

        List<BasketItem> basket = new LinkedList<>();
        basket.add(wino);
        basket.add(wodka);
        basket.add(chleb);
        basket.add(sok);
        basket.add(chipsy);

        Customer Pawel = new Customer();
        Pawel.setAge(17);

        System.out.println("Masz "+Pawel.getAge()+" lat.");
        System.out.println("W twoim koszuku znajduje się:");
        for (int j=0; j<basket.size(); j++){
            if (Pawel.isImmature() && basket.get(j).isAgeRestrictedItem() == false){
                System.out.print( basket.get(j).getName()+" ");
            } else {
                if (Pawel.isMature()){
                    System.out.println( basket.get(j).getName());
                }
            }
        }
        System.out.println();
        System.out.println("Ze względu na niepełnoletność nie możesz kupić:");
        for (int j=0; j<basket.size(); j++){
            if (Pawel.isImmature() && basket.get(j).isAgeRestrictedItem() == true){
                System.out.print( basket.get(j).getName()+" ");
            }
        }
    }

    @Test
    public void ageRestrictedTest1(){
        Customer Stefan = new Customer();
        Stefan.setAge(19);

        assertTrue(Stefan.isMature() && wodka.ageRestrictedItem);
    }

    @Test
    public void ageRestrictedTest2(){
        Customer Jerzy = new Customer();
        Jerzy.setAge(17);
        assertFalse(Jerzy.isMature() && chleb.ageRestrictedItem);

    }

    // ZADANIE 6

    @Test
    public void productsRemovedFromBasket(){

        List<BasketItem> basket = new LinkedList<>();
        basket.add(wino);
        basket.add(wodka);
        basket.add(chleb);
        basket.add(sok);
        basket.add(chipsy);

        assertThat(basket.size()).isEqualTo(5);

        System.out.println("W koszyku znajduje się "+ basket.size()+" produktów.");

        basket.remove(wino);
        System.out.println("Usunięcie produktu wino");
        System.out.println("Po zmianie w koszyku znajduje się "+ basket.size()+" produktów.");


        assertThat(basket.size()).isEqualTo(4);
        assertThat(basket.size()).isNotEqualTo(5);

    }

    //ZADANIE 9

    @Test
    public void promotionPriceTest1(){


        double promoPrice;
        promoPrice = czekolada.getPrice()- czekolada.getPrice()*czekolada.getSale();
        System.out.println("Cena stała czekolady to: "+czekolada.getPrice()+" zł.\nCena czekolady w promocji to: " + promoPrice+" zł.");

        assertThat(promoPrice).isEqualTo(8);
        assertThat(promoPrice).isNotEqualTo(10);
    }

    @Test
    public void promotionPriceTest2(){
        PromoItem wodkaJesionowka = new PromoItem();
        wodkaJesionowka.setPrice(23);
        double promoPrice = wodkaJesionowka.getPrice()- wodkaJesionowka.getPrice()*wodkaJesionowka.getSale();
        System.out.println("Cena stała Wódki Jesionówki to: "+wodkaJesionowka.getPrice()+" zł.\nCena Wódki Jesionówki w promocji to: "+promoPrice+" zł.");

        assertThat(promoPrice).isEqualTo(18.4);
        assertThat(promoPrice).isNotEqualTo(23);
    }




}







