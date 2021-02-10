package com.test.example.practice.controllers;

import com.test.example.practice.model.dtos.DealDto;
import com.test.example.practice.model.dtos.RequestDealDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "api/deal",
        consumes = "application/json",
        produces = "application/json")
public class DealController {


    @PostMapping("/")
    public DealDto getAllDeals(@RequestBody RequestDealDto dto) {

        return null;
    }

}
