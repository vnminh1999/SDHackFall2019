package com.example.sdhacksfall19.turtles;
import com.example.sdhacksfall19.board.Board;
import com.example.sdhacksfall19.movement.*;

public class StrayTurtle {
    private Board board;
    Coordinate c;

    public StrayTurtle(Board board) {
        this.board = board;
        c = new Coordinate(0,0);

        do {
            c.setX((int)(Math.random() * ((Board.getWIDTH() - 2) + 1)) + 1);
            c.setY((int)(Math.random() * ((Board.getHEIGHT() - 2) + 1)) + 1);
        } while(!board.checkIfNothing(c));
    }

    public Coordinate getC() {
        return c;
    }

    public void setC(Coordinate c) {
        this.c = c;
    }
}
