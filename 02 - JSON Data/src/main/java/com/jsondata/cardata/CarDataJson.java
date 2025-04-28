package com.jsondata.cardata;

import org.json.JSONObject;

public class CarDataJson {

    public static void main(String[] args) {
        Car car = new Car(1, "Toyota", "Blue");

        JSONObject obj = new JSONObject(car);

        System.out.println(obj.toString());
    }
}
