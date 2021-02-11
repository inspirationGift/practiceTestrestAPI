package com.test.example.practice.repository;

import com.test.example.practice.model.Deal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DealRepository extends PagingAndSortingRepository<Deal, Long> {
    Deal findById(int id);

    Page<Deal> findAll(Pageable page);

    Page<Deal> findAllByTypeIsIn(Pageable page, List<String> type);

    Page<Deal> findAllByIdIsIn(Pageable page, List<Integer> dealId);

    Page<Deal> findAllByTypeIsInAndIdIsIn(Pageable page, List<String> type, List<Integer> dealId);

    @Query(value = "SELECT distinct deal_id as id" +
            "  FROM deal_client  " +
            "  WHERE client_id in (:clientIds)",
            nativeQuery = true)
    List<Integer> getDealByClients(List<Integer> clientIds);

}
