package com.test.example.practice.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceDto {
    private int id;
    private LocalDateTime dateCreate;
    private LocalDateTime dateUpdate;
    private float amount;
    private int dealId;

}
