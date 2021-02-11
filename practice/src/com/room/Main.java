package com.room;

import java.util.Scanner;

public class Main {

    static String figure;
    public static final double PI = 3.14;
    static double a = 3;
    static double b = 4;
    static double c = 5;
    static double p = 0;
    static double r = 0;
    static double s = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("какой фигуры комната? \n " +
                    "Треугольник|Прямоугоьник|Круг");
            figure = scanner.nextLine();
            if (figure.matches("[А-Яа-я]+")) {
                chooseFigure(figure);
            } else {
                System.out.println("Укажи фигуру языком Московии");
                scanner.nextLine();
            }
        }
    }

    public static void chooseFigure(String figure) {
        Scanner scanner = new Scanner(System.in);
        figure = figure.toLowerCase();

        if (figure.equals("треугольник")) {
            System.out.println("Введи 3 стороны");
            a = scanner.nextDouble();
            b = scanner.nextDouble();
            c = scanner.nextDouble();
            p = (a + b + c) / 2;
            s = Math.sqrt(p * (p - a) * (p - b) * (p - c));
            printRes(s);
        } else if (figure.equals("прямоугольник")) {
            System.out.println("Введи 2 стороны");
            a = scanner.nextDouble();
            b = scanner.nextDouble();
            s = a * b;
            printRes(s);
        } else if (figure.equals("круг")) {
            System.out.println("Введи радиус");
            r = scanner.nextDouble();
            s = PI * Math.pow(r, 2);
            printRes(s);
        } else System.out.println("Неправильная фигура");

    }

    public static void printRes(double s) {
        System.out.println("Жиль площадь = " + s);
    }
}
