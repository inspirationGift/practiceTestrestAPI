package com.test.example.practice.model;

import com.test.example.practice.model.enums.PaymentAcceptance;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "payment", indexes = {@Index(columnList = "id,amount ASC", unique = true)})
public class Payment {
    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private int status;

    @Transient
    private PaymentAcceptance acceptanceStatus;

    @NotNull
    private float amount;
    @NotNull
    private LocalDateTime dateCreate;

    public PaymentAcceptance getAcceptanceStatus() {
        return PaymentAcceptance.getStatus(this.status);
    }
}
