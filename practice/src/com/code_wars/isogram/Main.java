package com.code_wars.isogram;

public class Main {

    public static void main(String[] args) {

        String get = "Dermatoglyphics";
        boolean res = Isogram.isIsogram(get);
        System.out.println(res);

        get = "aba";
        res = Isogram.isIsogram(get);
        System.out.println(res);

        get = "moOse";
        res = Isogram.isIsogram(get);
        System.out.println(res);

        get = "abcdefg";
        res = Isogram.isIsogram(get);
        System.out.println(res);

        get = "abcdefge";
        res = Isogram.isIsogram(get);
        System.out.println(res);
    }
}

class Isogram {
    public static boolean isIsogram(String str) {

        str = str.toLowerCase();

        char[] array = str.toCharArray();
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
