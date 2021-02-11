package com.calculator;

import java.util.Scanner;

public class CalculatorMain {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String answer;
        boolean isGetOut = false;

        while (!isGetOut) {

            DoOperation doOperation = new DoOperation();
            System.out.println("Хочешь что то еще посчитать даун? \n  " +
                    "Y|N");

            while (true) {
                answer = scanner.nextLine();
                answer = answer.toLowerCase();

                if (answer.equals("y")) {
                    break;
                } else if (answer.equals("n")) {
                    isGetOut = true;
                    System.out.println("беги нахуй дура");
                    break;
                } else {
                    System.out.println("Блять блин дурак ебанный Y или N");
                }
            }
        }
    }
}
