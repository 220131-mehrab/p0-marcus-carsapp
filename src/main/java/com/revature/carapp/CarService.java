package com.revature.carapp;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class CarService extends HttpServlet {
    //made private because we don't want anything accessing it directly
    private CarRepository carRepository;

    //below: this carRepository points to the one directly under it
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public String searchForm() {
        String HTMLForm = "<Html>\n" +
                "<Head>\n" +
                "<Input>\n /" +
                "    <Title>Search Cars" +
                "</Title>\n" +
                "</Head>\n" +
                "<Body>\n" +
                "    <h1>Car Search</h1>\n" +
                "    <form action='car' method='get'>\n" +
                "        <input type='name' name='searchName'/>\n" +
                "        <input type='submit' value='Search'/>\n" +
                "    " +
                "    <a href='cars'>See Full Car list</a>\n" +
                "</form>\n" +
                "</Body>\n" +
                "</Html>";
        return HTMLForm;
    }

    public List<Car> getCars() {
        return carRepository.getCars();
    }

    public Car getCar(String userInput) {
        return carRepository.getCar(userInput.trim().toLowerCase());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        for (Car cars : carRepository.getCars()) {
            resp.getWriter().println(cars);
        }
    }
}

