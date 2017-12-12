package org.vistula.customer;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;


public class CustomerTest {


    @Test
    public void shouldBeMature(){
        Customer Pawel = new Customer();
        Pawel.setAge(19);
        assertThat(Pawel.isMature()).isTrue();
    }
    @Test
    public void shouldBeMature2(){
        Customer Lukasz = new Customer();
        Lukasz.setAge(18);
        assertThat(Lukasz.isMature()).isTrue();
    }
    @Test
    public void shouldNotBeMature(){
        Customer Stefan = new Customer();
        Stefan.setAge(17);
        assertThat(Stefan.isMature()).isFalse();
    }



}
