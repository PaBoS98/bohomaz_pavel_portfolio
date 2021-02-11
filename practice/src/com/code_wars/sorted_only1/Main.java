package com.code_wars.sorted_only1;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] array = {};
        System.out.println(Arrays.toString(Kata.sortArray(array)));

    }
}

class Kata {
    public static int[] sortArray(int[] array) {
        int temp;
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                for (int j = i + 1; j < array.length; j++) {
                    if (array[i] % 2 != 0 && array[j] % 2 != 0) {
                        if (array[i] > array[j]) {
                            isSorted = false;
                            temp = array[i];
                            array[i] = array[j];
                            array[j] = temp;
                        }
                    }
                }
            }
        }
        return array;
    }
}
