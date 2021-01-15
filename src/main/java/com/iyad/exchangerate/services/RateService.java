package com.iyad.exchangerate.services;


import com.iyad.exchangerate.dto.RateDTO;
import com.iyad.exchangerate.enums.Currency;

public interface RateService {

    RateDTO getRate(String date, Currency baseCurrency, Currency targetCurrency);

}

