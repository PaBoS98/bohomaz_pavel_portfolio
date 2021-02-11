package com.multiples3;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int count = 0;
        double middle = 0;

        for (int i = a; i <= b; i++) {

            if (i % 3 == 0) {
                middle += i;
                count++;
            }
        }
        middle = middle / count;
        System.out.println(middle);

    }
}
