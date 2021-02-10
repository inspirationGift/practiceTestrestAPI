package com.test.example.practice.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "payment")
public class PaymentEntity {
    @Id
    @NotNull
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @NotNull
    private int status;
    @NotNull
    private float amount;
    @NotNull
    private LocalDateTime dateCreate;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "id")
    private InvoiceEntity invoice;


}
