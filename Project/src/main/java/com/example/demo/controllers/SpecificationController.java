package com.example.demo.controllers;

import com.example.demo.models.Specification;
import com.example.demo.services.SpecificationService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class SpecificationController {

    private SpecificationService specificationService;

    @Autowired
    public SpecificationController(SpecificationService specificationService) {
        this.specificationService = specificationService;
    }

    @GetMapping("/spec")
    @ResponseStatus(HttpStatus.OK)
    public List<Specification> getAllSpecifications(){
        return specificationService.getAllSpecs();
    }

    @GetMapping("/spec/name")
    @ResponseStatus(HttpStatus.FOUND)
    public Specification getSpecificationBySpecName(@RequestParam("specName") String specName){
        return null; //TODO Finish this
    }

    @DeleteMapping("/spec")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteSpecification(@RequestBody ObjectId specId) {
        specificationService.deleteSpecification(specId);
    }

}
