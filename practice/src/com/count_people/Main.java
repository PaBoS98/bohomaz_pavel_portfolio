package com.count_people;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    static int countRoom = 1;

    public static void main(String[] args) {

        System.out.println("Ты порохобот. Твои хозяева написали софт, что бы ты считал людей в комнате. Твоя задача заезжать в комнаты, считать людей и приветствовать их");

        while (true) {
            countPeople();
        }
    }

    public static void countPeople() {

        System.out.println("Ты входишь в " + countRoom + " комнату. Сколько там людей?");

        Scanner scanner = new Scanner(System.in);
        int answer;

        while (true) {
            try {
                answer = scanner.nextInt();
                int a = answer % 10;
                int b = answer % 100;

                if (answer >= 0) {
                    if (a == 1 && b != 11) {
                        System.out.println("В комнате №" + countRoom + " " + answer + " программист!");
                        break;
                    } else if ((a == 2 || a == 3 || a == 4) && (b != 12 && b != 13 && b != 14)) {
                        System.out.println("В комнате №" + countRoom + " " + answer + " программиста!");
                        break;
                    } else {
                        System.out.println("В комнате №" + countRoom + " " + answer + " программистов!");
                        break;
                    }
                } else System.out.println("Ты тупой робот, на ляпас по лицу. Не может быть в помещении меньше нуля");
            } catch (InputMismatchException e) {
                System.out.println("Тупая жестянка, скажи кол-во людей в комнате");
                scanner.nextLine();
            }
        }
        countRoom++;
    }
}
