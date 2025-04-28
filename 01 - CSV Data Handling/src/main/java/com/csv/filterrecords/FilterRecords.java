package com.csv.filterrecords;

import com.opencsv.CSVReader;

import java.io.FileReader;

public class FilterRecords {

    public static void main(String[] args) {
        String str = "src/main/java/com/csv/filterrecords/content/demo.csv"; // file path
        try (CSVReader csvReader = new CSVReader(new FileReader(str))) {
            String[] data;
            csvReader.readNext();
            while ((data = csvReader.readNext()) != null) { // `readNext()` directly gives an array
                if(Integer.parseInt(data[3])>=80) {
                    System.out.println("Id : " + data[0] + " Name : " + data[1]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();  // Print the exception for debugging
        }
    }
}
