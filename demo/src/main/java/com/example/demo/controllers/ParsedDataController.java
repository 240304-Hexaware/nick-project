package com.example.demo.controllers;

import com.example.demo.services.ParsedDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParsedDataController {

    private ParsedDataService parsedDataService;

    @Autowired
    public ParsedDataController(ParsedDataService parsedDataService) {
        this.parsedDataService = parsedDataService;
    }
}
