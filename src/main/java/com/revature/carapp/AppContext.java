package com.revature.carapp;

import org.apache.catalina.startup.Tomcat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AppContext {
    private static final String carCSVFile = "cars.csv";
    private static CarRepository carRepository;
    private static Tomcat server;
    private static CarController carController;
    private static Connection connection;

    public static void build() {
        carRepository = new CarRepository();
        carController = new CarController();
        server = new Tomcat();
        server.getConnector();
        server.addContext("", null);
        server.addServlet("", "carServlet", carController).addMapping("/cars");
        try {
            connection = DriverManager.getConnection("jdbc:h2:~/carsapp", "carsapp", "carsapp");
            connection.createStatement().execute("CREATE TABLE ARTISTS(id int primary key, name varchar)");
            carRepository.setConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static CarRepository getCarRepository() {
        return carRepository;
    }


    public static Tomcat getTomcat() {
        return server;
    }

}
