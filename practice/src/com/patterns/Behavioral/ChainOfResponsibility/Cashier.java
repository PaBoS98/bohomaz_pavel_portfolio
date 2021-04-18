package com.patterns.Behavioral.ChainOfResponsibility;

public class Cashier extends GiveChange{

    public Cashier(int possibility) {
        super(possibility);
    }

    @Override
    public void say() {
        System.out.println("Кассир выдал сдачу");
    }
}
