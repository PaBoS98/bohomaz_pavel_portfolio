package com.from10_to100;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int number = 0;
        while (true) {
            System.out.println("Write number");
            number = scanner.nextInt();
            if (number >= 100) {
                break;
            }
            if (number > 11 && number < 100) {
                numbers.add(number);
            }
        }
        System.out.println(numbers);
    }
}
