package com.test.example.practice.repository;

import com.test.example.practice.model.Deal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DealRepository extends PagingAndSortingRepository<Deal, Long> {
    Deal findById(long id);

    Page<Deal> findAll(Pageable page);
}
