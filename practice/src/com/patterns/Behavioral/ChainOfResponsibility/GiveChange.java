package com.patterns.Behavioral.ChainOfResponsibility;

public abstract class GiveChange {
    private int possibility;
    private GiveChange nextGiveChange;

    public GiveChange(int possibility) {
        this.possibility = possibility;
    }

    public void setNextGiveChange(GiveChange nextGiveChange) {
        this.nextGiveChange = nextGiveChange;
    }

    public void giveChange(int lvl) {
        if (lvl >= possibility) say();
        if (nextGiveChange !=null) {
            if (lvl > possibility) System.out.println("ну тут мои полнамочия ВСЁ! ЗЗИИИИИНААА --->\n");
            nextGiveChange.giveChange(lvl);
        }
    }

    public abstract void say();
}
