package com.patterns.Behavioral.mediator;

import java.util.ArrayList;
import java.util.List;

public class Controller implements TrafficLight{
    private TrafficLightController trafficLightController;

    private List<String> history = new ArrayList<>();

    public Controller(TrafficLightController trafficLightController) {
        this.trafficLightController = trafficLightController;
    }

    @Override
    public void sendCommand(String massage) {
        trafficLightController.sendCommand(this, massage);
    }

    @Override
    public void getCommand(String massage) {
        history.add(massage);
        System.out.println("Controller get command " + massage);
    }
}
