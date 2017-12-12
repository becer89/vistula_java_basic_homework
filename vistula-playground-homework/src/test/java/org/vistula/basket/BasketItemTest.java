package org.vistula.basket;


import org.junit.Test;
import org.vistula.customer.Customer;
import java.util.LinkedList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;



public class BasketItemTest {

    private BasketItem wino = new BasketItem("wino", 28, true);
    private BasketItem wodka = new BasketItem("wodka", 25, true);
    private BasketItem chleb = new BasketItem("chleb", 3, false);
    private BasketItem sok = new BasketItem("sok", 6, false);
    private BasketItem chipsy = new BasketItem("chipsy", 8, false);

    private float totalPricee;


    @Test
    public void totalPriceTest() {
        List<BasketItem> basket = new LinkedList<>();
        basket.add(wino);
        basket.add(wodka);
        basket.add(chleb);
        basket.add(sok);
        basket.add(chipsy);

        for (int i = 0; i < basket.size(); i++) {
            totalPricee = totalPricee + basket.get(i).getPrice();
            System.out.println("Cena " + basket.get(i).getName() + " wynosi: " + basket.get(i).getPrice());
        }
        System.out.println("Całkowita cena produktów w koszyku to: " + totalPricee);

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
        Pawel.setAge(16);

        for (int i=0; i<basket.size(); i++) {

            if (Pawel.isInMature() && basket.get(i).isAgeRestrictedItem()) {
                System.out.println("Masz " + Pawel.getAge() + " lat. Nie możesz kupić " + basket.get(i).getName() + "!");
            } else {
                System.out.println("Masz " + Pawel.getAge() + " lat. Możesz kupić " + basket.get(i).getName() + "!");
            }
        }


    }
}







