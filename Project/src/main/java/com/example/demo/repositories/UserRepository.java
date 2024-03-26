package com.example.demo.repositories;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.stereotype.Repository;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.models.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    Optional<User> findByUsernameAndPassword(String username, String password);

    Optional<User> findByUsername(String username);

    @Query("{'username': {'$eq': ?0}}")
    @Update("{'$set': {'permissions' : ?1}}")
    void updatePermissionsByUsername(String username, String permissions);

    @Query("{'username': {'$eq': ?0}}")
    @Update("{'$set': {'files_uploaded' : ?1}}")
    void updateFilesUploadedByUsername(String username, List<ObjectId> filesUploaded);

    @Query("{'username': {'$eq': ?0}}")
    @Update("{'$set': {'specifications' : ?1}}")
    void updateSpecificationsByUsername(String username, List<ObjectId> specifications);
}
