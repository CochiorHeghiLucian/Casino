package com.example.demo.util;

import lombok.experimental.UtilityClass;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class FileReader {
    public List<Integer> readData(String name) throws IOException {
        Charset utf8 = StandardCharsets.UTF_8;
        Path newFilePath = Paths.get("src/main/resources/data/" + name);
        List<String> lines = Files.readAllLines(newFilePath, utf8);
        return lines.stream()
                .map(Integer::new)
                .collect(Collectors.toList());
    }

}
