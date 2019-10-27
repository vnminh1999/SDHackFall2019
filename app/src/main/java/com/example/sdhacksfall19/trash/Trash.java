package com.example.sdhacksfall19.trash;

import com.example.sdhacksfall19.board.Board;
import com.example.sdhacksfall19.enums.Tiles;
import com.example.sdhacksfall19.movement.Coordinate;

import java.util.ArrayList;

public class Trash {
    private Board board;
    private Tiles type;

    private Coordinate c;

    public Trash(Board board){
        this.board = board;
        c = new Coordinate(0,0);

        double random = Math.random();
        if(random < 0.25)
            type = Tiles.TrashBag;
        else if(0.25 <= random && random < 0.5)
            type = Tiles.TrashBottle;
        else if(0.5 <= random && random < 0.75)
            type = Tiles.TrashCan;
        else
            type = Tiles.TrashStraw;

        do {
            c.setX((int)(Math.random() * ((Board.getWIDTH() - 2) + 1)) + 1);
            c.setY((int)(Math.random() * ((Board.getWIDTH() - 2) + 1)) + 1);
        } while(!board.checkIfNothingOrWall(generateRadius(c)));
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

    public Coordinate getC() {
        return c;
    }

    public Tiles getType() {
        return type;
    }
}