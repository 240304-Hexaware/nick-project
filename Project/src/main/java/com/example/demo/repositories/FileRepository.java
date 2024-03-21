package com.example.demo.repositories;

import com.example.demo.models.ReadFile;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileRepository extends MongoRepository<ReadFile, ObjectId> {

    List<ReadFile> findAllFileByFileName(String fileName);

    void deleteByFileName(String fileName);

}
