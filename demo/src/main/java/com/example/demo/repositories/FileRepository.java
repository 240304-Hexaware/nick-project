package com.example.demo.repositories;

import com.example.demo.models.File;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FileRepository extends MongoRepository<File, ObjectId> {

//    Optional<File> createFile(File file);
//
//    Optional<File> deleteFileById(ObjectId id);
}
