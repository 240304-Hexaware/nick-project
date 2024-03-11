package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;

@SpringBootApplication(scanBasePackages = {
		"com.example.demo.controllers",
		"com.example.demo.services",
		"com.example.demo.repositories"},
		exclude = {DataSourceAutoConfiguration.class}
)
public class FileParsingApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(FileParsingApplication.class, args);
	}

}
