package com.example.demo.controllers;

import com.example.demo.models.Specification;
import com.example.demo.services.SpecificationService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
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
    public List<Specification> getSpecificationBySpecName(@RequestParam("specName") String specName){
        return specificationService.getSpecByName(specName);
    }

    @PostMapping("/spec")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Specification uploadSpec(@RequestParam("spec")MultipartFile newSpec) throws IOException {
        InputStreamReader reader = new InputStreamReader(newSpec.getInputStream());
        StringBuilder builder = new StringBuilder();
        while(reader.ready()) {
            builder.append((char)reader.read());
        }

        File specFile = new File("C://Users//BerkenNicholas//Documents//Revature training//FullProject//nick-full-project//nick-project//Project//Specs//"+newSpec.getOriginalFilename());
        FileWriter writer  = new FileWriter(specFile);
        writer.append(builder.toString());
        writer.close();

        return specificationService.postNewSpec(new Specification(builder.toString(), specFile.getPath()));
    }

    @DeleteMapping("/spec")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteSpecification(@RequestBody ObjectId specId) {
        specificationService.deleteSpecification(specId);
    }

}
