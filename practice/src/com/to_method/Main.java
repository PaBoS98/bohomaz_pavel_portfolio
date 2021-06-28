package com.to_method;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int x = 0;
        User user = new User();
        user.setAge(0);
        int[] i = {0, 2, 5};

        System.out.println("Before method");
        System.out.println(x);
        System.out.println(user.getAge());
        System.out.println(Arrays.toString(i));

        test(x, user, i);

        System.out.println("\n After method");
        System.out.println(x);
        System.out.println(user.getAge());
        System.out.println(Arrays.toString(i));

    }

    public static void test(int x, User user, int[] i) {
        x = x + 10;
        user = new User();
        user.setAge(user.getAge() + 10);
        i[0] = i[0] + 10;

        System.out.println("\n In method");
        System.out.println(x);
        System.out.println(user.getAge());
        System.out.println(Arrays.toString(i));
    }
}

class User {
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
