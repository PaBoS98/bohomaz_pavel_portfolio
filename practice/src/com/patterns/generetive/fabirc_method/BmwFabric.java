package com.patterns.generetive.fabirc_method;

public class BmwFabric implements Fabric{
    @Override
    public Car createCar() {
        return new BMW();
    }
}
