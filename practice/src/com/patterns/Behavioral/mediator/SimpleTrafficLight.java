package com.patterns.Behavioral.mediator;

public class SimpleTrafficLight implements TrafficLight{
    private TrafficLightController trafficLightController;
    private String name;

    public SimpleTrafficLight(TrafficLightController trafficLightController, String name) {
        this.trafficLightController = trafficLightController;
        this.name = name;
    }

    @Override
    public void sendCommand(String massage) {
        trafficLightController.sendCommand(this, massage + " [" + this.name + "]");
    }

    @Override
    public void getCommand(String massage) {
        System.out.println(this.name + " get command " + massage);
    }
}
