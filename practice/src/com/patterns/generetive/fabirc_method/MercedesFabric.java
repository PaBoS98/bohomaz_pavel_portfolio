package com.patterns.generetive.fabirc_method;

public class MercedesFabric implements Fabric {
    @Override
    public Car createCar() {
        return new Mercedes();
    }
}
