package com.revature.carapp;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.util.List;

public class CarRepository {
    public CarRepository() {
        
    }

    public void printCarList() {
        URI uri = null;

        try {
            uri = App.class.getClassLoader().getResource("cars.csv").toURI();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        Path filePath = Paths.get(uri);
        List<String> lines = null;
        try {
            lines = Files.readAllLines(filePath, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //lines.forEach(System.out::println);
        String searchQuery = "Camaro Z28";
        for (String car: lines) {
            if (car.contains(searchQuery))
                System.out.println(car);
        }
    }

    public void setConnection(Connection connection) {
    }
}