package com.example.pizza.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name="ingridient_group")
@EntityListeners(AuditingEntityListener.class)
public class IngridientGroup {

    @Id
    @Column
    @JoinColumn
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long group_id;

    @Column
    private String group_name;

    @OneToOne
    private IngridientGroup parent_group;

    public String getName() {
        return this.group_name;
    }

    public IngridientGroup getParentGroup() {
        return this.parent_group;
    }

}
