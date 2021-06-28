package com.app;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Getter
public class B {

    private A a;

    @Autowired
    public void setA(A a) {
        this.a = a;
    }
}
