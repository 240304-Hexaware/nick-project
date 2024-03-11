package com.example.demo.models;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;
import org.bson.types.ObjectId;

@Document("metadatas")
public class Metadata {

    @Field(name = "_id")
    @MongoId(FieldType.OBJECT_ID)
    private ObjectId id;
    @Field(name = "file_size")
    private float fileSize;

    @Field(name = "file_location")
    private String fileLocation;

    @Field(name = "specification_id")
    private String specificationId;

    @Field(name = "file_id")
    private String fileId;

    @Field(name = "uploader_id")
    private String uploaderId;

    public Metadata(){

    }

    public Metadata(ObjectId id, float fileSize, String fileLocation, String specificationId, String fileId, String uploaderId) {
        this.id = id;
        this.fileSize = fileSize;
        this.fileLocation = fileLocation;
        this.specificationId = specificationId;
        this.fileId = fileId;
        this.uploaderId = uploaderId;
    }

    public float getFileSize() {
        return fileSize;
    }

    public void setFileSize(float fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileLocation() {
        return fileLocation;
    }

    public void setFileLocation(String fileLocation) {
        this.fileLocation = fileLocation;
    }

    public String getSpecificationId() {
        return specificationId;
    }

    public void setSpecificationId(String specificationId) {
        this.specificationId = specificationId;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getUploaderId() {
        return uploaderId;
    }

    public void setUploaderId(String uploaderId) {
        this.uploaderId = uploaderId;
    }
}
