package com.revature.carapp;


import org.apache.catalina.LifecycleException;

import java.util.List;


public class App {
    public static void main(String[] args) {
        CarRepository carObject = new CarRepository();
        carObject.printCarList();
        AppContext.build();
        // Serve on Tomcat server
        try {
            AppContext.getTomcat().start();
        } catch (LifecycleException e) {
            System.err.println("Embedded server failed to start!");

        }

        // Save results
    }
}

