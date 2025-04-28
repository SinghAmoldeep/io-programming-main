package com.csv.modifyCsv;

import com.opencsv.CSVReader;

import java.io.FileReader;

public class ModifyCSV {
    public static void main(String[] args) {
        String str = "src/main/java/com/csv/modifyCsv/content/demo.csv";
        try (CSVReader csvReader = new CSVReader(new FileReader(str))) {
            String[] data;
            csvReader.readNext();

            while ((data = csvReader.readNext()) != null) {

                if (data[2].equals("IT")) {
                    double salary = (Integer.parseInt(data[4])*1.10); // Get the salary
                    data[4]=String.valueOf(salary);
                    System.out.println("Id " + data[0] + " Name " + data[1] + " Department : " + data[2] + " Designation : " + data[3] + " Salary : " + data[4]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();  // Print the exception for debugging
        }
    }
}
