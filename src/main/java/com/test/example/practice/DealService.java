package com.test.example.practice;

import com.test.example.practice.repository.DealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DealService {
    private final DealRepository repository;

    public DealService(DealRepository repository) {
        this.repository = repository;
    }
}
