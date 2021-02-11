package com.code_wars.order_word;

public class Main {

    public static void main(String[] args) {

        System.out.println(Order.order("is2 Thi1s T4est 3a"));
    }
}

class Order {
    public static String order(String words) {
        // ...
        String[] array;
        array = words.split(" ");

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (array[j].contains(String.valueOf(i + 1))) {
                    if (i != 0) {
                        words = words + " " + array[j];
                    } else {
                        words = array[j];
                    }
                }
            }
        }
        return words;

    }
}
