package com.jsondata.mergejsonobj;

import org.json.JSONObject;

public class MergeJsonObj {
    public static void main(String[] args) {
        String json1 = "{\"name\":\"Rishav\",\"age\":22}";
        String json2 = "{\"email\":\"rishav@gmail.com\",\"city\":Rajpura}";

        JSONObject obj1 = new JSONObject(json1);
        JSONObject obj2 = new JSONObject(json2);

        for (String key : obj2.keySet()) {
            obj1.put(key, obj2.get(key));
        }
        System.out.println(obj1.toString(3));
    }
}
