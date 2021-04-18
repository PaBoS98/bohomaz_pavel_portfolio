package com.patterns.Behavioral.ChainOfResponsibility;

public class Incosators extends GiveChange{
    public Incosators(int possibility) {
        super(possibility);
    }

    @Override
    public void say() {
        System.out.println("Инкассация привезла деньги для сдачи");
    }
}
