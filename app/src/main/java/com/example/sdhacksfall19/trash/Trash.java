package com.example.sdhacksfall19.trash;

import com.example.sdhacksfall19.board.Board;
import com.example.sdhacksfall19.movement.Coordinate;

public class Trash {
    private Board board;
    Coordinate c;
    Coordinate[] cList;

    public Trash(Board board) {
        this.board = board;
        c = null;
        cList = null;
    }

    public void update() {}
}
