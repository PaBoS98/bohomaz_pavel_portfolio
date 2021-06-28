package com.clone;

import java.util.Objects;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        User u1 = new User();
        Amount a = new Amount();
        a.setSum(1488);


        u1.setAge(54);
        u1.setName("Valera");
        u1.setAmount(a);

        User u2 = (User) u1.clone();

        System.out.println("Before changing");
        System.out.println("Amount u1 --> " + u1.getAmount());
        System.out.println("Amount u2 --> " + u2.getAmount());
        System.out.println("Link --> " + (u1 == u2));
        System.out.println("Equals --> " + u1.equals(u2));

        u1.getAmount().setSum(228);

        System.out.println("\nAfter changing");
        System.out.println("Amount u1 --> " + u1.getAmount());
        System.out.println("Amount u2 --> " + u2.getAmount());
        System.out.println("Link --> " + (u1 == u2));
        System.out.println("Equals --> " + u1.equals(u2));
    }
}

class User implements Cloneable {
    private String name;
    private int age;
    private Amount amount;

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

    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
//        return super.clone();
        User clone = (User) super.clone();
        clone.setAmount((Amount) clone.getAmount().clone());
        return clone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && Objects.equals(name, user.name) && Objects.equals(amount, user.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, amount);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", amount=" + amount +
                '}';
    }
}

class Amount implements Cloneable{
    private int sum;

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Amount amount = (Amount) o;
        return sum == amount.sum;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sum);
    }

    @Override
    public String toString() {
        return "Amount{" +
                "sum=" + sum +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
