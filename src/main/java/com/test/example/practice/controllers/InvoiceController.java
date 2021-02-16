package com.test.example.practice.controllers;

import com.test.example.practice.exception.EntityNotFoundException;
import com.test.example.practice.model.dtos.InvoiceDto;
import com.test.example.practice.service.InvoiceService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("invoices")
public class InvoiceController {

    private final InvoiceService service;

    public InvoiceController(InvoiceService service) {
        this.service = service;
    }

    @PostMapping("/deal_id/{deal_id}")
    public InvoiceDto createInvoice(@PathVariable("deal_id") Integer id, @RequestBody InvoiceDto invoice) throws EntityNotFoundException {
        return service.saveInvoice(invoice, id);
    }

    @PutMapping("/deal_id/{deal_id}/invoice/{invoice_id}")
    public InvoiceDto updateInvoice(
            @PathVariable("deal_id") Integer id,
            @PathVariable("invoice_id") Integer invId,
            @RequestBody InvoiceDto invoice) throws EntityNotFoundException {
        return service.updateInvoice(invoice, id, invId);
    }
}
