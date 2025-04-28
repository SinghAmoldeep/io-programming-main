package com.jsondata.filterageJson;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class FilterAgeJson {
    public static void main(String[] args) {
        String jsonArray = "[{\"name\": \"Rishav\", \"age\": 22}, {\"name\": \"Ankit\", \"age\": 22}, {\"name\": \"Anmol\", \"age\": 21}]";

        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode node = mapper.readTree(jsonArray);

            List<JsonNode> list = new ArrayList<>();

            for (JsonNode jsonNode : node) {
                if (jsonNode.get("age").asInt() > 21 ) {
                    list.add(jsonNode);
                }
            }

            String filteredJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(list);
            System.out.println(filteredJson);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
