package com.example.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(scanBasePackages = {
		"com.example.demo.controllers",
		"com.example.demo.services",
		"com.example.demo.repositories"},
		exclude = {DataSourceAutoConfiguration.class}
)
public class FileParsingApplication {

	public static void main(String[] args) {
		SpringApplication.run(FileParsingApplication.class, args);

	}

}
