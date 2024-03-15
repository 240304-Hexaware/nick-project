package com.example.demo.repositories;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.stereotype.Repository;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.models.User;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    Optional<User> findByUsernameAndPassword(String username, String password);

    @Query("{'username': {'$eq': ?0}}")
    @Update("{'$set': {'permissions' : ?1}}")
    void updatePermissionsByUsername(String username, String permissions);


}