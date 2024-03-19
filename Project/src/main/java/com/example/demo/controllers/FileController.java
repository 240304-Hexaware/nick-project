package com.example.demo.controllers;

import com.example.demo.models.ReadFile;
import com.example.demo.services.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    public List<ReadFile> getAllFilesByName(@RequestParam("filename") String fileName){
        return fileService.findAllFilesByFileName(fileName);
    }

//    @GetMapping("/files")
//    @ResponseStatus(HttpStatus.FOUND)
//    public List<ReadFile> getAllFilesByIds(@RequestBody List<String> fileIds){
//        return fileService.findAllFilesById(fileIds);
//    }

    @PostMapping("/files")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ReadFile postNewFIle(@RequestBody ReadFile newReadFile){
        return fileService.createNewFile(newReadFile);
    }

    @DeleteMapping("files")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteFile(@RequestParam("filename") String fileName){
        fileService.deleteFile(fileName);
    }

}
