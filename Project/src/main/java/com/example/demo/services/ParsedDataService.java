package com.example.demo.services;

import com.example.demo.exceptions.ItemNotFoundException;
import com.example.demo.models.ParsedData;
import com.example.demo.repositories.ParsedDataRepository;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

@Service
public class ParsedDataService {

    private ParsedDataRepository parsedDataRepository;

    public ParsedDataService(ParsedDataRepository parsedDataRepository) {
        this.parsedDataRepository = parsedDataRepository;
    }

    public ParsedData createNewData(ParsedData newData) {
        return parsedDataRepository.save(newData);
    }

    public ParsedData findParsedDataById(ObjectId parsedDataId) throws ItemNotFoundException {
        return parsedDataRepository.findById(parsedDataId).orElseThrow(() -> new ItemNotFoundException("Parsed Data Not Found"));
    }
}
