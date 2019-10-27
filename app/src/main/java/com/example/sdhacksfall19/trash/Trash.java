package com.example.sdhacksfall19.trash;

import com.example.sdhacksfall19.board.Board;
import com.example.sdhacksfall19.movement.Coordinate;

import java.util.ArrayList;

public class Trash {
    private Board board;

    private static final int LIFETIME = 10;

    public Coordinate c;
    public ArrayList<Coordinate> cList;

    public Trash(Board board) {
        this.board = board;
        c = null;
        cList = new ArrayList<>();
    }

    public void update() {}

    public int getLifetime() {
        return LIFETIME;
    }
}
