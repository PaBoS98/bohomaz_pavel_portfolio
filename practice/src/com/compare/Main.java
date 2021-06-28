package com.compare;


import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        UserComparable u1 = new UserComparable();
        UserComparable u2 = new UserComparable();
        u1.setName("1");
        u2.setName("1");
        u1.setAge(22);
        u2.setAge(23);

//        System.out.println(u1.compareTo(u1));
//        System.out.println(u1.compareTo(u2));
//        System.out.println(u2.compareTo(u1));

        UserComparator userComparator = new UserComparator();
        System.out.println(userComparator.compare(u1, u1));
        System.out.println(userComparator.compare(u1, u2));
        System.out.println(userComparator.compare(u2, u1));
    }
}

class UserComparable implements Comparable {
    String name;
    int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public int compareTo(Object o) {
        UserComparable u = (UserComparable) o;
        if (age == u.getAge()) return 0;
        else if (age > u.getAge()) return 1;
        return -1;
    }
}

class UserComparator implements Comparator<UserComparable> {
    @Override
    public int compare(UserComparable o1, UserComparable o2) {
        if (o1.getAge() == o2.getAge()) return 0;
        else if (o1.getAge() > o2.getAge()) return 1;
        return -1;
    }
}
