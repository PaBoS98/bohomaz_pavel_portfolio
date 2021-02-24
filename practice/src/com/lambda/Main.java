package com.lambda;

public class Main {
    public static void main(String[] args) {

        boolean res;
        MyInt i = new MyInt(5);

        FuncInterface f = MyInt::isFactor;

        res = f.test(i, 2);
        System.out.printf(String.valueOf(res));
    }
}
