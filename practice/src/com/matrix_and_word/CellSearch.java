package com.matrix_and_word;

import java.util.Date;

public class CellSearch {
    public static void cellSearch(String[][] matrix, char[] word) {
        Date timeStart = new Date();
        boolean getOut = false;
        int i = 0;
        while (!getOut) {
            for (int j = 0; j < matrix.length; j++) {
                if (getOut) break;
                for (int k = 0; k < matrix.length; k++) {
                    if (getOut) break;
                    if (matrix[j][k].equals(String.valueOf(word[i]))) {
                        System.out.format("[%s, %s]", j, k);
                        if (i < word.length - 1) {
                            System.out.print(" -> ");
                        }
                        if (i == word.length - 1) getOut = true;
                        i++;
                    }
                }
            }
        }
        Date timeFinish = new Date();
        System.out.println("\nalgorithm running time - " + (timeFinish.getTime() - timeStart.getTime()) + "s");
    }
}
