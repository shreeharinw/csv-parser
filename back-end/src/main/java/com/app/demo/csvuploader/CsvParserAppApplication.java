package com.app.demo.csvuploader;

import com.app.demo.csvuploader.property.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
		FileStorageProperties.class
})
public class CsvParserAppApplication
{

	public static void main(String[] args)
	{
		SpringApplication.run(CsvParserAppApplication.class, args);
	}

}

