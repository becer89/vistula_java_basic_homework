package org.vistula.customer;

import org.junit.Test;
import static org.junit.Assert.assertTrue;


public class CustomerTest {

    //ZADANIE 2

    @Test
    public void shouldBeMature(){
        Customer Pawel = new Customer();
        Pawel.setAge(19);
        assertTrue(Pawel.isMature());
    }
    @Test
    public void shouldBeMature2(){
        Customer Lukasz = new Customer();
        Lukasz.setAge(18);
        assertTrue(Lukasz.isMature());
    }
    @Test
        public void shouldNotBeMature(){
            Customer Stefan = new Customer();
            Stefan.setAge(17);
            assertTrue(Stefan.isImmature());
    }



}
