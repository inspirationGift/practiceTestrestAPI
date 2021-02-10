package com.test.example.practice.model.keys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
//@SecondaryTable(name = "client_type",
//        pkJoinColumns = @PrimaryKeyJoinColumn(referencedColumnName = "type_id"))
public class TypeKey implements Serializable {
    @NotNull
    private int id;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int type_id;

//    @Column(name = "name", table = "client_type")
//    private String name;
}
