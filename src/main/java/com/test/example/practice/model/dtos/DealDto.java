package com.test.example.practice.model.dtos;

import com.test.example.practice.model.ClientEntity;
import com.test.example.practice.model.InvoiceEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
public class DealDto {
    private long id;
    private float volume;
    private LocalDateTime dateCreate;
    private String type;
    private List<ClientEntity> clients;
    private InvoiceEntity invoice;
}
