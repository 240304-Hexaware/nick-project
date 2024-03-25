package com.example.demo.controllers;

import com.example.demo.exceptions.ItemNotFoundException;
import com.example.demo.models.ParsedData;
import com.example.demo.services.ParsedDataService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins="*")
public class ParsedDataController {

    private ParsedDataService parsedDataService;

    @Autowired
    public ParsedDataController(ParsedDataService parsedDataService) {
        this.parsedDataService = parsedDataService;
    }

    @PostMapping("/parseddata")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ParsedData postNewParsedData(@RequestBody ParsedData newData){
        return parsedDataService.createNewData(newData);
    }

    @GetMapping("/parseddata")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ParsedData getParsedDataById(@RequestBody ObjectId parsedDataId) throws ItemNotFoundException {
        return parsedDataService.findParsedDataById(parsedDataId);
    }

    @ExceptionHandler(ItemNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String queryItemNotFound(ItemNotFoundException e){
        System.out.println(e.getMessage());
        return e.getMessage();
    }
}
