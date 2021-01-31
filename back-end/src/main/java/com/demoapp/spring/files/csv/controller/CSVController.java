package com.demoapp.spring.files.csv.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.demoapp.spring.files.csv.model.EcommerceModel;
import com.demoapp.spring.files.csv.service.CSVService;

@CrossOrigin
@Controller
@RequestMapping("/api/csv")
public class CSVController {

  @Autowired
  CSVService csvService;

  @PostMapping("/upload")
  public ResponseEntity<List<EcommerceModel>> uploadFile(@RequestParam("file") MultipartFile file) {
   
    List<EcommerceModel> models = new ArrayList<>();
    
      try {
    	models = csvService.parseFileAndGetData(file);        
        return ResponseEntity.status(HttpStatus.OK).body(models);
      } catch (Exception e) {       
        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(models);
      }    
  }

}
