package com.example.demo.parser;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;


//TODO adapt the parser to build json representations of the flat files rather than list<string>
public class Parser {

    /**
     This will take in a File and read the contents character by character, appending to a string before
     returning the completed string.
     */
    public String readCompleteChars(File file) throws IOException {
        FileInputStream stream = new FileInputStream(file);
        InputStreamReader reader = new InputStreamReader(stream, StandardCharsets.UTF_8);
        StringBuilder builder = new StringBuilder();
        while(reader.ready()) {
            builder.append((char)reader.read());
        }
        return builder.toString();
    }

    /**
     * This reads the entire file at once with readAllBytes.
     * @param file
     * @return
     * @throws IOException
     */
    public String readAllBytes(File file) throws IOException {
        return new String(Files.readAllBytes(file.toPath())).intern();
    }


    /**
     * This will take a flat file and a spec map in order to create a list of strings, each representing
     * one field value from the flat file.
     * @param data
     * @param spec
     * @return
     * @throws IOException
     */
    public List<String> readStringFields(String data, Map<String, Field> spec) throws IOException {
        List<String> fieldList = new ArrayList<>();

        Set<String> fields = spec.keySet();
        for(String fieldName : fields) {
            Field field = spec.get(fieldName);
            String fieldValue = data.substring(field.getStartPos(), field.getEndPos()+1).trim();
            fieldList.add(fieldValue);
            System.out.println("[" + fieldName + "][" + fieldValue + "]");
        }
        return fieldList;
    }

    public static Map<String, Field> parseSpec(File specFile) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Field> map = mapper.readValue(specFile, new TypeReference<Map<String, Field>>() {});

        Set<String> keySet = map.keySet();
        for(String s : keySet){
            map.get(s).setName(s);
        }

        System.out.println(map);
        return map;
    }





}
