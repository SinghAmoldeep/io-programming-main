package com.jsondata.listTojson;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.List;

public class ListToJson {

    public static void main(String[] args) {
        List<Person> personList= Arrays.asList(
                new Person("Rishav",22),
                new Person("Anmol" ,21),
                new Person("Ankit",22));

        try {
            ObjectMapper mapper=new ObjectMapper();
            String json=mapper.writerWithDefaultPrettyPrinter().writeValueAsString(personList);
            System.out.println(json);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
