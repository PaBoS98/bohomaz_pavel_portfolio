package com.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class A {
    private int i;

    public A () {
        i = (int) Math.random();
    }
}
