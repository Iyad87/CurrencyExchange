package com.iyad.exchangerate.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(RateController.BASE_URL)

public class RateController {


    public static final String BASE_URL = "/api/exchange-rate";



}
