package com.example.pizza.model;

import org.json.simple.JSONObject;
import com.example.pizza.entity.Ingridient;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class IngridientDto {
    private HashMap<Ingridient, List<Value>> ingridient;
    private HashMap<IngridientGroup, HashMap<Ingridient, List<Value>>> groups;
    public IngridientDto(HashMap<Ingridient, List<Value>> ingridient) {
        this.ingridient = ingridient;
        this.groups = new HashMap<>();
    }

    public JSONObject toJson() {
        this.mapGroup();
        return this.buildGroup();
    }

    private void mapGroup() {
        for (Map.Entry<Ingridient, List<Value>> entry : this.ingridient.entrySet()) {
            IngridientGroup group = entry.getKey().getIngridientGroup();
            if (this.groups.get(group) != null) {
                HashMap<Ingridient, List<Value>> ingridientList = this.groups.get(group);
                ingridientList.put(entry.getKey(), entry.getValue());
                this.groups.put(group, ingridientList);
            } else {
                HashMap<Ingridient, List<Value>> ingridientItem = new HashMap<>();
                ingridientItem.put(entry.getKey(), entry.getValue());
                this.groups.put(group, ingridientItem);
            }
        };
    }

    private JSONObject buildGroup() {
        JSONObject json = new JSONObject();
        Map<IngridientGroup, HashMap<Ingridient, List<Value>>> subGroups = this.groups.entrySet()
                .stream()
                .filter(group -> group.getKey().getParentGroup() != null)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        Map<IngridientGroup, HashMap<Ingridient, List<Value>>> parentGroups = this.groups.entrySet()
                .stream()
                .filter(group -> group.getKey().getParentGroup() == null)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        parentGroups.forEach((group, ingridients) -> {
            String groupName = group.getName();
            json.put(groupName, this.buildIngridients(ingridients));
        });
        subGroups.forEach((group, ingridients) -> {
            String groupName = group.getName();
            IngridientGroup parentGroup = group.getParentGroup();
            JSONObject subNode = new JSONObject();
            if (!json.containsKey(parentGroup.getName())) {
                subNode.put(groupName, this.buildIngridients(ingridients));
                json.put(parentGroup.getName(), subNode);
            } else {
                JSONObject parentJson = (JSONObject) json.get(parentGroup.getName());
                parentJson.put(groupName, this.buildIngridients(ingridients));
                json.put(parentGroup.getName(), parentJson);
            }
        });
        return json;
    }

    private JSONObject[] buildIngridients(HashMap<Ingridient, List<Value>> ingridients) {
        int resultLength = ingridients.size();
        JSONObject[] result = new JSONObject[resultLength];

        int iterator = 0;
        for (Map.Entry<Ingridient, List<Value>> entry : ingridients.entrySet()) {
            Ingridient key = entry.getKey();
            List<Value> values = entry.getValue();
            JSONObject ingridientJson = this.buildIngridientAttributes(key.getIngridientGroup().getName(), values);
            result[iterator] = ingridientJson;
            iterator++;
        }
        return result;
    }

    private JSONObject buildIngridientAttributes(String groupName, List<Value> values) {
        JSONObject ingridient = new JSONObject();
        values.forEach((value) -> {
            String attributeName = value.getAttribute().getName();
            if (this.checkForSpecialMapping(attributeName, groupName) && value.getValue().contains(",")) {
                JSONObject attributeValue = this.mapSpecialAttribute(value);
                ingridient.put(attributeName, attributeValue);
            } else {
                String attributeValue = value.getValue();
                ingridient.put(attributeName, attributeValue);
            }

        });

        return ingridient;
    }

    private boolean checkForSpecialMapping(String attributeName, String groupName) {
        String[] specialMappingAttributes = new String[]{"size", "weight", "price"};

        return Arrays.asList(specialMappingAttributes).contains(attributeName) && groupName.equals("base");
    }

    private JSONObject mapSpecialAttribute(Value valueItem) {
        String value = valueItem.getValue();
        String[] valueArray = value.split(", ");
        JSONObject json = new JSONObject();
        json.put("small", valueArray[0]);
        json.put("medium", valueArray[1]);
        json.put("large", valueArray[2]);

        return json;
    }
}
