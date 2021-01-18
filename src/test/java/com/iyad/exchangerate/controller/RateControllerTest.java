package com.iyad.exchangerate.controller;

import com.iyad.exchangerate.dto.RateDTO;
import com.iyad.exchangerate.enums.Currency;
import com.iyad.exchangerate.enums.ExchangeRateTrend;
import com.iyad.exchangerate.exceptions.RestResponseEntityExceptionHandler;
import com.iyad.exchangerate.services.RateService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import java.math.BigDecimal;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@WebMvcTest(RateController.class)
public class RateControllerTest {


    @Mock
    private RateService rateService;

    @InjectMocks
    private RateController rateController;

    @Autowired
    private MockMvc mockMvc;


    @Before
    public void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(rateController)
                .setControllerAdvice(new RestResponseEntityExceptionHandler())
                .build();

    }

    @Test
    public void testAscendingRate() throws Exception{

        RateDTO rateDTO = new RateDTO();
        rateDTO.setId(1L);
        rateDTO.setExchangeRate(BigDecimal.valueOf(0.7));
        rateDTO.setAverageFiveDays(BigDecimal.valueOf(0.69));
        rateDTO.setExchangeRateTrend(ExchangeRateTrend.DESC);



        when(rateService.getRate("2010-03-19", Currency.EUR, Currency.CHF)).thenReturn(rateDTO);


        mockMvc.perform(get( RateController.BASE_URL + "/{date}/{baseCurrency}/{targetCurrency}", "2010-03-19", "EUR", "CHF")

                  .contentType(MediaType.APPLICATION_JSON)
                  .accept(MediaType.APPLICATION_JSON))
                  .andExpect(status().isOk())
                  .andExpect(jsonPath("$.exchange_rate", equalTo(0.7)))
                  .andExpect(jsonPath("$.average_five_days", equalTo(0.69)))
                 .andExpect(jsonPath("$.exchange_rate_trend", equalTo(ExchangeRateTrend.DESC.toString())));


    }


    @Test
    public void testErrorURLFormat() throws Exception {

        //malformed URL
        mockMvc.perform(get(RateController.BASE_URL + "/foo/CHF")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError());
    }
}