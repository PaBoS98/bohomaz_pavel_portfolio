package com.dna;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String res = scanner.nextLine();
        int count = 1;
        char[] array = res.toCharArray();
        res = "";
        for (int i = 0; i < array.length-1; i++) {
            if (array[i] == array[i + 1]) {
                count++;
            } else {
                res = res + array[i] + count;
                count = 1;
            }
            if (i == array.length - 2) res = res + array[i] + count;
        }
        System.out.println(res);
    }
}
