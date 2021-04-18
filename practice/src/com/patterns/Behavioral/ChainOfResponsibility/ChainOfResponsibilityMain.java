package com.patterns.Behavioral.ChainOfResponsibility;

public class ChainOfResponsibilityMain {
    public static void main(String[] args) {
        int priority = 4;

        GiveChange cashier = new Cashier(1);
        GiveChange anotherCashier = new AnotherCashier(2);
        GiveChange incosators = new Incosators(3);
        GiveChange bank = new Bank(4);

        cashier.setNextGiveChange(anotherCashier);
        anotherCashier.setNextGiveChange(incosators);
        incosators.setNextGiveChange(bank);

        cashier.giveChange(priority);
    }
}
