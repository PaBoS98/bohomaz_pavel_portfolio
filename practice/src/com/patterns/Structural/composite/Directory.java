package com.patterns.Structural.composite;

import java.util.ArrayList;
import java.util.List;

public class Directory implements Element{
    private static final String DIR = "[D] : ";

    private String nameDir;
    private String prefix;
    private List<Element> elements = new ArrayList<>();

    public Directory(String nameDir, String prefix) {
        this.nameDir = nameDir;
        this.prefix = prefix;
    }

    public void addElement(Element element) {
        elements.add(element);
    }

    public void removeElement(Element element) {
        elements.remove(element);
    }

    @Override
    public void open() {
        System.out.println(prefix + DIR.concat(nameDir));
        elements.forEach(e -> e.open());
    }
}
