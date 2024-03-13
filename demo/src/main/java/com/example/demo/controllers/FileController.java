package com.example.demo.controllers;

import com.example.demo.models.File;
import com.example.demo.services.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FileController {

    private FileService fileService;

    @Autowired
    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @GetMapping("/files")
    @ResponseStatus(HttpStatus.OK)
    public List<File> getAllFilesByName(@RequestParam("filename") String fileName){
        return fileService.findAllFilesByFileName(fileName);
    }

    @PostMapping("/files")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public File postNewFIle(@RequestBody File newFile){
        return fileService.createNewFile(newFile);
    }

    @DeleteMapping("files")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteFile(@RequestParam("filename") String fileName){
        fileService.deleteFile(fileName);
    }

}
