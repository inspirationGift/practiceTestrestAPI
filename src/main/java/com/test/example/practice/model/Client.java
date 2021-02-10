package com.test.example.practice.model;

import com.test.example.practice.model.enums.ClientType;
import com.test.example.practice.model.keys.TypeKey;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@Entity
@Table(name = "client")
public class Client {
    @EmbeddedId
    private TypeKey key;

    @Column(name = "type_id", nullable = false, insertable = false, updatable = false)
    private int typeId;

    @Transient
    private ClientType type;

    @Size(max = 77)
    @Column(nullable = false)
    private String name;

    public ClientType getType() {
        return ClientType.getType(this.typeId);
    }
}
