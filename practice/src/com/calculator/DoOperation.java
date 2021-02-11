package com.calculator;

import java.util.Scanner;

public class DoOperation {

    Scanner scanner = new Scanner(System.in);
    int firstNum;
    int secondNum;
    String operationSign;
    double res;

    public DoOperation() {

        System.out.println("Шо падаль, что ты хочешь посчитать даун? \n " +
                "Введи первое число - нажми ENTER \n " +
                "Введи второе число - нажми ENTER \n " +
                "Введи знак операции (+, -, /, *, mod, pow, div - нажми ENTER \n");

        boolean isGetOut = false;

        while (!isGetOut) {
            System.out.println("Первое число");

            while (true) {
                if (scanner.hasNextInt()) {
                    firstNum = scanner.nextInt();
                    break;
                } else {
                    System.out.println("Дурак блин блять, число введи даун");
                    scanner.next();
                }
            }

            System.out.println("Второе число");
            while (true) {
                if (scanner.hasNextInt()) {
                    secondNum = scanner.nextInt();
                    break;
                } else {
                    System.out.println("Дурак блин блять, число введи даун");
                    scanner.next();
                }
            }

            System.out.println("Знак операции");
            scanner.nextLine();
            String temp = scanner.nextLine();
            while (true) {

                if (temp.equals("+")) {
                    operationSign = temp;
                    System.out.println(firstNum + " " + operationSign + " " + secondNum);
                    res = firstNum + secondNum;
                    System.out.println("Ой та какой тебе там результат смотреть иди нахуй даун \n" + res);
                    isGetOut = true;
                    break;
                } else if (temp.equals("-")) {
                    operationSign = temp;
                    System.out.println(firstNum + " " + operationSign + " " + secondNum);
                    res = firstNum - secondNum;
                    System.out.println("Ой та какой тебе там результат смотреть иди нахуй даун \n" + res);
                    isGetOut = true;
                    break;
                } else if (temp.equals("/")) {
                    operationSign = temp;
                    System.out.println(firstNum + " " + operationSign + " " + secondNum);
                    if (secondNum != 0) {
                        res = (double) firstNum / secondNum;
                        System.out.println("Ой та какой тебе там результат смотреть иди нахуй даун \n" + res);
                        isGetOut = true;
                    } else
                        System.out.println("ДАУН СУКА НА 0! ДЕЛИТЬ НЕЛЬЗЯ УЕБОК, ПЕРЕДЕЛЫВАЙ");
                    break;
                } else if (temp.equals("*")) {
                    operationSign = temp;
                    System.out.println(firstNum + " " + operationSign + " " + secondNum);
                    res = firstNum * secondNum;
                    System.out.println("Ой та какой тебе там результат смотреть иди нахуй даун \n" + res);
                    isGetOut = true;
                    break;
                } else if (temp.equals("mod")) {
                    operationSign = temp;
                    System.out.println(firstNum + " " + operationSign + " " + secondNum);
                    try {
                        res = firstNum % secondNum;
                        System.out.println("Ой та какой тебе там результат смотреть иди нахуй даун \n" + res);
                        isGetOut = true;
                    } catch (ArithmeticException e) {
                        System.out.println("ДАУН СУКА НА 0! ДЕЛИТЬ НЕЛЬЗЯ УЕБОК, ПЕРЕДЕЛЫВАЙ");
                    }
                    break;
                } else if (temp.equals("pow")) {
                    operationSign = temp;
                    System.out.println(firstNum + " " + operationSign + " " + secondNum);
                    res = Math.pow(firstNum, secondNum);
                    System.out.println("Ой та какой тебе там результат смотреть иди нахуй даун \n" + res);
                    isGetOut = true;
                    break;
                } else if (temp.equals("div")) {
                    operationSign = temp;
                    System.out.println(firstNum + " " + operationSign + " " + secondNum);
                    try {
                        res = firstNum / secondNum;
                        System.out.println("Ой та какой тебе там результат смотреть иди нахуй даун \n" + res);
                        isGetOut = true;
                    } catch (ArithmeticException e) {
                        System.out.println("ДАУН СУКА НА 0! ДЕЛИТЬ НЕЛЬЗЯ УЕБОК, ПЕРЕДЕЛЫВАЙ");
                    }
                    break;
                } else {
                    System.out.println("Дурак блин блять, операцию введи даун");
                    temp = scanner.nextLine();
                }
            }
        }
    }
}
