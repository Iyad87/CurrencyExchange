package com.iyad.exchangerate.model;


import com.iyad.exchangerate.enums.Currency;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.EnumMap;
import java.util.Map;

@Entity
public class Rate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private Currency baseCurrency;
    private EnumMap<Currency, BigDecimal> rates;
    private String date;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Currency getBaseCurrency() {
        return baseCurrency;
    }

    public void setBaseCurrency(Currency baseCurrency) {
        this.baseCurrency = baseCurrency;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Map<Currency, BigDecimal> getRates() {
        return rates;
    }

    public void setRates(EnumMap<Currency, BigDecimal> rates) {
        this.rates = rates;
    }

}
