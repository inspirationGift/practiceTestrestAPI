package com.test.example.practice.controllers;

import com.test.example.practice.exception.NullEntityReferenceException;
import com.test.example.practice.service.DealService;
import com.test.example.practice.model.dtos.DealDto;
import com.test.example.practice.model.dtos.RequestDealDto;
import org.springframework.web.bind.annotation.*;


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
    public DealDto getAllDeals(@RequestBody RequestDealDto dto) throws NullEntityReferenceException {
        return this.dealService.getAllDeals(dto);
    }

    @GetMapping("/{dealId}")
    public DealDto getOneDeals(@PathVariable("dealId") int id) throws NullEntityReferenceException {
        return this.dealService.getOne(id);
    }

}
