package com.example.demo.models;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("specifications")
public class Specification {

    @Field(name ="original_json")
    private String originalJson;

    @Field(name = "file_path")
    private String filePath;

    @Field(name="spec_name")
    private String specName;

    @Field(name = "_id")
    private ObjectId id;

    public Specification(){

    }

    public Specification(String originalJson, String filePath, String specName) {
        this.originalJson = originalJson;
        this.filePath = filePath;
        this.specName = specName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getOriginalJson() {
        return originalJson;
    }

    public void setOriginalJson(String originalJson) {
        this.originalJson = originalJson;
    }

    public void setSpecName(String specName) { this.specName = specName; }

    public String getSpecName() { return this.specName; }
}
