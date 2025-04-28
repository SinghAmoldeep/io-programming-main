package com.csv.encrypt;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.FileWriter;

public class CSVHandler {
    public static void write(String fileName){
        try (CSVWriter csvWriter = new CSVWriter(new FileWriter(fileName))){
            csvWriter.writeNext(new String[]{"4", "Test", Encryption.encrypt("TESMAIL@gmail.com")});
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void read(String fileName){
        try (CSVReader csvReader = new CSVReader(new FileReader(fileName))){
            String[] line;
            while ((line = csvReader.readNext()) != null){
                System.out.println(line[0] + "\t" + line[1] + "\t" + Encryption.decrypt(line[2]));
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        CSVHandler.write("src/main/java/com/csv/encrypt/content/file.csv");
        CSVHandler.read("src/main/java/com/csv/encrypt/content/file.csv");
    }
}