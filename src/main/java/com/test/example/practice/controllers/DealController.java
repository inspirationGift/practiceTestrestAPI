package com.test.example.practice.controllers;

import com.test.example.practice.exception.EntityNotFoundException;
import com.test.example.practice.service.DealService;
import com.test.example.practice.model.dtos.DealDto;
import com.test.example.practice.model.dtos.RequestDealDto;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(name = "deal")
public class DealController {

    private final DealService dealService;

    public DealController(DealService dealService) {
        this.dealService = dealService;
    }

    @RequestMapping(value = "/id/{id}/", method = RequestMethod.GET)
    public DealDto getOneDeal(@PathVariable("id") Integer id) throws EntityNotFoundException {
        return this.dealService.getOneDeal(id);
    }

    @PostMapping("/")
    public DealDto getAllDeals(@RequestBody RequestDealDto dto) throws EntityNotFoundException {
        return this.dealService.getAllDeals(dto);
    }
}
