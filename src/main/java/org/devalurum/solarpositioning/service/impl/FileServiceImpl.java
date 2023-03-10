package org.devalurum.solarpositioning.service.impl;

import lombok.SneakyThrows;
import org.devalurum.solarpositioning.service.FileService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

@Service
public class FileServiceImpl implements FileService {

    @Value("${app.filename}")
    private String filename;

    private static final String ROOT_DIR = System.getProperty("user.dir");

    @SneakyThrows
    @Override
    public Path save(String content) {
        Path filePath = Paths.get(ROOT_DIR).resolve(filename);
        return Files.write(filePath, content.getBytes(), StandardOpenOption.CREATE);
    }
}
