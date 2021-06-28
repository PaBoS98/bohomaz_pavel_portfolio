package com.abstract_interface;

public interface InterfaceClass {
    void i();

    default int mi(int x) {
        return x;
    }

    static int mis(int x) {
        return x;
    }
}
