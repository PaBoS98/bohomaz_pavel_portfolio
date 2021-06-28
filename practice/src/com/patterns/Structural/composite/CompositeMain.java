package com.patterns.Structural.composite;

import java.io.File;
import java.util.Objects;

public class CompositeMain {
    private static final String PREF = "--";

    private static Directory dir;

    public static void main(String[] args) {

        String rootDir = "D:\\Pasha\\IdeaProjects\\bohomaz_pavel_portfolio\\practice";
        File f = new File(rootDir);
        dir = new Directory(f.getName(), "");

        for (File s : Objects.requireNonNull(f.listFiles())){
            fullComposite(s, "", dir);
        }

        dir.open();
    }

    private static void fullComposite(File file, String prefix, Directory dir){
        if (file.isFile()) {
            dir.addElement(new FileElement(file.getName(), prefix));
        } else {
            Directory directory = new Directory(file.getName(), prefix);
            dir.addElement(directory);
            for (File f : Objects.requireNonNull(file.listFiles())){
                fullComposite(f, prefix + PREF, directory);
            }
        }
    }
}
