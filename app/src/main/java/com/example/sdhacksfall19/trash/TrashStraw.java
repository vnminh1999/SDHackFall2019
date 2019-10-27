package com.example.sdhacksfall19.trash;

import com.example.sdhacksfall19.board.Board;
import com.example.sdhacksfall19.movement.Coordinate;

import java.util.ArrayList;

public class TrashStraw extends Trash {
    private static final int LIFETIME = 30;
    private boolean moveRight;
    private int currInd;

    public TrashStraw(Board board){
        super(board);
        moveRight = true;
        currInd = 2;

        c = new Coordinate(0,0);

        do {
            c.setX((int)(Math.random() * ((Board.getWIDTH() - 5) + 1)) + 1);
            c.setY((int)(Math.random() * ((Board.getWIDTH() - 2) + 1)) + 1);
        } while(!board.checkIfNothingOrWall(generateRadius(c)));

        cList.add(new Coordinate(c.getX()-2, c.getY()));
        cList.add(new Coordinate(c.getX()-1, c.getY()));
        cList.add(c);
        cList.add(new Coordinate(c.getX()-2, c.getY()));
        cList.add(new Coordinate(c.getX()-1, c.getY()));

    }

    private ArrayList<Coordinate> generateRadius(Coordinate c) {
        ArrayList<Coordinate> radius = new ArrayList<>();

        radius.add(new Coordinate(c.getX()-2, c.getY()-1));
        radius.add(new Coordinate(c.getX()-1, c.getY()-1));
        radius.add(new Coordinate(c.getX(), c.getY()-1));
        radius.add(new Coordinate(c.getX()+1, c.getY()-1));
        radius.add(new Coordinate(c.getX()+2, c.getY()-1));

        radius.add(new Coordinate(c.getX()-2, c.getY()));
        radius.add(new Coordinate(c.getX()-1, c.getY()));
        radius.add(new Coordinate(c.getX(), c.getY()));
        radius.add(new Coordinate(c.getX()+1, c.getY()));
        radius.add(new Coordinate(c.getX()+2, c.getY()));

        radius.add(new Coordinate(c.getX()-2, c.getY()+1));
        radius.add(new Coordinate(c.getX()-1, c.getY()+1));
        radius.add(new Coordinate(c.getX(), c.getY()+1));
        radius.add(new Coordinate(c.getX()+1, c.getY()+1));
        radius.add(new Coordinate(c.getX()+2, c.getY()+1));

        return radius;
    }

    @Override
    public void update() {
        if(moveRight) {
            if(currInd == cList.size()-1) {
                moveRight = false;
                currInd--;
                c = cList.get(currInd);
            } else {
                currInd++;
                c = cList.get(currInd);
            }
        } else {
            if(currInd == 0) {
                moveRight = true;
                currInd++;
                c = cList.get(currInd);
            } else {
                currInd--;
                c = cList.get(currInd);
            }
        }
    }

    @Override
    public int getLifetime() {
        return this.LIFETIME;
    }
}