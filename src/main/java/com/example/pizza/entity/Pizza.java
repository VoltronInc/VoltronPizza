package com.example.pizza.entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name="pizza_entity")
@EntityListeners(AuditingEntityListener.class)
public class Pizza {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private long entityId;

    @Column(name = "attribute_set_id", nullable = false)
    private Integer attributeSetId;

    public long getID() {
        return entityId;
    }

    public void setId(long id) {
        this.entityId = id;
    }

    public Integer getAttributeSetId() {
        return this.attributeSetId;
    }

}
