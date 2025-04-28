package com.jsondata.validateschema;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;

import java.io.File;

public class ValidateSchema {
    public static void main(String[] args) {
        String jsonFilePath = "src/main/java/com/jsondata/validateschema/Schema.json";
        String json = "{ \"id\": 1, \"name\": \"Rishav\", \"email\": \"rishav@gmail.com\" }";

        try{
            ObjectMapper mapper=new ObjectMapper();
            JsonNode node = mapper.readTree(new File(jsonFilePath));
            JsonSchemaFactory jsonSchemaFactory=JsonSchemaFactory.byDefault();
            JsonSchema jsonSchema=jsonSchemaFactory.getJsonSchema(node);

            JsonNode jsonData=mapper.readTree(json);

            if(jsonSchema.validate(jsonData).isSuccess()){
                System.out.println("Validation Success");
            }
            else{
                System.out.println("Validation Failed");
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
