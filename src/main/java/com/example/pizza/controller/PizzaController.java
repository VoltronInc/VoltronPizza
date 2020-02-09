package com.example.pizza.controller;

import com.example.pizza.entity.Pizza;
import com.example.pizza.repository.PizzaRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PizzaController {
    @Autowired
    private PizzaRepository pizzaRepository;

    @GetMapping("/pizza/")
    public List<Pizza> getAllPizzas() {
        return pizzaRepository.findAll();
    }

    @GetMapping("/pizza/{id}")
    public ResponseEntity<Pizza> getPizzaById(@PathVariable(value = "id") Long pizzaId)
            throws NotFoundException {
        Pizza pizza = pizzaRepository.findById(pizzaId)
                .orElseThrow(() -> new NotFoundException("Pizza not found"));

        return ResponseEntity.ok().body(pizza);
    }

    @PostMapping("/pizza")
    public Pizza createPizza(@Valid @RequestBody Pizza pizza) {
        return pizzaRepository.save(pizza);
    }

    @PutMapping("/pizza/{id}")
    public ResponseEntity<Pizza> updatePizza(
            @PathVariable(value = "entity_id") Long pizzaId,
            @Valid @RequestBody Pizza pizzaDetails
    ) throws NotFoundException {
        Pizza pizza = pizzaRepository.findById(pizzaId)
                .orElseThrow(() -> new NotFoundException("Pizza not found"));
        final Pizza updatedPizza = pizzaRepository.save(pizza);

        return ResponseEntity.ok(updatedPizza);
    }
}
