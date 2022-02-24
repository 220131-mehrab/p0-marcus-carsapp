package com.revature.carapp;

import com.opencsv.exceptions.CsvException;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {
  static List<Car> cars;
    @Test
    public void givenCarModel_ThenReturnCar() throws IOException, CsvException {

        String givenCar = "Mazda";
        String result = App.searchByCarModel(givenCar, cars);
        assertEquals(givenCar, result);
    }
    @Test
    public void givenNonCSVFile_ThenThrowsIllegalArgumentException() {
        String notCSV = "cars.csv";

    }

}