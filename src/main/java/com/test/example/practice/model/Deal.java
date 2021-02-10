package com.test.example.practice.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "deal")
public class Deal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    private float volume;
    private LocalDateTime dateCreate;
    @Size(max = 2)
    private String type;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "deal_client",
            joinColumns = @JoinColumn(name = "deal_id"),
            inverseJoinColumns = {@JoinColumn(name = "client_id"),
                    @JoinColumn(name = "client_type")})
    private Set<Client> client;

    @ManyToOne
    @JoinTable(name = "invoice",
            inverseJoinColumns = {@JoinColumn(name = "deal_id", nullable = false)})
    private Invoice invoice;


}
