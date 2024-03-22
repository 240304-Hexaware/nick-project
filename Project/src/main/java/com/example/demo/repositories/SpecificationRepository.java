package com.example.demo.repositories;

import org.springframework.stereotype.Repository;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.models.Specification;

import java.util.List;
import java.util.Optional;

@Repository
public interface SpecificationRepository extends MongoRepository<Specification, ObjectId> {
    void deleteById(String specId);

    List<Specification> findSpecificationsBySpecName(String specName);

//    String getFileLocation(Specification specification);
//
//    Optional<Specification> createNewSpecification(Specification spec);
}
