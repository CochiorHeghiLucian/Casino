package com.example.demo.util;

import lombok.experimental.UtilityClass;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@UtilityClass
public class FileNameGenerator {
    public String getFileName() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy_MM_dd-HH");
        Instant now = Instant.now();
        ZoneId zoneId = ZoneId.of("Europe/Bucharest");
        ZonedDateTime dateInRomania = ZonedDateTime.ofInstant(now, zoneId);
        return format.format(dateInRomania) + "hour.txt";
    }

    public static void main(String[] args) {
        System.out.println(getFileName());
    }
}
