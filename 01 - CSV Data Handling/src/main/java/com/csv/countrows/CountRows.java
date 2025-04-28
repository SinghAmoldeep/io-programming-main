package com.csv.countrows;

import com.opencsv.CSVReader;

import java.io.FileReader;

public class CountRows {
    public static void main(String[] args) {
        String str="src/main/java/com/csv/countrows/content/demo.csv";
        try (CSVReader csvReader = new CSVReader(new FileReader(str))) {
            String[] data;
            csvReader.readNext();
            int count=0;
            while ((data = csvReader.readNext()) != null) { // `readNext()` directly gives an array
                System.out.println("Id " + data[0] + " Name " + data[1]);
                count++;
            }
            System.out.println("Row Count : " + count);

        } catch (Exception e) {
            e.printStackTrace();  // Print the exception for debugging
        }
    }
}
