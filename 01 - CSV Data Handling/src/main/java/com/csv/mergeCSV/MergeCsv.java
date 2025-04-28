package com.csv.mergeCSV;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class MergeCsv {
    public static void merge(String path1, String path2){
        List<String[]>st=new ArrayList<>();
        st.add(new String[]{"ID","Name","Age" , "Marks" , "Grade"});
        try(
                CSVReader csvr1=new CSVReader(new FileReader(path1));
                CSVReader csvr2=new CSVReader(new FileReader(path2));
        ){
             csvr1.readNext();
             String[] line1;
             while((line1=csvr1.readNext())!=null){
                 st.add(new String[]{line1[0],line1[1],line1[2]," "," "});
             }
             csvr2.readNext();
             String[] line2;
             while((line2=csvr2.readNext())!=null){
                 for(int i=0;i<st.size();i++){
                     if(st.get(i)[0].equals(line2[0])){
                         st.get(i)[3]=line2[1];
                         st.get(i)[4]=line2[2];
                     }
                 }
             }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        String mergePath="src/main/java/com/csv/mergeCSV/content/Merge.csv";
        try(CSVWriter csvw=new CSVWriter(new FileWriter(mergePath))){
            csvw.writeAll(st);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String path1="src/main/java/com/csv/mergeCSV/content/Student1.csv";
        String path2="src/main/java/com/csv/mergeCSV/content/Student2.csv";
        MergeCsv.merge(path1,path2);
    }
}
