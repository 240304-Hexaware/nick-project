package com.example.demo.repositories;

import com.example.demo.models.ParsedData;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ParsedDataRepository extends MongoRepository<ParsedData, ObjectId> {


}
