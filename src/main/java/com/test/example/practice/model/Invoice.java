package com.test.example.practice.model;

import com.test.example.practice.model.enums.PaymentStatus;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "invoice")
@ToString
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private int id;
    @NotNull
    @CreationTimestamp
    private LocalDateTime dateCreate;
    private LocalDateTime dateUpdate;
    private float amount;

    @NotNull
    @Column(name = "deal_id")
    private int dealId;

    @Transient
    @ToString.Exclude
    private PaymentStatus paymentStatus;


    @OneToMany
    @JoinColumn(referencedColumnName = "id", name = "invoice_id")
    @ToString.Exclude
    private List<Payment> payment;


    public PaymentStatus getPaymentStatus() {
        return PaymentStatus.getStatus(this.payment, this.amount);
    }
}
