package com.csv.sortCsv;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class SortCSV {
    public static void sortFile(String csvPath){
        ArrayList<String[]>csvList=new ArrayList<>();
        try(CSVReader csvr=new CSVReader(new FileReader(csvPath))){
            csvr.readNext();
            String [] line;
            while((line=csvr.readNext())!=null){
                csvList.add(line);
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

        csvList.sort(new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return (Integer.compare(Integer.parseInt(o1[4]) , Integer.parseInt(o2[4])));
            }
        });

        for(String [] str : csvList){
            System.out.println(Arrays.toString(str));
        }
    }

    public static void main(String[] args) {
        String path ="src/main/java/com/csv/modifyCsv/content/demo.csv";
        SortCSV.sortFile(path);
    }
}
