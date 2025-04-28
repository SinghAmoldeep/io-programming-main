package com.jsondata.csvTojson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class CsvToJson {
    public static void main(String[] args) {
        String path="src/main/java/com/jsondata/csvTojson/content/demo.csv";
        try(CSVReader reader=new CSVReader(new FileReader(path))){
            List<HashMap<String,String >>csvList=new ArrayList<>();
            String[]header=reader.readNext();
            String[]row;
            while((row=reader.readNext())!=null){
                HashMap<String,String>mp=new HashMap<>();
               for(int i=0;i<row.length;i++){
                   mp.put(header[i],row[i]);
               }
               csvList.add(mp);
            }
            ObjectMapper mapper=new ObjectMapper();
            String json= mapper.writerWithDefaultPrettyPrinter().writeValueAsString(csvList);  // Convert the list in json

            System.out.println("CSV to JSON : ");

            System.out.println(json);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
