package com.jsondata.readExtractjson;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadExtractJson {

    public static void main(String[] args)  {
      String path="src/main/java/com/jsondata/readExtractjson/content/file.json";

     try {
         String content = new String(Files.readAllBytes(Paths.get(path)));
         JSONArray array = new JSONArray(content);
         for (int i = 0; i < array.length(); i++) {
             JSONObject obj = array.getJSONObject(i);

             String name = obj.getString("name");
             String email = obj.getString("email");

             System.out.println("Name : " + name + "\n" + "Email : " + email);

         }
     }
     catch (Exception e){
         e.printStackTrace();
     }
    }
}
