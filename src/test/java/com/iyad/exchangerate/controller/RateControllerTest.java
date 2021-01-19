//package com.iyad.exchangerate.controller;
//
//import com.iyad.exchangerate.dto.RateDTO;
//import com.iyad.exchangerate.enums.Currency;
//import com.iyad.exchangerate.enums.ExchangeRateTrend;
//import com.iyad.exchangerate.exceptions.RestResponseEntityExceptionHandler;
//import com.iyad.exchangerate.services.RateService;
//import org.junit.Before;
//import org.junit.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import static org.hamcrest.Matchers.equalTo;
//import static org.mockito.Mockito.when;
//import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
//import java.math.BigDecimal;
//
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//
//@WebMvcTest(RateController.class)
//public class RateControllerTest {
//
//
//    @Mock
//    private RateService rateService;
//
//    @InjectMocks
//    private RateController rateController;
//
//    @Autowired
//    private MockMvc mockMvc;
//
//
//    @Before
//    public void setUp() throws Exception {
//        MockitoAnnotations.initMocks(this);
//        mockMvc = MockMvcBuilders.standaloneSetup(rateController)
//                .setControllerAdvice(new RestResponseEntityExceptionHandler())
//                .build();
//
//    }
//
////    @Test
////    public void testAscendingRate() throws Exception{
////
////        RateDTO rateDTO = new RateDTO();
////        rateDTO.setId(1L);
////        when(rateService.getRate()).thenReturn(rateDTO);
//////
//////        mockMvc.perform(get( rateController.getAllRateList())
//////
//////                  .contentType(MediaType.APPLICATION_JSON)
//////                  .accept(MediaType.APPLICATION_JSON))
//////                  .andExpect(status().isOk())
//////                  .andExpect(jsonPath("$.exchange_rate", equalTo(0.7)));
//////
//////
//////    }
//
//}