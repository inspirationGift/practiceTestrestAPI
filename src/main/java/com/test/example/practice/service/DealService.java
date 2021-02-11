package com.test.example.practice.service;

import com.test.example.practice.exception.NullEntityReferenceException;
import com.test.example.practice.model.Deal;
import com.test.example.practice.model.dtos.DealDto;
import com.test.example.practice.model.dtos.RequestDealDto;
import com.test.example.practice.repository.DealRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DealService {
    private final DealRepository repository;

    public DealService(DealRepository repository) {
        this.repository = repository;
    }

    public DealDto getAllDeals(RequestDealDto dto) throws NullEntityReferenceException {
        PageRequest page = PageRequest.of(dto.getPage(), dto.getPageSize(), dto.getSort());

        Page<Deal> deals;
        List<Integer> dealIds = null;

        List<Integer> clientsFilter = dto.getClientFilter();
        List<String> typeFilter = dto.getTypeFilter();

        if (clientsFilter != null) dealIds = repository.getDealByClients(clientsFilter);

        if (clientsFilter != null && typeFilter != null) {
            deals = repository.findAllByTypeIsInAndIdIsIn(page, typeFilter, clientsFilter);
        } else if (clientsFilter != null) {
            deals = repository.findAllByIdIsIn(page, dealIds);
        } else if (typeFilter != null) {
            deals = repository.findAllByTypeIsIn(page, typeFilter);
        } else {
            deals = repository.findAll(page);
        }

        if (deals == null) throw new NullEntityReferenceException("not found data by parameters!");

        DealDto respond = new DealDto();
        respond.setPage(deals.getPageable());
        respond.setDeals(filterClients(deals, clientsFilter));
        respond.setTotal(deals.getTotalPages());
        return respond;
    }

    private List<Deal> filterClients(Page<Deal> deals, List<Integer> clientId) {
        if (clientId == null) return deals.getContent();

        deals.getContent().forEach(deal -> deal.getClient().removeIf(client -> !clientId.contains(client.getKey().getId())));
        return deals.toList();
    }

    public DealDto getOne(int id) throws NullEntityReferenceException {
        Deal byId = repository.findById(id);

        if (byId == null) throw new NullEntityReferenceException("not found data by parameters!");

        DealDto respond = new DealDto();
        respond.setDeals(List.of(byId));
        return respond;
    }
}
