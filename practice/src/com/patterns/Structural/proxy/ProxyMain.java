package com.patterns.Structural.proxy;

import java.util.ArrayList;
import java.util.List;

public class ProxyMain {
    public static void main(String[] args) {

        List<String> papers = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            papers.add("Document#"+i);
        }

        PileOfPapers pileOfPapers = new PileOfPapersProxy(papers);

//        pileOfPapers.signing();
    }
}
