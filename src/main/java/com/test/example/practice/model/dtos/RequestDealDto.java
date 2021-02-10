package com.test.example.practice.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Sort;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestDealDto {
    private int page;
    private int pageSize;
    private List<SortObj> sort;
    private List<Integer> clientFilter;
    private List<String> typeFilter;

    public Sort getSort() {
        Sort sorting = null;
        for (SortObj obj : sort) sorting = sorting == null ? obj.getSort() : sorting.and(obj.getSort());
        return sorting;
    }

}

@Data
@AllArgsConstructor
class SortObj {
    String field;
    String order;

    public Sort getSort() {
        return order.toUpperCase().equals("ASC") ? Sort.by(field).ascending() : Sort.by(field).descending();
    }
}

