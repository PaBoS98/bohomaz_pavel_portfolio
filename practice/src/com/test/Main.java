package com.test;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {

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

