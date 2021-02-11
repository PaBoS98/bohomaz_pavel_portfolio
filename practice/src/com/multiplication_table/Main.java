package com.multiplication_table;

import java.util.Scanner;

public class Main {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int a = 9;
        int b = 10;
        int c = 4;
        int d = 6;

        System.out.println("Введите а");
        a = scanner.nextInt();
        System.out.println("Введите b");
        b = scanner.nextInt();
        System.out.println("Введите c");
        c = scanner.nextInt();
        System.out.println("Введите d");
        d = scanner.nextInt();

        for (int i = c; i <= d ; i++) {
            if (c < 10) {
                System.out.printf(ANSI_PURPLE + "%8d" + ANSI_RESET, i);
            } else System.out.printf(ANSI_PURPLE + "%7d" + ANSI_RESET, i);
        }
        for (int i = a; i <= b; i++) {
            System.out.print("\n \n" + ANSI_PURPLE +  + i  + ANSI_RESET);
            for (int j = c; j <= d ; j++) {
                if (i < 10) {
                    if (j == c) {
                        System.out.printf(ANSI_CYAN + "%7d" + ANSI_RESET, i * j);
                    } else System.out.printf(ANSI_CYAN + "%8d" + ANSI_RESET, i * j);
                } else if (j == c) {
                    System.out.printf(ANSI_CYAN + "%6d" + ANSI_RESET, i * j);
                } else System.out.printf(ANSI_CYAN + "%8d" + ANSI_RESET, i * j);
            }
        }

    }
}
