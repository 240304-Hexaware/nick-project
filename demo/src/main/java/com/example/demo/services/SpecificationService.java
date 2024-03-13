package com.example.demo.services;

import com.example.demo.models.Specification;
import com.example.demo.repositories.SpecificationRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecificationService {

    private SpecificationRepository specificationRepository;

    @Autowired
    public SpecificationService(SpecificationRepository specificationRepository) {
        this.specificationRepository = specificationRepository;
    }

    public List<Specification> getAllSpecs() {
        return specificationRepository.findAll();
    }

    public void deleteSpecification(ObjectId specId) {
        specificationRepository.deleteById(specId);
    }
}
