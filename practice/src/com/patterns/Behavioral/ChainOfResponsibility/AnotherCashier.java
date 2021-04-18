package com.patterns.Behavioral.ChainOfResponsibility;

public class AnotherCashier extends GiveChange{
    public AnotherCashier(int possibility) {
        super(possibility);
    }

    @Override
    public void say() {
        System.out.println("Другой кассир передал деньги");
    }
}
