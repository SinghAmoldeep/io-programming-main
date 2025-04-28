package com.csv.searchrecords;

import com.opencsv.CSVReader;

import java.io.FileReader;

public class SearchRecords {
    public static void main(String[] args) {
        String str="src/main/java/com/csv/searchrecords/content/employee.csv";
        try (CSVReader csvReader = new CSVReader(new FileReader(str))) {
            String[] data;
            csvReader.readNext();
            String name="Anmol";
            while ((data = csvReader.readNext()) != null) { // `readNext()` directly gives an array

                if(data[1].equals(name)) {
                    System.out.println("Id " + data[0] + " Name " + data[1] +" Department : " + data[2] + " Designation : " + data[3] + " Salary : " + data[4]);

                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();  // Print the exception for debugging
        }
    }
}
