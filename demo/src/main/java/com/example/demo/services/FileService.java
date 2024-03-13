package com.example.demo.services;

import com.example.demo.models.File;
import com.example.demo.repositories.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FileService {

    private FileRepository fileRepository;

    @Autowired
    public FileService(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    public List<File> findAllFilesByFileName(String fileName){
        return fileRepository.findAllFileByFileName(fileName);
    }

    public File createNewFile(File newFile) {
        return fileRepository.save(newFile);
    }

    public void deleteFile(String fileName) {
        fileRepository.deleteByFileName(fileName);
    }
}
