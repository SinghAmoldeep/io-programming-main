package com.csv.detectduplicates;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DetectDuplicates {
    public static void detect(String filePath){
        Set<String> set=new HashSet<>();
        try(CSVReader csvr=new CSVReader(new FileReader(filePath))){
            String[] line;
            while((line=csvr.readNext())!=null){
                if(set.contains(line[0])){
                    System.out.println("Duplicate found");
                    System.out.println(Arrays.toString(line));
                }
                else{
                    set.add(line[0]);
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String path="src/main/java/com/csv/detectduplicates/content/Demo.csv";

        DetectDuplicates.detect(path);
    }
}
