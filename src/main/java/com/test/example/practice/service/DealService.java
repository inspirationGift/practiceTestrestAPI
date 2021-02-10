package com.test.example.practice.service;

import com.test.example.practice.model.Deal;
import com.test.example.practice.model.dtos.DealDto;
import com.test.example.practice.model.dtos.RequestDealDto;
import com.test.example.practice.repository.DealRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class DealService {
    private final DealRepository repository;

    public DealService(DealRepository repository) {
        this.repository = repository;
    }

    public DealDto getAllDeals(RequestDealDto dto) {
        PageRequest page = PageRequest.of(dto.getPage(), dto.getPageSize(), dto.getSort());
        Page<Deal> deals = repository.findAll(page);

        DealDto respond = new DealDto();
        respond.setDeals(deals);
        return respond;
    }

}
