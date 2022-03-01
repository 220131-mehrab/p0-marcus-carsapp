package com.revature.carapp;

import com.opencsv.exceptions.CsvException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {
  static List<Car> cars;

    @BeforeAll
    public static void setup() throws IOException, CsvException {
        cars = App.parseCars(App.loadCSV("cars.csv"));
    }
    
    @Test
    public void givenCarModel_ThenReturnCar() throws IOException, CsvException {

        String givenCar = "Mazda";
        String result = App.searchByCarModel(givenCar, cars);
        assertEquals(givenCar, result);
    }
    @Test
    public void givenNonCSVFile_ThenThrowsIllegalArgumentException() {
        String notCSV = "cars.csv";
        assertThrows(IllegalArgumentException.class, () -> App.loadCSV(notCSV));

    }

}