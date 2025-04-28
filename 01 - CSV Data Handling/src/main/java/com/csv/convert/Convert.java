package com.csv.convert;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Convert {
    public static void jsonToCsv(String jsonPath, String csvPath) {
        ObjectMapper objectMapper = new ObjectMapper();

        try (CSVWriter csvw = new CSVWriter(new FileWriter(csvPath))) {
            Student[] students = objectMapper.readValue(new File(jsonPath), Student[].class);

            String[] header = new String[]{"Id", "Name", "Age"};
            csvw.writeNext(header);

            //writing student data
            for (Student student : students) {
                csvw.writeNext(new String[]{
                        String.valueOf(student.getId()),
                        student.getName(),
                        String.valueOf(student.getAge()),
                        student.getCity(),
                        student.getEmail()
                });
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void csvToJson(String csvPath, String jsonPath) {
        try(CSVReader reader = new CSVReader(new FileReader(csvPath));
            BufferedWriter br = new BufferedWriter(new FileWriter(jsonPath))){
            List<Student>students=new ArrayList<>();
            ObjectMapper objectMapper=new ObjectMapper();

            reader.readNext();
            String[] line;

            while ((line = reader.readNext()) != null) {
                Student student = new Student();

                student.setId(Integer.parseInt(line[0]));
                student.setName(line[1]);
                student.setAge(Integer.parseInt(line[2]));
                student.setCity(line[3]);
                student.setEmail(line[4]);

                students.add(student);
            }
            String jsonOutput = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(students);
            br.write(jsonOutput);

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String jsonStudent="src/main/java/com/csv/convert/content/Student.json";
        String csvStudent="src/main/java/com/csv/convert/content/Student.csv";

        String jsonToCsv="src/main/java/com/csv/convert/content/JsonToCsv.csv";
        String csvToJson="src/main/java/com/csv/convert/content/CsvToJson.json";

        Convert.jsonToCsv(jsonStudent,jsonToCsv);
        Convert.csvToJson(csvStudent,csvToJson);

    }
}
