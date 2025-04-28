package com.csv.largeCsv;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import javax.imageio.IIOException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadLargeCsv {
    public static void main(String[] args) {
        String filePath="src/main/java/com/csv/largeCsv/content/Demo.csv";

        int chunkSize=20;

        try(CSVReader csvr=new CSVReader(new FileReader(filePath))){
            List<String[]> chunk;
            while(!(chunk = readChunk(csvr, chunkSize)).isEmpty()){
                for(String[] row:chunk){
                    System.out.println(Arrays.toString(row));
                }
                System.out.println("chunk processed");

            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static List<String[]>readChunk(CSVReader csvr ,int chunkSize) throws IOException, CsvValidationException {
        List<String[]> chunk = new ArrayList<>();
        String[] line;
        int count = 0;
        while ((line = csvr.readNext()) != null && count < chunkSize) {
            chunk.add(line);
            count++;
        }
        return chunk;
    }

}
