package com.develhope.CrudSpring.entities;

import jakarta.persistence.*;

@Entity
@Table
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String modelName;
    @Column(nullable = false)
    private String type;

    public Car() {}

    public Car(Long id, String modelName, String type) {
        this.id = id;
        this.modelName = modelName;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
