package com.ipl.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ipl.functionalities.Censor;
import com.ipl.functionalities.Match;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.*;

public class IPHandler {
    public static void json(String path){
        String jsonPath="src/main/java/com/ipl/content/censoredIpl.json";
        try(BufferedWriter writer=new BufferedWriter(new FileWriter(jsonPath))){
            ObjectMapper mapper = new ObjectMapper();
            Match[]matches=mapper.readValue(new File(path), Match[].class);
            for(Match match :matches){
                match.setTeam1(Censor.apply(match.getTeam1()));
                match.setTeam2(Censor.apply(match.getTeam2()));
                match.setPlayer_of_match(Censor.apply(match.getPlayer_of_match()));
                match.setPlayer_of_match(Censor.redacted(match.getPlayer_of_match()));
            }

            String json=mapper.writerWithDefaultPrettyPrinter().writeValueAsString(matches);
            writer.write(json);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void csv(String path){
        String csvPath="src/main/java/com/ipl/content/censoredipl.csv";
        try (
                CSVReader reader=new CSVReader(new FileReader(path));
                CSVWriter writer=new CSVWriter(new FileWriter(csvPath))
        ){
            String[] header= reader.readNext();
            writer.writeNext(header);

            String[]row;
            while((row=reader.readNext())!=null){
                row[1]=Censor.apply(row[1]);
                row[2]=Censor.apply(row[2]);
                row[5]=Censor.apply(row[3]);
                row[6]=Censor.redacted(row[6]);

                writer.writeNext(row);
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
