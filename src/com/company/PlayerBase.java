package com.company;

abstract class PlayerBase {

    protected Mark m;

    public PlayerBase(char c) {
        this.m = new Mark(c);
    }

    public Mark getMark() {
        return this.m;
    }

}
