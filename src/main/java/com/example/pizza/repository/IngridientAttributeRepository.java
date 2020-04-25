package com.example.pizza.repository;

import com.example.pizza.model.Attribute;
import com.example.pizza.model.Value;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngridientAttributeRepository extends CrudRepository<Attribute, Long> {
    @Query("FROM Value AS value JOIN Attribute as attr on attr = value.attribute WHERE value.ingridient.entityId in ?1")
    public List<Value> findAllValuesWithIngridient(Long id);
}
