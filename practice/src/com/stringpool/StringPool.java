package com.stringpool;

public class StringPool {
    public static void main(String[] args) {
        String s1 = "Hello";
        String s2 = new String("Hello");

        System.out.println(s1 == s2);

        s1 = s1.intern();

        System.out.println(s1 == s2);


        s2 = s2.intern();

        System.out.println(s1 == s2);

        s2 = s2.intern();

        System.out.println(s1 == s2);

        s2 = new String("Hello");

        System.out.println(s1 == s2);

        s2 = s2.intern();

        System.out.println(s1 == s2);
    }
}
