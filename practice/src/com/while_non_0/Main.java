package com.while_non_0;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int sum = 0;
        int temp;

        do {
            temp = scanner.nextInt();
            sum += temp;
        } while (temp != 0);

        System.out.println(sum);

//        while (temp != 0) {
//            temp = scanner.nextInt();
//            sum += temp;
//        }
//
//        System.out.println(sum);

    }
}
