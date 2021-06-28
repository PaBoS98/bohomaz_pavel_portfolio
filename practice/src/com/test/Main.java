package com.test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {

        String[] str = new String[10];
        str[0] = "FIRST";
        System.out.println(Arrays.asList(str).size());
        System.out.println(Arrays.asList(str));

        List<String> strings = Arrays.asList(str);

        strings.add("new");
        System.out.println(strings.size());
    }


}

// composition
class A {
    private B b;

    A() {
        this.b = new B();
    }
}

class B {

}

//Association
class C {
    private B b;

}

//Agregation
class D {
    private B b;

    D(B b) {
        this.b = b;
    }
}

