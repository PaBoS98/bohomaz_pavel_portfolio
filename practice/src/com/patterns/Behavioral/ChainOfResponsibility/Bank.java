package com.patterns.Behavioral.ChainOfResponsibility;

public class Bank extends GiveChange{
    public Bank(int possibility) {
        super(possibility);
    }

    @Override
    public void say() {
        System.out.println("Банк передал деньги инкосации для сдачи");
    }
}
