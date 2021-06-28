package com.abstract_interface;

public abstract class AbstractClass {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    abstract void t();

    int mt(int i) {
        return i;
    }

    static int mts (int i) {
        return i;
    }
}
