package com.example.pizza.repository;

import com.example.pizza.entity.Ingridient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngridientRepository extends JpaRepository<Ingridient, Long> {
}
