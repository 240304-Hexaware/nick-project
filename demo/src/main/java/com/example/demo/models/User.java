package com.example.demo.models;


import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.ArrayList;

@Document("users")
public class User {

    @Field(name = "_id")
    @MongoId(FieldType.OBJECT_ID)
    private String id;

    @Field(name = "username")
    private String username;

    @Field(name = "password")
    private String password;

    @Field(name = "permissions")
    private String permissions;

    @Field("files_uploaded")
    private ArrayList<String> filesUploaded;

    @Field("specifications")
    private ArrayList<String> specifications;

    public User(){

    }

    public User(String id, String username, String password, String permissions, ArrayList<String> filesUploaded, ArrayList<String> specifications) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.permissions = permissions;
        this.filesUploaded = filesUploaded;
        this.specifications = specifications;
    }

    public void setFilesUploaded(ArrayList<String> filesUploaded) {
        this.filesUploaded = filesUploaded;
    }

    public ArrayList<String> getFilesUploaded() {
        return filesUploaded;
    }

    public void setSpecifications(ArrayList<String> specifications) {
        this.specifications = specifications;
    }

    public ArrayList<String> getSpecifications() {
        return specifications;
    }

    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
