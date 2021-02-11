package com.test.example.practice.service;

import com.test.example.practice.exception.NullEntityReferenceException;
import com.test.example.practice.model.Invoice;
import com.test.example.practice.model.dtos.DealDto;
import com.test.example.practice.model.dtos.InvoiceDto;
import com.test.example.practice.repository.InvoiceRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class InvoiceService {
    private final InvoiceRepository repository;
    private final DealService dealService;
    private final ModelMapper mapper;

    public InvoiceService(InvoiceRepository repository, DealService dealService, ModelMapper mapper) {
        this.repository = repository;
        this.dealService = dealService;
        this.mapper = mapper;
    }

    public InvoiceDto saveInvoice(InvoiceDto dto, int dealId) throws NullEntityReferenceException {
        doesDealExist(dealId);
        dto.setDealId(dealId);
        Invoice map = mapper.map(dto, Invoice.class);
        return mapper.map(repository.save(map), InvoiceDto.class);
    }

    public InvoiceDto updateInvoice(InvoiceDto dto, int dealId, int invoiceId) throws NullEntityReferenceException {
        doesDealExist(dealId);
        Invoice invoice = doesInvoiceExist(invoiceId);

        invoice.setAmount(dto.getAmount());
        invoice.setDealId(dealId);
        invoice.setDateUpdate(dto.getDateUpdate());

        return mapper.map(repository.save(invoice), InvoiceDto.class);
    }

    private boolean doesDealExist(int dealId) throws NullEntityReferenceException {
        DealDto oneDeal = this.dealService.getOneDeal(dealId);
        return true;
    }

    private Invoice doesInvoiceExist(int invoiceId) throws NullEntityReferenceException {
        Invoice invoice = this.repository.findById(invoiceId).orElse(null);
        if (invoice == null)
            throw new NullEntityReferenceException("No such invoice found");
        return invoice;
    }

}
