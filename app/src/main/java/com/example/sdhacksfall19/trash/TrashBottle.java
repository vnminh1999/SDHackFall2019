package com.example.sdhacksfall19.trash;

import com.example.sdhacksfall19.board.Board;
import com.example.sdhacksfall19.movement.Coordinate;

import java.util.ArrayList;

public class TrashBottle extends Trash {
    private static final int LIFETIME = 10;

    public TrashBottle(Board board){
        super(board);

        c = new Coordinate(0,0);

        do {
            c.setX((int)(Math.random() * ((Board.getWIDTH() - 2) + 1)) + 1);
            c.setY((int)(Math.random() * ((Board.getWIDTH() - 2) + 1)) + 1);
        } while(!board.checkIfNothingOrWall(generateRadius(c)));

        cList.add(c);

    }

    private ArrayList<Coordinate> generateRadius(Coordinate c) {
        ArrayList<Coordinate> radius = new ArrayList<>();

        radius.add(new Coordinate(c.getX()-1, c.getY()-1));
        radius.add(new Coordinate(c.getX(), c.getY()-1));
        radius.add(new Coordinate(c.getX()+1, c.getY()-1));
        radius.add(new Coordinate(c.getX()-1, c.getY()));
        radius.add(new Coordinate(c.getX(), c.getY()));
        radius.add(new Coordinate(c.getX()+1, c.getY()));
        radius.add(new Coordinate(c.getX()-1, c.getY()+1));
        radius.add(new Coordinate(c.getX(), c.getY()+1));
        radius.add(new Coordinate(c.getX()+1, c.getY()+1));

        return radius;
    }

    @Override
    public void update() {}

    @Override
    public int getLifetime() {
        return this.LIFETIME;
    }
}