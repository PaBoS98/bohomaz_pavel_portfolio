package com.max_min_other;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[31:1m";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] array = new int[3];
        array[0] = scanner.nextInt();
        array[1] = scanner.nextInt();
        array[2] = scanner.nextInt();
        Arrays.sort(array);
        System.out.println(array[2] + " " + array[0] + " " + array[1]);

        int[] array1 = new int[50];
        for (int i = 0; i < array1.length; i++) array1[i] = (int) Math.round(Math.random() * 10);
        Arrays.sort(array1);
        System.out.println(Arrays.toString(array1));
        System.out.print(ANSI_GREEN + array1[array1.length-1] + " " + array1[0] + " " + ANSI_RESET);
        for (int i = 1; i < array1.length - 2; i++) System.out.print( array1[i] + " ");

    }
}
