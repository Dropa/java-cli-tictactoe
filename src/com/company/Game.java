package com.company;

import java.util.Scanner;

public class Game {

    protected Scanner input;

    protected Board board;

    protected Player[] players;

    public Game() {
        this.input = new Scanner(System.in);
        this.init();
    }

    public void init() {
        int x, y, m;
        x = this.askInt("Grid X axis size?: ");
        y = this.askInt("Grid Y axis size?: ");
        do {
            m = this.askInt("How many is required in row?: ");
        } while (m > x || m > y);
        this.board = new Board(x, y, m);

        this.players = new Player[2];
        this.players[0] = new Player('x');
        this.players[1] = new Player('o');
    }

    public void run() {
        while (this.tick()) {};
    }

    public boolean tick() {
        for (Player player: players) {
            if (this.makeMove(player)) {
                this.board.print();
                System.out.println(player.getMark().getChar() + " wins!");
                return false;
            }
            else if (!this.board.validMovesLeft()) {
                this.board.print();
                System.out.println("It's a tie!");
                return false;
            }
        }
        return true;
    }

    public boolean makeMove(Player player) {
        int x, y;
        while (true) {
            this.board.print();
            System.out.println("(" + player.getMark().getChar() + ") Insert coordinates, whitespace separated: ");
            x = getNextInt();
            y = getNextInt();
            if (this.board.isValidMove(x, y)) {
                return this.board.doMove(x, y, player.getMark());
            }
        }
    }

    public int getNextInt() {
        while (true) {
            while (this.input.hasNext()) {
                if (this.input.hasNextInt()) {
                    return this.input.nextInt();
                }
                else {
                    this.input.next();
                }
            }
        }
    }

    public int askInt(String question) {
        System.out.print(question);
        return getNextInt();
    }

}
