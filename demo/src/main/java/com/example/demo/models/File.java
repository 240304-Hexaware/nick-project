package com.example.demo.models;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;
import org.bson.types.ObjectId;

import java.util.Date;

@Document("files")
public class File {

    @Field(name = "_id")
    @MongoId(FieldType.STRING)
    private String id;

//    @Field(name = "metadata")
//    private Metadata metadata;

    @Field(name = "file_name")
    private String fileName;

    @Field(name = "spec_id")
    private String specId;

    @Field(name = "upload_date")
    private Date uploadDate;

    @Field(name = "file_size")
    private int fileSize;

    @Field(name = "file_path")
    private String filePath;

    @Field(name = "parsed_data")
    private ParsedData parsedData;

    @Field(name = "uploader")
    private String uploader;

    public File(){

    }

    public File(String fileName, String specId, Date uploadDate, int fileSize, String filePath, ParsedData parsedData, String uploader) {
        this.fileName = fileName;
        this.specId = specId;
        this.uploadDate = uploadDate;
        this.fileSize = fileSize;
        this.filePath = filePath;
        this.parsedData = parsedData;
        this.uploader = uploader;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getSpecId() {
        return specId;
    }

    public void setSpecId(String specId) {
        this.specId = specId;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public int getFileSize() {
        return fileSize;
    }

    public void setFileSize(int fileSize) {
        this.fileSize = fileSize;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public ParsedData getParsedData() {
        return parsedData;
    }

    public void setParsedData(ParsedData parsedData) {
        this.parsedData = parsedData;
    }

    public String getUploader() {
        return uploader;
    }

    public void setUploader(String uploader) {
        this.uploader = uploader;
    }
}
