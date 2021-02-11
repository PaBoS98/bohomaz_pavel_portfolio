package com.cake;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int d = a * b;
        if (a == b) System.out.println(d = a);
        else if (d % a == 0 && d % b == 0) System.out.println(d);
    }
}
