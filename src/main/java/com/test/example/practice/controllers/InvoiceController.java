package com.test.example.practice.controllers;

import com.test.example.practice.exception.EntityNotFoundException;
import com.test.example.practice.model.dtos.InvoiceDto;
import com.test.example.practice.service.InvoiceService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("invoice")
public class InvoiceController {

    private final InvoiceService service;

    public InvoiceController(InvoiceService service) {
        this.service = service;
    }

    @PostMapping("/create/dealId/{dealId}")
    public InvoiceDto createInvoice(@PathVariable("dealId") Integer id, @RequestBody InvoiceDto invoice) throws EntityNotFoundException {
        return service.saveInvoice(invoice, id);
    }

    @PutMapping("/update/dealId/{dealId}/invoice/{invId}")
    public InvoiceDto updateInvoice(
            @PathVariable("dealId") Integer id,
            @PathVariable("invId") Integer invId,
            @RequestBody InvoiceDto invoice) throws EntityNotFoundException {
        return service.updateInvoice(invoice, id, invId);
    }
}
