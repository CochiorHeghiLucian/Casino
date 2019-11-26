package com.example.demo.util;

import lombok.experimental.UtilityClass;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@UtilityClass
public class FileWriter {
    public void writeData(List<String> numbers, String name) throws IOException {
        Charset utf8 = StandardCharsets.UTF_8;
        Path newFilePath = Paths.get("src/main/resources/data/" + name);
        Files.write(newFilePath, numbers, utf8);
    }
}
