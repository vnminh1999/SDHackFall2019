package com.example.sdhacksfall19.turtles;

import com.example.sdhacksfall19.board.Board;
import com.example.sdhacksfall19.enums.Direction;
import com.example.sdhacksfall19.movement.Coordinate;

import java.util.ArrayList;

public class TurtleTrail {
    private Direction currDir;
    private MamaTurtle mama;
    private ArrayList<BabyTurtle> children = new ArrayList<>();

    public TurtleTrail() {
        Coordinate center = new Coordinate(Board.getWIDTH()/2-1, Board.getHEIGHT()/2-1);
        currDir = Direction.Right;
        mama =  new MamaTurtle(currDir, center);
    }

    public void update() {
        for(int i = children.size() - 1; i > 0; i--) {
            children.get(i).getC().setX(children.get(i-1).getC().getX());
            children.get(i).getC().setY(children.get(i-1).getC().getY());
            children.get(i).setDir(children.get(i-1).getDir());
        }

        if(children.size() > 0) {
            children.get(0).getC().setX(mama.getC().getX());
            children.get(0).getC().setY(mama.getC().getY());
            children.get(0).setDir(mama.getDir());
        }

        switch(currDir) {
            case Up :
                mama.getC().setY(mama.getC().getY() - 1);
                mama.setDir(Direction.Up);
                break;

            case Down:
                mama.getC().setY(mama.getC().getY() + 1);
                mama.setDir(Direction.Down);
                break;

            case Right:
                mama.getC().setX(mama.getC().getX() + 1);
                mama.setDir(Direction.Right);
                break;

            case Left:
                mama.getC().setX(mama.getC().getX() - 1);
                mama.setDir(Direction.Left);
                break;
        }
    }

    public Direction getCurrDir() {
        return currDir;
    }

    public void setCurrDir(Direction currDir) {
        this.currDir = currDir;
    }

    public MamaTurtle getMama() {
        return mama;
    }

    public void setMama(MamaTurtle mama) {
        this.mama = mama;
    }

    public ArrayList<BabyTurtle> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<BabyTurtle> children) {
        this.children = children;
    }
}
