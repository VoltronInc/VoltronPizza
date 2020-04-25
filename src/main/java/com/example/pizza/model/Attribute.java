package com.example.pizza.model;

import com.example.pizza.entity.Ingridient;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table
@EntityListeners(AuditingEntityListener.class)
public class Attribute implements Serializable {
    @Id
    @JoinColumn
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long attribute_id;

    @Column
    private String name;

    @ManyToOne
    @JoinColumn
    private AttributeSet attributeSet;

    @OneToMany(mappedBy="value")
    private List<Value> valueList;

    public List<Value> getValue() {
        return this.valueList;
    }

    public String getName() {
        return this.name;
    }
}
