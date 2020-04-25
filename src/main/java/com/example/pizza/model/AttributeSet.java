package com.example.pizza.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="attribute_set")
public class AttributeSet implements Serializable {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long entity_id;

    @Column(name = "name", nullable = false)
    private String name;

    public long getEntityId() {
        return this.entity_id;
    }

    public String getName() {
        return this.name;
    }
}
