package com.patterns.generetive.fabirc_method;

public class Main {
    public static void main(String[] args) {
        Fabric fabric = new MercedesFabric();
        Car car = fabric.createCar();
        car.mark();
    }
}
