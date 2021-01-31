package com.app.demo.csvuploader.utils;

import au.com.bytecode.opencsv.CSVReader;
import com.app.demo.csvuploader.ModelPojo.EcommerceModel;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class CsvReaderService {

    public List<EcommerceModel> parseCSVFile(String csvFilePath){
        List<EcommerceModel> models = new ArrayList<>();

        CSVReader reader = null;
        try {
            reader = new CSVReader(new FileReader(csvFilePath));
            String[] line;
            line = reader.readNext();
            System.out.println(line);
            while ((line = reader.readNext()) != null) {
                //System.out.println("Country [id= " + line[0] + ", code= " + line[1] + " , name=" + line[2] + "]");
                models.add(new EcommerceModel(line[0], getSaneInt(line[1]), getSaneInt(line[2]), line[3], line[4]));
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return models;
    }

    private int getSaneInt(String value){
        try{
            return Integer.parseInt(value);
        }catch (Exception e){
            return 0;
        }
    }
}
