package com.iyad.exchangerate.model;

import com.iyad.exchangerate.enums.Currency;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateTest {

    private Rate rate;
    @BeforeEach
    public void setUp(){

        rate = new Rate();
    }

    @Test
    public void testGetId(){
        Long idValue = 5L;
        rate.setId(idValue);
        assertEquals(idValue, rate.getId());
    }

    @Test
    public void testGetCurrency(){
        Currency currency = Currency.USD;
        rate.setBaseCurrency(currency);
        assertEquals(currency,rate.getBaseCurrency());

    }
}