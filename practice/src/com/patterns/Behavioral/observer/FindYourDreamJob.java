package com.patterns.Behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public class FindYourDreamJob implements Observed{
    private List<String> offers = new ArrayList<>();
    private List<Observer> subscriber = new ArrayList<>();

    public void createNotify(List<String> offers) {
        this.offers = offers;
        notifyAllObservers();
    }

    @Override
    public void addObserver(Observer observer) {
        this.subscriber.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        this.subscriber.remove(observer);
    }

    @Override
    public void notifyAllObservers() {
        subscriber.forEach(s -> s.update(offers));
    }
}
