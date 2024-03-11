package com.example.demo.models;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;
import org.bson.types.ObjectId;

@Document("files")
public class File {

    @Field(name = "_id")
    @MongoId(FieldType.OBJECT_ID)
    private ObjectId id;

    @Field(name = "metadata")
    private Metadata metadata;

    @Field(name = "parsed_data")
    private ParsedData parsedData;

    @Field(name = "uploader_id")
    private String uploaderId;

    public File(){

    }

    public File(ObjectId id, Metadata metadata, ParsedData parsedData, String uploaderId) {
        this.id = id;
        this.metadata = metadata;
        this.parsedData = parsedData;
        this.uploaderId = uploaderId;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public ParsedData getParsedData() {
        return parsedData;
    }

    public void setParsedData(ParsedData parsedData) {
        this.parsedData = parsedData;
    }

    public String getUploaderId() {
        return uploaderId;
    }

    public void setUploaderId(String uploaderId) {
        this.uploaderId = uploaderId;
    }
}
