package com.company;

public class Mark {

    protected boolean isNull = false;

    protected char c = '-';

    public Mark(char c) {
        this.c = c;
    }

    public Mark() {
        this.isNull = true;
    }

    public boolean isNull() {
        return this.isNull;
    }

    public char getChar() {
        return this.c;
    }

}
