package com.maze_algorithm.service;

import java.util.Scanner;

public class SizeSelection {

    private int length;
    private int height;

    public SizeSelection() {
        sizeSelection();
    }

    public int getLength() {
        return length;
    }

    public int getHeight() {
        return height;
    }

    private void sizeSelection() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Specify the size of the maze\n" +
                " What is the height of the maze (multiple of 1)");
        while (true) {
            if (scanner.hasNextInt()) {
                this.height = scanner.nextInt();
                if (height < 3) {
                    height = 3;
                    System.out.println("Height = " + height);
                    break;
                } else {
                    if (height % 2 != 0) {
                        System.out.println("Height = " + height);
                        break;
                    } else {
                        System.out.println("multiple of 1");
                    }
                }
            }
        }

        System.out.println("What is the length of the maze (multiple of 1 and length <= height)");
        while (true) {
            if (scanner.hasNextInt()) {
                this.length = scanner.nextInt();
                if (length < 3) {
                    length = 3;
                    System.out.println("Length = " + length);
                    break;
                } else {
                    if (length % 2 != 0) {
                        if (length <= height) {
                            System.out.println("Length = " + length);
                            break;
                        } else System.out.println("length <= height");
                    } else {
                        System.out.println("multiple of 1");
                    }
                }
            }
        }
    }
}
