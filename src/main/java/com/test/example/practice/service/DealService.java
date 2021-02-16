package com.test.example.practice.service;

import com.test.example.practice.exception.EntityNotFoundException;
import com.test.example.practice.model.Client;
import com.test.example.practice.model.Deal;
import com.test.example.practice.model.dtos.DealDto;
import com.test.example.practice.model.dtos.RequestDealDto;
import com.test.example.practice.model.enums.SortingType;
import com.test.example.practice.repository.DealRepository;
import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import javax.persistence.criteria.CriteriaBuilder.In;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DealService {
    private final DealRepository repository;

    public DealService(DealRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @PersistenceContext
    private EntityManager em;

    private final ModelMapper mapper;

    public DealDto.DealsWrapper getAllDeals(List<Integer> clientIds, List<String> types,
                                            Integer page, Integer size,
                                            SortingType volume, SortingType date, SortingType type
    ) throws EntityNotFoundException {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Deal> cQuery = cb.createQuery(Deal.class);
        Root<Deal> dealRoot = cQuery.from(Deal.class);
        cQuery = cQuery.select(dealRoot);

        //filters
//        if (clientIds != null) {
//        }

        if (types != null && !types.isEmpty()) {
            In<String> inType = cb.in(dealRoot.get("type"));
            types.forEach(a -> inType.value(String.valueOf(a)));
            cQuery.where(inType);
        }

        // sorting
        List<Order> orders = List.of(
                volume == SortingType.DESC ? cb.desc(dealRoot.get("volume")) : cb.asc(dealRoot.get("volume")),
                date == SortingType.DESC ? cb.desc(dealRoot.get("dateCreate")) : cb.asc(dealRoot.get("dateCreate")),
                type == SortingType.DESC ? cb.desc(dealRoot.get("type")) : cb.asc(dealRoot.get("type"))
        );
        cQuery.orderBy(orders);


        CriteriaQuery<Long> countQuery = cb.createQuery(Long.class);
        countQuery.select(cb.count(countQuery.from(Deal.class)));
        Long count = em.createQuery(countQuery).getSingleResult();


        DealDto.DealsWrapper dealsWrapper = new DealDto.DealsWrapper();


        TypedQuery<Deal> query = em.createQuery(cQuery);
        while (page < count) {
            query.setFirstResult(page - 1);
            query.setMaxResults(size);
            query.getResultList().forEach(a -> dealsWrapper.setRecord(mapper.map(a, DealDto.class)));
            page += size;
        }

        if (dealsWrapper.getRecords().size() == 0) throw new EntityNotFoundException("Not found such deal!");
        dealsWrapper.setTotalElements(count);
        dealsWrapper.setTotalPages(count / size);

        return dealsWrapper;
    }

    public DealDto getOneDeal(Integer id) throws EntityNotFoundException {
        Deal deal = repository.findById(id);
        if (deal == null) throw new EntityNotFoundException("Not found such deal!");

        return mapper.map(deal, DealDto.class);
    }


}

