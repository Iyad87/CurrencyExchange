package com.iyad.exchangerate.controller;


import com.iyad.exchangerate.dto.RateDTO;
import com.iyad.exchangerate.model.Rate;
import com.iyad.exchangerate.repositories.RateListRepository;
import com.iyad.exchangerate.repositories.RateRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class RateController {




    private final RateRepository rateRepository;
    private final RateListRepository rateListRepository;



    public RateController(RateRepository rateRepository, RateListRepository rateListRepository) {
        this.rateRepository = rateRepository;
        this.rateListRepository = rateListRepository;
    }


    @GetMapping("/rates")
    public Iterable<RateDTO> getAllRate(){
        return rateRepository.findAll();
    }

    @GetMapping("/rates/{id}")
    public Optional<RateDTO> getRateById(@PathVariable long id){
        return rateRepository.findById(id);
    }


    @GetMapping("/ratesList")
    public Iterable<Rate> getAllRateList(){
        return rateListRepository.findAll();
    }
}


