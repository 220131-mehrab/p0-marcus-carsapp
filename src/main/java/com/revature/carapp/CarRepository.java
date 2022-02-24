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
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CarRepository {
    private List<Car> cars;
    private Connection connection;

    public CarRepository(String csvFile) {
        cars = new ArrayList<>();
        parseCars(loadCSV(csvFile));

}

    private BufferedReader loadCSV(String csvFile) {
        return loadCSV("cars.csv");
    }

    public void setConnection(Connection connection) {
    this.connection = connection;
}

public List<Car> getCars() {
    return cars;
}
public void save(Car car) {
    try {
        Statement statement = connection.createStatement();
        statement.execute("INSERT INTO CARS VALUES(" + car.getCarModel() + ", '" + car.getMpg() + "' " + car.getHp() + "')");

    } catch (SQLException e) {
        e.printStackTrace();
    }
}

private void parseCars(BufferedReader br) {
    //read using OpenCSV library
    CSVParser parser = new CSVParserBuilder().withSeparator(',').build();
    CSVReader reader = new CSVReaderBuilder(br).withCSVParser(parser).withSkipLines(1).build();
    List<String[]> lines = null;
    try {
        lines = reader.readAll();
        reader.close();
    } catch (IOException e) {
        e.printStackTrace();
    } catch (CsvException e) {
        e.printStackTrace();
    }

    // Parse lines into Artist array
    for (String[] columns : lines) {
        cars.add(new Car(Integer.parseInt(columns[1]), columns[2], columns[5]));
        }
    }
}
