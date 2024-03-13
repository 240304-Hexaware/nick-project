package com.example.demo.repositories;

import com.example.demo.models.Metadata;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MetadataRepository extends MongoRepository<Metadata, ObjectId> {

    //Optional<Metadata> deleteMetadataById(ObjectId id);
}
