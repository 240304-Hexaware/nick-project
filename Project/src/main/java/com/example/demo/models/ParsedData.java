package com.example.demo.models;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document("parsed_datas")
public class ParsedData {

    @Field(name = "_id")
    @MongoId(FieldType.OBJECT_ID)
    private String id;

    @Field(name = "json_conversion")
    private String jsonConversion;

    public ParsedData(){

    }

    public ParsedData(String jsonConversion) {
        this.id = id;
        this.jsonConversion = jsonConversion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJsonConversion() {
        return jsonConversion;
    }

    public void setJsonConversion(String jsonConversion) {
        this.jsonConversion = jsonConversion;
    }
}
