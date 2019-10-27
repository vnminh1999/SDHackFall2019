package com.example.sdhacksfall19.trash;

import com.example.sdhacksfall19.board.Board;
import com.example.sdhacksfall19.movement.Coordinate;

public class TrashBottle extends Trash {
    public TrashBottle(Board board){
        super(board);

        c = new Coordinate(0,0);

        do {
            c.setX((int)(Math.random() * ((Board.getWIDTH() - 2) + 1)) + 1);
            c.setY((int)(Math.random() * ((Board.getHEIGHT() - 2) + 1)) + 1);
        } while(!board.checkIfNothing(c));

    }

    @Override
    public void update() {}
}