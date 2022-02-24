package com.revature.carapp;

import java.util.List;

public class CarService {
    private CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public String searchByCarModel(String searchQuery) {
        for (Car car : carRepository.getCars()) {
            if (car.getCarModel().equalsIgnoreCase(searchQuery))
                return car.getCarModel();
        }
        return null;
    }

    public void saveCar(Car car) {
        carRepository.save(car);
    }
}
