package com.patterns.Structural.proxy;

import java.util.ArrayList;
import java.util.List;

public final class PileOfPapersReal implements PileOfPapers{
    private List<String> papers = new ArrayList<>();

    public PileOfPapersReal(List<String> papers) {
        this.papers = papers;
        System.out.println("Документы готовы к подписанию");
    }

    @Override
    public void signing() {
        papers.forEach(s -> System.out.println("Подписанно ( " + s + " )"));
    }
}
