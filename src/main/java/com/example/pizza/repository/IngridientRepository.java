package com.example.pizza.repository;

import com.example.pizza.entity.Ingridient;
import com.example.pizza.model.Attribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface IngridientRepository extends JpaRepository<Ingridient, Long> {
}

