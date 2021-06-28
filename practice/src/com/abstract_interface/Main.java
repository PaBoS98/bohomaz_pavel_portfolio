package com.abstract_interface;

public class Main {
    public static void main(String[] args) {
        FromAbstract f = new FromAbstract();
        System.out.println(f.mt(1));
        f.t();
        f.setName("abstract");
        System.out.println(f.getName());

        FromInterface i = new FromInterface();
        i.i();
        System.out.println(i.mi(2));
    }
}

class FromAbstract extends AbstractClass {

    @Override
    void t() {
        System.out.println("a");
    }
}

class FromInterface implements InterfaceClass {

    @Override
    public void i() {
        System.out.println("i");
    }

    @Override
    public int mi(int x) {
        return InterfaceClass.super.mi(x);
    }
}
