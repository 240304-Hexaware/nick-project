package com.example.demo.models;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.List;

@Document("files")
public class ReadFile {

    @Field(name = "_id")
    private ObjectId id;

    @Field(name = "file_name")
    private String fileName;

    @Field(name = "spec_id")
    private String specName;

    @Field(name = "upload_date")
    private Date uploadDate;

    @Field(name = "file_size")
    private long fileSize;

    @Field(name = "file_path")
    private String filePath;

    @Field(name = "parsed_data")
    private List<String> parsedData;

    @Field(name = "uploader")
    private String uploader;

    public ReadFile(){

    }

    public ReadFile(String fileName, String specId, Date uploadDate, long fileSize, String filePath, List<String> parsedData, String uploader) {
        this.fileName = fileName;
        this.specName = specId;
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
        return specName;
    }

    public ObjectId getId(){return id;}

    public void setId(ObjectId id){this.id = id;}

    public void setSpecId(String specId) {
        this.specName = specId;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public List<String> getParsedData() {
        return parsedData;
    }

    public void setParsedData(List<String> parsedData) {
        this.parsedData = parsedData;
    }

    public String getUploader() {
        return uploader;
    }

    public void setUploader(String uploader) {
        this.uploader = uploader;
    }
}
