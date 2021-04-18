package com.t1d30p30d1;

public class Main {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1, j = 30; i <= 30; i++, j--) {
            System.out.println(i+"/"+j);
            sum += i/j;
        }
        System.out.println(sum);
    }
}
