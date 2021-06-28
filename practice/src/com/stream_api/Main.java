package com.stream_api;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Predicate<User> agePredicate = e -> e.getAge() >= 18;
        Predicate<User> agePredicate1 = e -> e.getAge() <= 54;

        ArrayList<User> userList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            userList.add(new User("#" + i, (int) (Math.random()*100)));
        }

       User peek = userList.stream()
                .filter(agePredicate)
                .filter(agePredicate1)
                .peek(e -> e.setName("peek"))
                .findAny()
                .get();


        System.out.println(userList.stream()
                .filter(agePredicate)
                .filter(agePredicate1)
                .map(e -> new User("", e.getAge()))
                .findAny()
                .get());

    }
}

final class User {
    private String name;
    private int age;

    User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
