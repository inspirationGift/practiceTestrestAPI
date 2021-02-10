package com.test.example.practice.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestDealDto {
    private int page;
    private int pageSize;
    private int pageSort;
    private List<Integer> clientFilter;
    private List<String> typeFilter;


}
