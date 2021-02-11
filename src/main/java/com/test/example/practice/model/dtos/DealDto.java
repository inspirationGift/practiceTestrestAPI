package com.test.example.practice.model.dtos;

import com.test.example.practice.model.Deal;
import com.test.example.practice.model.Invoice;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Pageable;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DealDto {
    private List<Deal> deals;
    private Pageable page;
    private int total;
}
