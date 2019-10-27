package com.example.sdhacksfall19.movement;

public class Coordinate {
    private int x;
    private int y;

    public Coordinate(int x, int y) {
        this.setX(x);
        this.setY(y);
    }

    @Override
    public boolean equals(Object other) {
        return this.getX() == ((Coordinate)other).getX() &&
                this.getY() == ((Coordinate)other).getY();
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
