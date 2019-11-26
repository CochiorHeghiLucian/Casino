package com.example.demo;

import com.example.demo.dataread.DataReadNumbers;
import com.example.demo.util.FileReader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.io.IOException;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) throws IOException, InterruptedException {
        DataReadNumbers dataReadNumbers = new DataReadNumbers();
        String fileName = dataReadNumbers.writeDateIntoFile();
        System.out.println(FileReader.readData(fileName));
//        SpringApplication.run(DemoApplication.class, args);
    }


}
