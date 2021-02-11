package com.test.example.practice.service;

import com.test.example.practice.exception.EntityNotFoundException;
import com.test.example.practice.model.Invoice;
import com.test.example.practice.model.dtos.InvoiceDto;
import com.test.example.practice.model.enums.PaymentStatus;
import com.test.example.practice.repository.InvoiceRepository;
import org.junit.Assert;
import org.junit.function.ThrowingRunnable;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@RunWith(SpringRunner.class)
@SpringBootTest
class InvoiceServiceTest {

    @Autowired
    private InvoiceService service;

    @Autowired
    private ModelMapper mapper;

    @MockBean
    private InvoiceRepository repository;


    @Test
    void saveInvoice() throws EntityNotFoundException {
        Invoice invoice = new Invoice();
        invoice.setDateUpdate(null);
        invoice.setDateCreate(null);
        invoice.setAmount(100);
        invoice.setDealId(1);
        invoice.setPaymentStatus(PaymentStatus.PAID);


        when(repository.save(any(Invoice.class))).thenReturn(invoice);

        InvoiceDto actual = service.saveInvoice(mapper.map(invoice, InvoiceDto.class), 1);
        verify(repository, times(1)).save(invoice);
        Invoice map = mapper.map(actual, Invoice.class);
        Assert.assertEquals("Shared invoice same as saved:", invoice, map);
        Assert.assertNull("New invoice with no payment list:", map.getPayment());
        Assert.assertEquals("NOt_PAID if no payment:", map.getPaymentStatus(), PaymentStatus.NOT_PAID);
    }

    @Test
    void saveInvoiceWithInvalidDealId() {
        Invoice invoice = new Invoice();
        invoice.setDateUpdate(null);
        invoice.setDateCreate(null);
        invoice.setAmount(100);
        invoice.setDealId(100);
        invoice.setPaymentStatus(PaymentStatus.PAID);

        InvoiceDto map = mapper.map(invoice, InvoiceDto.class);

        Exception exception = assertThrows(EntityNotFoundException.class, () -> {
            service.saveInvoice(map, -1);
        });

        String expectedMessage = "Not found such deal!";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));


    }

    @Test
    void updateInvoice() throws EntityNotFoundException {

        Invoice invoice = new Invoice();
        invoice.setId(1);
        invoice.setDateUpdate(null);
        invoice.setDateCreate(null);
        invoice.setAmount(100);
        invoice.setDealId(1);
        invoice.setPaymentStatus(PaymentStatus.PAID);

        when(repository.findById(anyInt())).thenReturn(Optional.of(invoice));
        when(repository.save(any(Invoice.class))).thenReturn(invoice);

        InvoiceDto map = mapper.map(invoice, InvoiceDto.class);

        InvoiceDto invoiceDto = service.updateInvoice(map, 1, 1);
        verify(repository, times(1)).findById(invoice.getId());
        verify(repository, times(1)).save(invoice);
        Assert.assertEquals(invoice, mapper.map(invoiceDto, Invoice.class));

    }
}
