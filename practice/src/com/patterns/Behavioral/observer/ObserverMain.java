package com.patterns.Behavioral.observer;

import java.util.List;

public class ObserverMain {
    public static void main(String[] args) {

        List<String> offers = List.of("брод", "каторга", "зрачок", "поплавок", "лак", "корма", "ателье", "баллон", "след от укуса", "керосин", "бумажник");

        FindYourDreamJob findYourDreamJob = new FindYourDreamJob();

        Subscriber subscriber1 = new Subscriber("Jawe");
        Subscriber subscriber2 = new Subscriber("Liku");
        Subscriber subscriber3 = new Subscriber("Dovene");
        Subscriber subscriber4 = new Subscriber("Punyudhi");
        Subscriber subscriber5 = new Subscriber("Kisekozame");

        findYourDreamJob.addObserver(subscriber1);
        findYourDreamJob.addObserver(subscriber2);
        findYourDreamJob.addObserver(subscriber3);
        findYourDreamJob.addObserver(subscriber4);
        findYourDreamJob.addObserver(subscriber5);

        findYourDreamJob.createNotify(offers);
    }
}
