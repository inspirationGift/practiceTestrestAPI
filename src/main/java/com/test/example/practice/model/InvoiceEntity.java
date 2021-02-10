package com.test.example.practice.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "invoice", indexes = @Index(columnList = "id ASC"))
public class InvoiceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private long id;
    @NotNull
    private LocalDateTime dateCreate;
    private LocalDateTime dateUpdate;
    private float amount;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "id", columnDefinition = "deal_id")
    private DealEntity deal;

}
