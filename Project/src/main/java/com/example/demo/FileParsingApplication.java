package com.example.demo;

import com.example.demo.parser.Field;
import com.example.demo.parser.Parser;
import org.bson.BsonDocument;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@SpringBootApplication(scanBasePackages = {
		"com.example.demo.controllers",
		"com.example.demo.services",
		"com.example.demo.repositories"},
		exclude = {DataSourceAutoConfiguration.class}
)
public class FileParsingApplication {

	public static void main(String[] args) throws IOException, URISyntaxException {
		//ApplicationContext ctx = SpringApplication.run(FileParsingApplication.class, args);

		File specFile = new File("C://Users//BerkenNicholas//Documents//Revature training//SpringTemplate//nick-project//Project//car.json");
		Parser parser = new Parser();
		Map<String, Field> map = parser.parseSpec(specFile);

		File flatFile = new File("C://Users//BerkenNicholas//Documents//Revature training//SpringTemplate//nick-project//Project//flatfile");


		String data = parser.readAllBytes(flatFile);

		List<String> list  = parser.readStringFields(data, map);

		BsonDocument bison = parser.readStringFieldsBson(data, map);

		System.out.println(bison);
		System.out.println(data);
		System.out.println(list);
	}

}
