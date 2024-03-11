package com.example.demo.repositories;

import org.springframework.stereotype.Repository;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.models.User;

@Repository
public interface UserRepository extends MongoRepository<User, ObjectId> {
}