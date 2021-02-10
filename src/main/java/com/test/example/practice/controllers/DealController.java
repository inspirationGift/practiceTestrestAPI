package com.test.example.practice.controllers;

import com.test.example.practice.service.DealService;
import com.test.example.practice.model.dtos.DealDto;
import com.test.example.practice.model.dtos.RequestDealDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(name = "api/deal",
        consumes = "application/json",
        produces = "application/json")
public class DealController {

    private final DealService dealService;

    public DealController(DealService dealService) {
        this.dealService = dealService;
    }


    @PostMapping("/")
    public DealDto getAllDeals(@RequestBody RequestDealDto dto) {
        return this.dealService.getAllDeals(dto);
    }

}
