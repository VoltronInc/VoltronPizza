package com.example.pizza.controller;

import com.example.pizza.entity.Ingridient;
import com.example.pizza.repository.IngridientRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping
public class IngridientController {
    @Autowired
    private IngridientRepository ingridientRepository;

    @GetMapping("/ingridient/")
    public List<Ingridient> getAllIngridients() {
        return ingridientRepository.findAll();
    }

    @GetMapping("/pizza/{id}")
    public ResponseEntity<Ingridient> getIngridientById(@PathVariable(value = "id") Long ingridientId)
            throws NotFoundException {
        Ingridient ingridient = ingridientRepository.findById(ingridientId)
                .orElseThrow(() -> new NotFoundException("Ingridient not found"));

        return ResponseEntity.ok().body(ingridient);
    }

    @PostMapping("/ingridient")
    public Ingridient createIngridient(@Valid @RequestBody Ingridient ingridient) {
        return ingridientRepository.save(ingridient);
    }

    @PutMapping("/ingridient/{id}")
    public ResponseEntity<Ingridient> updateIngridient(
            @PathVariable(value = "entity_id") Long ingridientId,
            @Valid @RequestBody Ingridient ingridientDetails
    ) throws NotFoundException {
        Ingridient ingridient = ingridientRepository.findById(ingridientId)
                .orElseThrow(() -> new NotFoundException("Ingridient not found"));
        final Ingridient updatedIngridient = ingridientRepository.save(ingridient);

        return ResponseEntity.ok(updatedIngridient);
    }

}
