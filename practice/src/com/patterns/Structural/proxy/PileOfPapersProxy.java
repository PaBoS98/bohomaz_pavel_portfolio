package com.patterns.Structural.proxy;

import java.util.List;

public final class PileOfPapersProxy implements PileOfPapers {
    private PileOfPapersReal pileOfPapersReal;
    private final List<String> papers;

    public PileOfPapersProxy(final List<String> papers) {
        this.papers = papers;
        System.out.println("Документы рядом на столе и ждут своей участи");
    }

    @Override
    public void signing() {
        if (!checkAccess()) {
            this.pileOfPapersReal = new PileOfPapersReal(papers);
        }
        this.pileOfPapersReal.signing();
    }

    private boolean checkAccess(){
        if (this.pileOfPapersReal != null) return true;
        return false;
    }

}
