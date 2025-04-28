package com.jsondata.jsontoxml;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.sql.SQLOutput;

public class JsonToXml {
    public static void main(String[] args) {
        try{
            String json="{ \"name\": \"Rishav\", \"age\": 22 }";
            ObjectMapper mapper=new ObjectMapper();
            Object obj=mapper.readValue(json,Object.class);

            XmlMapper xmlMapper=new XmlMapper();
            String xml=xmlMapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);

            System.out.println("JSON TO XML FORMAT : ");

            System.out.println(xml);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
