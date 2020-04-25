package com.example.pizza.entity;

import com.example.pizza.model.AttributeSet;
import com.example.pizza.model.IngridientGroup;
import com.example.pizza.model.Value;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name="ingridients_entity")
@EntityListeners(AuditingEntityListener.class)
public class Ingridient {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @JoinColumn
    private long entityId;

    @ManyToOne
    private AttributeSet attributeSet;

    @ManyToOne
    private IngridientGroup ingridientGroup;

    public long getId() {
        return entityId;
    }

    public void setId(long id) {
        this.entityId = id;
    }

    public IngridientGroup getIngridientGroup() {
        return this.ingridientGroup;
    }
}
