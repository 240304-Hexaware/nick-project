package com.example.demo.models;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;


@Document("specifications")
public class Specification {

    @Field(name ="original_json")
    private String originalJson;

    @Field(name = "file_path")
    private String filePath;

    @Field(name = "_id")
    @MongoId(FieldType.OBJECT_ID)
    private String id;

    public Specification(){

    }

    public Specification(String originalJson, String filePath, String id) {
        this.originalJson = originalJson;
        this.filePath = filePath;
        this.id = id;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOriginalJson() {
        return originalJson;
    }

    public void setOriginalJson(String originalJson) {
        this.originalJson = originalJson;
    }
}
