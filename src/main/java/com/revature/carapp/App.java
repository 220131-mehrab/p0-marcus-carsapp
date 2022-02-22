package com.revature.carapp;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;





public class App {
    public static void main(String[] args) {
        // Load data
        List<Car> cars = App.loadCars();

        //Search query
        String searchQuery = "Mazda";
        System.out.println(searchByCarModel(searchQuery, cars));

        // Save results
    }

    public static List<Car> loadCars() {
        // Reading CSV data
        URI uri = null;
        try{
            uri = Objects.requireNonNull(App.class.getClassLoader().getResource("cars.csv")).toURI();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        Path filepath = Paths.get(Objects.requireNonNull(uri));
        List<Car> cars = new ArrayList<>();
        try {
                BufferedReader br = Files.newBufferedReader(filepath);

                //read using OpenCSV library
                CSVParser parser = new CSVParserBuilder().withSeparator(',').build();
                CSVReader reader = new CSVReaderBuilder(br).withCSVParser(parser).withSkipLines(1).build();
                List<String[]> lines = reader.readAll();
                reader.close();

                // Parse lines into Car array
            for (String[] columns : lines) {
                cars.add(new Car(Integer.parseInt(columns[1]), columns[2], columns[5]));
            }
        } catch (IOException e) {
            System.err.println("Couldn't load file!");
        } catch (CsvException e) {
            System.err.println("OpenCSV Failed to parse!");
        }
        return cars;
    }
    public static String searchByCarModel(String searchQuery, List<Car> cars) {
        for (Car car : cars) {
            if (car.getCarModel().equalsIgnoreCase(searchQuery))
                return car.getCarModel();
        }
        return null;
    }
}

