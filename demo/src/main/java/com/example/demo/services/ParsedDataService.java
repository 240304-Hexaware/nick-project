package com.example.demo.services;

import com.example.demo.repositories.ParsedDataRepository;
import org.springframework.stereotype.Service;

@Service
public class ParsedDataService {

    private ParsedDataRepository parsedDataRepository;

    public ParsedDataService(ParsedDataRepository parsedDataRepository) {
        this.parsedDataRepository = parsedDataRepository;
    }
}
