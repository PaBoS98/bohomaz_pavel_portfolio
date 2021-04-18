package com.patterns.Behavioral.mediator;

import java.util.ArrayList;
import java.util.List;

public class MediatorMain {
    public static void main(String[] args) {
        TrafficController controller = new TrafficController();

        List<TrafficLight> trafficLight = new ArrayList<>();

        TrafficLight firstTrafficLight = new SimpleTrafficLight(controller, "parallel");
        TrafficLight thirdTrafficLight = new SimpleTrafficLight(controller, "vertical");
        TrafficLight trafficController = new Controller(controller);

        trafficLight.add(firstTrafficLight);
        trafficLight.add(thirdTrafficLight);

        controller.setController(trafficController);
        controller.setTrafficLights(trafficLight);

        firstTrafficLight.sendCommand("Мне пора переключатся на другой цвет");
    }
}
