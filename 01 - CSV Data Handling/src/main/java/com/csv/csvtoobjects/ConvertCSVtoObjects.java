package com.csv.csvtoobjects;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

class Students{
    int id;
    String name;
    String department;
    int age;

    public Students(int id, String name, String department, int age) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Students{" +
                "Id=" + id +
                ", Name='" + name + '\'' +
                ", Department='" + department + '\'' +
                ", Age=" + age +
                '}';
    }
}
public class ConvertCSVtoObjects {
    static List<Students> stList=new ArrayList<>();
    public static void convert(String path){
        try(CSVReader csvr=new CSVReader(new FileReader(path))){
            csvr.readNext();
            String [] line;
            while((line=csvr.readNext())!=null){
                int id = Integer.parseInt(line[0]);
                String name=line[1];
                String department=line[2];
                int age=Integer.parseInt(line[3]);
                stList.add(new Students(id,name,department,age));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        for(Students st:stList){
            System.out.println(st);
        }

    }

    public static void main(String[] args) {
        String path="src/main/java/com/csv/csvtoobjects/content/demo.csv";

        ConvertCSVtoObjects.convert(path);
    }
}
