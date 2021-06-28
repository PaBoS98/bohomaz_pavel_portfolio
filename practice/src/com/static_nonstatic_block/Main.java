package com.static_nonstatic_block;

public class Main {
    public static void main(String[] args) {

    }
}

class Test {

    static {
        try {
            throw new Exception("From static");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    {
        try {
            throw new Exception("From non");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Test() {
    }
}


class A {
    static void a () {
        System.out.println("a - a");
    }

    void b () {
        System.out.println("b - a");
    }
}

class B extends A {
    @Override
    void b() {
        System.out.println("b - b");
    }
}
