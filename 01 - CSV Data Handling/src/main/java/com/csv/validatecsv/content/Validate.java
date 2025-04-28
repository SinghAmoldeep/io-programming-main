package com.csv.validatecsv.content;

import com.csv.validatecsv.Regex;
import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.Arrays;

public class Validate {

    public static void validateCsv(String csvPath){
        try(CSVReader csvr=new CSVReader(new FileReader(csvPath))){
            csvr.readNext();
            String [] line;
            while((line = csvr.readNext())!=null){
                if(Regex.validateEmail(line[2]) && Regex.validateContact(line[3])){
                    System.out.println(Arrays.toString(line));
                }
                else {
                System.out.println("Invalid entry: " + Arrays.toString(line));
            }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String path="src/main/java/com/csv/validatecsv/content/demo.csv";
        Validate.validateCsv(path);
    }
}
