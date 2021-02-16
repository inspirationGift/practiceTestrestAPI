package com.test.example.practice.controllers;

import com.test.example.practice.exception.EntityNotFoundException;
import com.test.example.practice.model.enums.SortingType;
import com.test.example.practice.service.DealService;
import com.test.example.practice.model.dtos.DealDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(name = "deals",
        produces = MediaType.APPLICATION_JSON_VALUE)
public class DealController {

    private final DealService dealService;

    public DealController(DealService dealService) {
        this.dealService = dealService;
    }

    @GetMapping(value = "/deals/{deal_id}/")
    public DealDto oneDeal(@PathVariable("deal_id") Integer id) throws EntityNotFoundException {
        return this.dealService.getOneDeal(id);
    }

    @GetMapping({
            "/clients/{clientIds}/types/{types}/page/{page}/size/{size}/sortby/volume/{volume}/date/{date}/type/{type}",
            "/clients/{clientIds}/page/{page}/size/{size}/sortby/volume/{volume}/date/{date}/type/{type}",
            "/types/{types}/page/{page}/size/{size}/sortby/volume/{volume}/date/{date}/type/{type}",
            "/page/{page}/size/{size}/sortby/volume/{volume}/date/{date}/type/{type}"
    })
    public DealDto.DealsWrapper allDeals(
            @PathVariable(name = "clientIds", required = false) Optional<List<Integer>> clientIds,
            @PathVariable(name = "types", required = false) Optional<List<String>> types,
            @PathVariable("page") Integer page,
            @PathVariable("size") Integer size,
            @PathVariable("volume") SortingType volume,
            @PathVariable("date") SortingType date,
            @PathVariable("type") SortingType type
    ) throws EntityNotFoundException {
        return this.dealService.getAllDeals(clientIds.orElse(null),
                types.orElse(null), page, size, volume, date, type);
    }
}
