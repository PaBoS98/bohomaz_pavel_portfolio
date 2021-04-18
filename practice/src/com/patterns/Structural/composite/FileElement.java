package com.patterns.Structural.composite;

public class FileElement implements Element{
    private static final String FILE = "[F] : ";

    private String nameFile;
    private String prefix;

    public FileElement(String nameFile, String prefix) {
        this.nameFile = nameFile;
        this.prefix = prefix;
    }

    @Override
    public void open() {
        System.out.println(prefix + FILE.concat(nameFile));
    }
}
