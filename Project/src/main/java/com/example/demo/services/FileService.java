package com.example.demo.services;

import com.example.demo.models.ReadFile;
import com.example.demo.repositories.FileRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileService {

    private FileRepository fileRepository;

    @Autowired
    public FileService(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    public List<ReadFile> findAllFilesByFileName(String fileName){
        return fileRepository.findAllFileByFileName(fileName);
    }

    public ReadFile createNewFile(ReadFile newReadFile) {
        return fileRepository.save(newReadFile);
    }

    public void deleteFile(String fileName) {
        fileRepository.deleteByFileName(fileName);
    }

    public List<ReadFile> findAllFilesById(List<ObjectId> fileIds) {
        return fileRepository.findAllById(fileIds);
    }

    public List<ReadFile> findAllFiles() {
        return fileRepository.findAll();
    }
}
