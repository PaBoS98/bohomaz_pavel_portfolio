package com.patterns.Behavioral.mediator;

import java.util.List;

public class TrafficController implements TrafficLightController{
    TrafficLight controller;
    List<TrafficLight> trafficLights;

    public void setController(TrafficLight controller) {
        this.controller = controller;
    }

    public void setTrafficLights(List<TrafficLight> trafficLights) {
        this.trafficLights = trafficLights;
    }

    @Override
    public void sendCommand(TrafficLight trafficLight, String massage) {
        for (TrafficLight e : trafficLights) {
            if (e != this) e.getCommand(massage);
        }
        controller.getCommand(massage);
    }
}
