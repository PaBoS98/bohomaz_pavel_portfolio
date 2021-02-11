package com.count_porcent_symbols;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String getString = scanner.nextLine();
        char[] array = getString.toCharArray();
        double res = 0;
        String str;
        for (int i = 0; i < array.length; i++) {
            str = String.valueOf(array[i]);
            if (str.equals("g") || str.equals("c")) {
                res++;
            }
        }
        System.out.println(res / 10 * 100);
    }
}

