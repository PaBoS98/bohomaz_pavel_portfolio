package com.matrix_and_word;

import java.util.*;

public class MazeAndWordMain {
    private static String string;
    private static char[] word;
    private static int lengthMatrix;

    public static void main(String[] args) {

        while (true) {
            input();
            if ((lengthMatrix*lengthMatrix) == string.length()) break;
            else System.out.println("invalid square root √(String size)");
        }
        String[][] matrix = new String[lengthMatrix][lengthMatrix];

        int split = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = string.substring(split, split + 1);
                split++;
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("\nOutput the sequence of cells that make up the given word");
        CellSearch.cellSearch(matrix, word);
    }

    private static void input() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Waiting for a String:");
        string = scanner.nextLine();

        System.out.println("Waiting for a word:");
        word = scanner.nextLine().toCharArray();

        lengthMatrix = (int) Math.sqrt(string.length());
    }
}
