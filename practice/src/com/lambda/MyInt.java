package com.lambda;

public class MyInt {

    private int v;

    MyInt(int v) {
        this.v = v;
    }

    public int getV() {
        return v;
    }

    boolean isFactor(int n) {
        System.out.println("HERE");
        return (v % n) == 0;
    }
}
