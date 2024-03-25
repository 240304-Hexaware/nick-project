package com.example.demo.controllers;

import com.example.demo.models.ReadFile;
import com.example.demo.parser.Field;
import com.example.demo.parser.Parser;
import com.example.demo.services.FileService;
import org.bson.BsonDocument;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins="*")
public class FileController {

    private FileService fileService;

    @Autowired
    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @GetMapping("/files")
    @ResponseStatus(HttpStatus.OK)
    public List<ReadFile> getAllFilesByName(@RequestParam("filename") String fileName){
        return fileService.findAllFilesByFileName(fileName);
    }

    @GetMapping("/files/id")
    @ResponseStatus(HttpStatus.FOUND)
    public List<ReadFile> getAllFilesByIds(@RequestBody List<ObjectId> fileIds){
        return fileService.findAllFilesById(fileIds);
    }

    @PostMapping("/files")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ReadFile postNewFile(@RequestBody ReadFile newReadFile){
        return fileService.createNewFile(newReadFile);
    }

    @PostMapping("/files/upload")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String uploadFile(@RequestParam("file") MultipartFile newFile, @RequestParam("spec") String specName, @RequestParam("user") String userName) throws IOException {
        InputStreamReader reader = new InputStreamReader(newFile.getInputStream());
        StringBuilder builder = new StringBuilder();
        while(reader.ready()) {
            builder.append((char)reader.read());
        }
        System.out.println(builder.toString());

        File uploaded = new File("C://Users//BerkenNicholas//Documents//Revature training//FullProject//nick-full-project//nick-project//Project//Flatfiles//"+newFile.getOriginalFilename());
        FileWriter writer = new FileWriter(uploaded);
        writer.append(builder.toString());
        writer.close();

        File spec = new File("C://Users//BerkenNicholas//Documents//Revature training//FullProject//nick-full-project//nick-project//Project//Specs//"+specName);

        Parser parser = new Parser();
        Map<String, Field> map = Parser.parseSpec(spec);

        String data = parser.readAllBytes(uploaded);
        BsonDocument bison = parser.readStringFieldsBson(data, map);

        ReadFile readFile = new ReadFile(newFile.getName(), specName, new Date(), uploaded.getTotalSpace(), uploaded.getPath(), bison.toString(), userName);

        fileService.createNewFile(readFile);

        return bison.toString();
    }

    @DeleteMapping("files")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteFile(@RequestParam("filename") String fileName){
        fileService.deleteFile(fileName);
    }

}
