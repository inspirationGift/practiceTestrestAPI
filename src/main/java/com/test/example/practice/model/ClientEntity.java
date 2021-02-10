package com.test.example.practice.model;

import com.test.example.practice.model.keys.TypeKey;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@Entity
@Table(name = "client")
public class ClientEntity {
    @EmbeddedId
    private TypeKey key;

    @MapsId("typeId")
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "id", columnDefinition = "type_id")
    private ClientType type;

    @Size(max = 77)
    @Column(nullable = false)
    private String name;

}
