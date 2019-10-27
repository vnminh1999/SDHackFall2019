package com.example.sdhacksfall19.turtles;

import com.example.sdhacksfall19.enums.Direction;
import com.example.sdhacksfall19.movement.Coordinate;

public class MamaTurtle {
    private Direction dir;
    private Coordinate c;

    public MamaTurtle(Direction dir, Coordinate c) {
        this.dir = dir;
        this.c = c;
    }

    public Direction getDir() {
        return dir;
    }

    public void setDir(Direction dir) {
        this.dir = dir;
    }

    public Coordinate getC() {
        return c;
    }

    public void setC(Coordinate c) {
        this.c = c;
    }
}
