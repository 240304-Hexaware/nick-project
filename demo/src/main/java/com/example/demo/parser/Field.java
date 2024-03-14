package com.example.demo.parser;

public class Field {
    private int startPos;
    private int endPos;
    private String name;
    private String dataType;

    public Field(int startPos, int endPos, String name, String dataType) {
        this.startPos = startPos;
        this.endPos = endPos;
        this.name = name;
        this.dataType = dataType;
    }

    public int getStartPos() {
        return startPos;
    }

    public void setStartPos(int startPos) {
        this.startPos = startPos;
    }

    public int getEndPos() {
        return endPos;
    }

    public void setEndPos(int endPos) {
        this.endPos = endPos;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }
}
