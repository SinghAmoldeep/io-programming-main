package com.csv.writecsv;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.util.Arrays;
import java.util.List;

public class WriteCSV {
    public static void main(String[] args) {
        String filePath="src/main/java/com/csv/writecsv/content/demo.csv";
        List<String[]> data = Arrays.asList(
                new String[]{"ID", "Name", "Age"},  // Header row
                new String[]{"1", "Rishav", "22"},
                new String[]{"2", "Anmol", "21"},
                new String[]{"3", "Ankit", "22"}
        );

        try (CSVWriter csvWriter = new CSVWriter(new FileWriter(filePath))) {
            csvWriter.writeAll(data); // Writing data to CSV
            System.out.println("CSV file written successfully!");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
