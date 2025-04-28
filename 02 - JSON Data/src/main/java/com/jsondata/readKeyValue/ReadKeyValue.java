package com.jsondata.readKeyValue;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Iterator;
import java.util.Map;

public class ReadKeyValue {
    public static void main(String[] args) {
        String json = "[{\"name\": \"Rishav\", \"age\": 22}, {\"name\": \"Ankit\", \"age\": 22}, {\"name\": \"Anmol\", \"age\": 21}]";

        ObjectMapper mapper = new ObjectMapper();

        try {
            JsonNode rootNode = mapper.readTree(json);

            if (rootNode.isArray()) {
                for (JsonNode objNode : rootNode) {
                    Iterator<Map.Entry<String, JsonNode>> fields = objNode.fields();
                    while (fields.hasNext()) {
                        Map.Entry<String, JsonNode> entry = fields.next();
                        System.out.println("Key: " + entry.getKey());
                        System.out.println("Value: " + entry.getValue());
                    }
                    System.out.println("-----");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
