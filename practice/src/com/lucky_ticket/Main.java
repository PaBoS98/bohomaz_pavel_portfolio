package com.lucky_ticket;

import java.util.Scanner;

public class Main {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public static void main(String[] args) {

        System.out.println("Впиши 6 значное число");
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int[] array = new int[6];
        for (int i = 0; i < array.length; i++) {
            array[i] = a % 10;
            a = a / 10;
        }
        int sumSecond = 0;
        for (int i = 0; i < array.length / 2; i++) {
            sumSecond += array[i];
        }
        int sumFirst = 0;
        for (int i = array.length / 2; i < array.length; i++) {
            sumFirst += array[i];
        }
        if (sumFirst == sumSecond) {
            System.out.println(ANSI_GREEN + "Счастливый");
        } else System.out.println(ANSI_RED + "Обычный");
    }
}
