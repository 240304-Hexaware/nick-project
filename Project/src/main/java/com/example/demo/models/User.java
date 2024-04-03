package com.example.demo.models;


import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document(collection = "users")
public class User {

    @Field(name = "username")
    private String username;

    @Field(name = "password")
    private String password;

    @Field(name = "permissions")
    private String permissions;

    @Field(name = "files_uploaded")
    private List<ObjectId> filesUploaded;

    @Field(name = "specifications")
    private List<ObjectId> specifications;

    public User(){

    }

    public User(String username, String password, String permissions) {
        this.username = username;
        this.password = password;
        this.permissions = permissions;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.permissions = "user";
    }

    public User( String username, String password, String permissions, List<ObjectId> filesUploaded, List<ObjectId> specifications) {
        this.username = username;
        this.password = password;
        this.permissions = permissions;
        this.filesUploaded = filesUploaded;
        this.specifications = specifications;
    }

    public void setFilesUploaded(List<ObjectId> filesUploaded) {
        this.filesUploaded = filesUploaded;
    }

    public List<ObjectId> getFilesUploaded() {
        return filesUploaded;
    }

    public void setSpecifications(List<ObjectId> specifications) {
        this.specifications = specifications;
    }

    public List<ObjectId> getSpecifications() {
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
