package com.itarator_listiterator;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
//            list.add(999);
            System.out.println(iterator.next());
        }

        System.out.println("---------------------");
        ListIterator<Integer> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
//            list.add(999);
            listIterator.add(999);
            System.out.println(listIterator.next());
        }

        System.out.println("--------------------");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
