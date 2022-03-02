package com.revature.carapp;


import org.apache.catalina.LifecycleException;

import java.util.List;


public class App {
    public static void main(String[] args) {
        CarRepository carObject = new CarRepository();
        carObject.printCarList();
    }
}

