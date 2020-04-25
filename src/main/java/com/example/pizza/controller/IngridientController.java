package com.example.pizza.controller;

import com.example.pizza.entity.Ingridient;
import com.example.pizza.model.IngridientDto;
import com.example.pizza.model.Value;
import com.example.pizza.repository.IngridientAttributeRepository;
import com.example.pizza.repository.IngridientRepository;
import javassist.NotFoundException;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping
public class IngridientController {
    @Autowired
    private IngridientRepository ingridientRepository;

    @Autowired
    private IngridientAttributeRepository ingridientAttributeRepository;

    @GetMapping("/ingridient/")
    public JSONObject getAllIngridients() {
        List<Ingridient> ingridients = ingridientRepository.findAll();
        Long[] indgridientsIds = new Long[ingridients.size()];
        HashMap<Ingridient, List<Value>> ingridientListHashMap = new HashMap<>();
        for (int i = 0; i<ingridients.size(); i++) {
            Ingridient ingridient = ingridients.get(i);
            ingridientListHashMap.put(ingridient,ingridientAttributeRepository.findAllValuesWithIngridient(ingridient.getId()));
        }

        IngridientDto dto = new IngridientDto(ingridientListHashMap);

        return dto.toJson();
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
