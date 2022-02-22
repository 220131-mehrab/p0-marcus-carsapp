package com.revature.carapp;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    @Test
    public void givenCarCarModel_ThenReturnCar() {
        List<Car> lines = App.loadCars();

        String givenCar = "Mazda";
        String result = App.searchByCarModel(givenCar, lines);
        assertEquals(givenCar, result);
    }

}