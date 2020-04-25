package com.example.pizza.model;

import com.example.pizza.entity.Ingridient;

import javax.persistence.*;

@Entity
@Table(name="ingridient_value")
public class Value {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long value_id;

    @ManyToOne
    private Attribute attribute;

    private String value;

    @ManyToOne
    private Ingridient ingridient;

    public Attribute getAttribute() {
        return this.attribute;
    }

    public String getValue() {
        return this.value;
    }
}
