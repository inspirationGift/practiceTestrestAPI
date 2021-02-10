package com.test.example.practice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.test.example.practice.model.enums.PaymentStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "invoice")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private long id;
    @NotNull
    private LocalDateTime dateCreate;
    private LocalDateTime dateUpdate;
    private float amount;
    @Transient
    private PaymentStatus paymentStatus;

    @OneToMany
    @JoinTable(
            name = "payment",
            joinColumns = @JoinColumn(name = "invoice_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "id")
    )
    private List<Payment> payment;

    public PaymentStatus getPaymentStatus() {
        return PaymentStatus.getStatus(this.payment, this.amount);
    }
}
