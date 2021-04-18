package com.patterns.Behavioral.observer;

import java.util.List;

public class Subscriber implements Observer {
    private String name;

    public Subscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(List<String> offer) {
        System.out.println(name + " you have a new offer!\n  " + offer + "\n\n");
    }
}
