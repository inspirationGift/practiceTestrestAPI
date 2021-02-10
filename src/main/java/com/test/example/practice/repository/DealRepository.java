package com.test.example.practice.repository;

import com.test.example.practice.model.DealEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DealRepository extends JpaRepository<DealEntity, Long> {
    DealEntity findById(long id);

    Page<DealEntity> findAll(Pageable page);
}
