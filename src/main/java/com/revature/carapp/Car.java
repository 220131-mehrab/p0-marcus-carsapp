package com.revature.carapp;

public class Car {
    private String carModel;
    private int mpg;
    private int hp;

    public Car() {

    }

    public Car(String carModel, int mpg, int hp) {
        this.carModel = carModel;
        this.mpg = mpg;
        this.hp = hp;
    }

    public Car(int parseInt, String column, String column1) {
    }

    public String getCarModel() {
        return carModel;
    }
    public void setCarModel(String carModel) {

    }

    public int getMpg() {
        return mpg;
    }

    public void setMpg(int mpg) {
        this.mpg = mpg;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
    @Override
    public String toString() {
        return "Car {" +
                "carModel=" + carModel +
                ", mpg='" + mpg + '\'' +
                ", hp='" + hp + '\'' +
                '}';
        }
    }
