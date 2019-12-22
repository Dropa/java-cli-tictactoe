package com.company;

public class Slot {

    protected Mark m;

    public Slot() {
        this.m = new Mark();
    }

    public void setMark(Mark m) {
        this.m = m;
    }

    public Mark getMark() {
        return this.m;
    }
}
