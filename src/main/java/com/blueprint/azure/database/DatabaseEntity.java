package com.blueprint.azure.database;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "entity")
public class DatabaseEntity {

    @Id
    @Column(name = "id",
        unique = true,
        nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "value")
    private String value;

    public Long getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public DatabaseEntity setValue(String value) {
        this.value = value;
        return this;
    }

}
