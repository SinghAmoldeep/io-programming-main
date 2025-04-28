package com.ipl;

import com.ipl.handler.IPHandler;

public class Main {
    public static void main(String[] args) {
        String csvPath = "src/main/java/com/ipl/content/ipl.csv";
        String jsonPath = "src/main/java/com/ipl/content/ipl.json";

        IPHandler.json(jsonPath);
        IPHandler.csv(csvPath);
    }
}
