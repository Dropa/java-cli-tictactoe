package com.company;

public class Board {

    protected int xSize, ySize, mSize;

    protected Slot[][] grid;

    public Board(int xSize, int ySize, int mSize) {
        this.grid = new Slot[xSize][ySize];
        for (int i = 0; i < xSize; i++) {
            for (int j = 0; j < ySize; j++) {
                this.grid[i][j] = new Slot();
            }
        }
        this.xSize = xSize - 1;
        this.ySize = ySize - 1;
        this.mSize = mSize;
    }

    public void print() {
        for (Slot[] x: this.grid) {
            for (Slot y: x) {
                System.out.print(" " + y.getMark().getChar() + " ");
            }
            System.out.print('\n');
        }
    }

    public boolean validMovesLeft() {
        for (Slot[] x: this.grid) {
            for (Slot y: x) {
                if (y.getMark().isNull()) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isValidMove(int x, int y) {
        if (x < 0 || x > this.xSize || y < 0 || y > this.ySize) {
            return false;
        }
        return this.grid[x][y].getMark().isNull();
    }

    public boolean doMove(int x, int y, Mark m) {
        this.grid[x][y].setMark(m);
        return this.wasWinningMove(x, y, m);
    }

    public boolean wasWinningMove(int x, int y, Mark m) {
        int match;

        // Right
        match = this.mSize;
        for (int i = x; i < this.mSize; i++) {
            if (i > this.xSize) {
                break;
            }
            if (this.grid[i][y].getMark() == m) {
                match--;
            }
            else {
                break;
            }
            if (match == 0) {
                return true;
            }
        }

        // Left
        match = this.mSize;
        for (int i = x; i < this.mSize; i++) {
            if (i < 0) {
                break;
            }
            if (this.grid[i][y].getMark() == m) {
                match--;
            }
            else {
                break;
            }
            if (match == 0) {
                return true;
            }
        }

        // Up
        match = this.mSize;
        for (int i = y; i < this.mSize; i++) {
            if (i > this.ySize) {
                break;
            }
            if (this.grid[x][i].getMark() == m) {
                match--;
            }
            else {
                break;
            }
            if (match == 0) {
                return true;
            }
        }

        // Down
        match = this.mSize;
        for (int i = y; i < this.mSize; i++) {
            if (i < 0) {
                break;
            }
            if (this.grid[x][i].getMark() == m) {
                match--;
            }
            else {
                break;
            }
            if (match == 0) {
                return true;
            }
        }

        // Diagonal up left
        match = this.mSize;
        for (int k = 0; k < this.mSize; k++) {
            int i = x - k;
            int j = y - k;
            if (i < 0 || j < 0) {
                break;
            }
            if (this.grid[i][j].getMark() == m) {
                match--;
            }
            else {
                break;
            }
            if (match == 0) {
                return true;
            }
        }

        // Diagonal up right
        match = this.mSize;
        for (int k = 0; k < this.mSize; k++) {
            int i = x - k;
            int j = y + k;
            if (i < 0 || j > this.ySize) {
                break;
            }
            if (this.grid[i][j].getMark() == m) {
                match--;
            }
            else {
                break;
            }
            if (match == 0) {
                return true;
            }
        }

        // Diagonal down left
        match = this.mSize;
        for (int k = 0; k < this.mSize; k++) {
            int i = x + k;
            int j = y - k;
            if (i > this.xSize || j < 0) {
                break;
            }
            if (this.grid[i][j].getMark() == m) {
                match--;
            }
            else {
                break;
            }
            if (match == 0) {
                return true;
            }
        }

        // Diagonal down right
        match = this.mSize;
        for (int k = 0; k < this.mSize; k++) {
            int i = x + k;
            int j = y + k;
            if (i > this.xSize || j > this.ySize) {
                break;
            }
            if (this.grid[i][j].getMark() == m) {
                match--;
            }
            else {
                break;
            }
            if (match == 0) {
                return true;
            }
        }
        return false;
    }

}
