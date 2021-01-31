package com.demoapp.spring.files.csv.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.demoapp.spring.files.csv.exception.FileParsingException;
import com.demoapp.spring.files.csv.model.EcommerceModel;
import au.com.bytecode.opencsv.CSVReader;

@Service
public class CSVService {

	/**
	 * Parses the file and get data.
	 *
	 * @param file the file
	 * @return the list of EcommerceModel
	 */
	public List<EcommerceModel> parseFileAndGetData(MultipartFile file) {
		List<EcommerceModel> models = new ArrayList<>();
		try (BufferedReader fileReader = new BufferedReader(
				new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8));
				CSVReader reader = new CSVReader(fileReader);) {

			String[] line;
			line = reader.readNext();
			while ((line = reader.readNext()) != null) {
				models.add(new EcommerceModel(line[0], convertStringToInteger(line[1]), convertStringToInteger(line[2]),
						line[3], line[4]));
			}
		} catch (Exception e) {
			throw new FileParsingException("fail to parse CSV file: " + e.getMessage());
		}
		return models;
	}

	/**
	 * @param value
	 * @return integer
	 */
	private int convertStringToInteger(String value) {
		try {
			return Integer.parseInt(value);
		} catch (Exception e) {
			return 0;
		}
	}

}
