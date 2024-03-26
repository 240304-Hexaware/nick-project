package com.example.demo.controllers;

import com.example.demo.exceptions.ItemNotFoundException;
import com.example.demo.models.Specification;
import com.example.demo.services.SpecificationService;
import com.example.demo.services.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins="*")
public class SpecificationController {

    private SpecificationService specificationService;
    private UserService userService;

    @Autowired
    public SpecificationController(SpecificationService specificationService, UserService userService) {
        this.specificationService = specificationService;
        this.userService = userService;
    }

    @GetMapping("/spec")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Specification> getAllSpecifications(){
        return specificationService.getAllSpecs();
    }

    @GetMapping("/spec/name")
    @ResponseStatus(HttpStatus.FOUND)
    public List<Specification> getSpecificationBySpecName(@RequestParam("specName") String specName){
        return specificationService.getSpecByName(specName);
    }

    @GetMapping("/spec/id")
    @ResponseStatus(HttpStatus.FOUND)
    public List<Specification> getAllSpecsByIds(@RequestParam("ids") List<String> specIds){
        List<ObjectId> objectIds = new ArrayList<ObjectId>();
        for(String id : specIds){
            ObjectId curr = new ObjectId(id);
            objectIds.add(curr);
        }
        return specificationService.findAllSpecsById(objectIds);
    }

    @PostMapping("/spec")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Specification uploadSpec(@RequestParam("spec")MultipartFile newSpec, @RequestParam("username") String uploader) throws IOException, ItemNotFoundException {
        InputStreamReader reader = new InputStreamReader(newSpec.getInputStream());
        StringBuilder builder = new StringBuilder();
        while(reader.ready()) {
            builder.append((char)reader.read());
        }

        File specFile = new File("C://Users//BerkenNicholas//Documents//Revature training//FullProject//nick-full-project//nick-project//Project//Specs//"+newSpec.getOriginalFilename());
        FileWriter writer  = new FileWriter(specFile);
        writer.append(builder.toString());
        writer.close();

        Specification newUpload = specificationService.postNewSpec(new Specification(builder.toString(), specFile.getPath(), specFile.getName()));

        ObjectId id =  this.getSpecificationBySpecName(specFile.getName()).getFirst().getId();

        this.userService.updateSpecificationsByUsername(uploader, id);

        return newUpload;
    }

    @DeleteMapping("/spec")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteSpecification(@RequestBody ObjectId specId) {
        specificationService.deleteSpecification(specId);
    }

}
