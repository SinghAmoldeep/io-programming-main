package com.csv.readcsv;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;

public class ReadCSV {
    public static void main(String[] args) {
    String str="src/main/java/com/csv/readcsv/content/Student.csv";
        try (CSVReader csvReader = new CSVReader(new FileReader(str))) {
            String[] data;
            csvReader.readNext();
            while ((data = csvReader.readNext()) != null) { // `readNext()` directly gives an array
                System.out.println("Id " + data[0] + " Name " + data[1]);
            }
        } catch (Exception e) {
            e.printStackTrace();  // Print the exception for debugging
        }
    }
}
