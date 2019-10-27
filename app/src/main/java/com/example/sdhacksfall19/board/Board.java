package com.example.sdhacksfall19.board;

import com.example.sdhacksfall19.enums.*;
import com.example.sdhacksfall19.movement.*;
import com.example.sdhacksfall19.turtles.BabyTurtle;
import com.example.sdhacksfall19.turtles.StrayTurtle;
import com.example.sdhacksfall19.turtles.TurtleTrail;

import java.util.ArrayList;

public class Board {
    private static final int WIDTH = 13;
    private static final int HEIGHT = 17;
    private static final int MAX_TURTLES = 20;

    private Tiles[][] board;

    private StrayTurtle strayTurtle;
    private TurtleTrail trail;

    private ArrayList<Coordinate> trashWalls = new ArrayList<>();
    private ArrayList<Coordinate> exitTiles = new ArrayList<>();

    private int numTurtlesSaved;
    private boolean lost;

    /* Constructor: create and initialize items on board
     */
    public Board() {
        board = new Tiles[HEIGHT][WIDTH];
        numTurtlesSaved = -1;
        lost = false;

        // add wall
        addTrashWalls();
        for(Coordinate wall : trashWalls)
            this.board[wall.getY()][wall.getX()] = Tiles.TrashWall;

        trail = new TurtleTrail();
        
        updateBoard();
    }

    /* Add trash walls to initial board */
    private void addTrashWalls() {
        // top wall
        for(int i = 0; i < WIDTH; i++)
            trashWalls.add(new Coordinate(i, 0));

        // bottom wall
        for(int i = 0; i < WIDTH; i++)
            trashWalls.add(new Coordinate(i, HEIGHT-1));

        // left wall
        for(int i = 0; i < HEIGHT; i++)
            trashWalls.add(new Coordinate(0, i));

        // right wall
        for(int i = 0; i < HEIGHT; i++)
            trashWalls.add(new Coordinate(WIDTH-1, i));
    }

    /* Add exit to board */
    private void addExit() {
        exitTiles.add(new Coordinate(WIDTH/2, 0));
        exitTiles.add(new Coordinate(WIDTH/2-1, 0));
    }

    /* Put all items on board via tile types and set board*/
    public void updateBoard() {
        // update trash

        // init to nothing
        initNothing();

        // put trash on board

        // update trail
        trail.update();

        // put trail on board and check for losing/collecting turtle
        // add children turtles
        for(int i = 0; i < trail.getChildren().size(); i++) {
            switch(trail.getChildren().get(i).getDir()) {
                case Up:
                    board[trail.getChildren().get(i).getC().getY()][trail.getChildren().get(i).getC().getX()]
                            = Tiles.BabyTurtleUp;
                    break;

                case Down:
                    board[trail.getChildren().get(i).getC().getY()][trail.getChildren().get(i).getC().getX()]
                            = Tiles.BabyTurtleDown;
                    break;

                case Right:
                    board[trail.getChildren().get(i).getC().getY()][trail.getChildren().get(i).getC().getX()]
                            = Tiles.BabyTurtleRight;
                    break;

                case Left:
                    board[trail.getChildren().get(i).getC().getY()][trail.getChildren().get(i).getC().getX()]
                            = Tiles.BabyTurtleLeft;
                    break;
            }
        }

        // update mama
        if(checkIfNothing(trail.getMama().getC())) {
            trail.getMama().setDir(trail.getCurrDir());
            switch(trail.getMama().getDir()) {
                case Up:
                    board[trail.getMama().getC().getY()][trail.getMama().getC().getX()]
                            = Tiles.MamaTurtleUp;
                    break;

                case Down:
                    board[trail.getMama().getC().getY()][trail.getMama().getC().getX()]
                            = Tiles.MamaTurtleDown;
                    break;

                case Right:
                    board[trail.getMama().getC().getY()][trail.getMama().getC().getX()]
                            = Tiles.MamaTurtleRight;
                    break;

                case Left:
                    board[trail.getMama().getC().getY()][trail.getMama().getC().getX()]
                            = Tiles.MamaTurtleLeft;
                    break;
            }
        } else if(checkIfStray(trail.getMama().getC())) {
            strayTurtle = null;

            // new location
            Coordinate newC = null;
            Direction newDir = Direction.Up;

            switch(trail.getChildren().get(trail.getChildren().size()-1).getDir()) {
                case Up:
                    newC = new Coordinate(trail.getChildren().get(
                            trail.getChildren().size() - 1).getC().getX(), trail.getChildren().get(
                            trail.getChildren().size() - 1).getC().getY() + 1);
                    newDir = Direction.Up;
                    break;

                case Down:
                    newC = new Coordinate(trail.getChildren().get(
                            trail.getChildren().size() - 1).getC().getX(), trail.getChildren().get(
                            trail.getChildren().size() - 1).getC().getY() - 1);
                    newDir = Direction.Down;
                    break;

                case Right:
                    newC = new Coordinate(trail.getChildren().get(
                            trail.getChildren().size() - 1).getC().getX() - 1, trail.getChildren().get(
                            trail.getChildren().size() - 1).getC().getY());
                    newDir = Direction.Right;
                    break;

                case Left:
                    newC = new Coordinate(trail.getChildren().get(
                            trail.getChildren().size() - 1).getC().getX() - 1, trail.getChildren().get(
                            trail.getChildren().size() - 1).getC().getY());
                    newDir = Direction.Right;
                    break;
            }

            trail.getChildren().add(new BabyTurtle(newDir, newC));

            trail.getMama().setDir(trail.getCurrDir());
            switch(trail.getMama().getDir()) {
                case Up:
                    board[trail.getMama().getC().getY()][trail.getMama().getC().getX()]
                            = Tiles.MamaTurtleUp;
                    break;

                case Down:
                    board[trail.getMama().getC().getY()][trail.getMama().getC().getX()]
                            = Tiles.MamaTurtleDown;
                    break;

                case Right:
                    board[trail.getMama().getC().getY()][trail.getMama().getC().getX()]
                            = Tiles.MamaTurtleRight;
                    break;

                case Left:
                    board[trail.getMama().getC().getY()][trail.getMama().getC().getX()]
                            = Tiles.MamaTurtleLeft;
                    break;
            }

        } else {
            trail.getMama().setDir(trail.getCurrDir());
            switch(trail.getMama().getDir()) {
                case Up:
                    board[trail.getMama().getC().getY()][trail.getMama().getC().getX()]
                            = Tiles.MamaTurtleUp;
                    break;

                case Down:
                    board[trail.getMama().getC().getY()][trail.getMama().getC().getX()]
                            = Tiles.MamaTurtleDown;
                    break;

                case Right:
                    board[trail.getMama().getC().getY()][trail.getMama().getC().getX()]
                            = Tiles.MamaTurtleRight;
                    break;

                case Left:
                    board[trail.getMama().getC().getY()][trail.getMama().getC().getX()]
                            = Tiles.MamaTurtleLeft;
                    break;
            }

            this.lost = true;
        }



        // add stray turtle (create new one if old one already collected)
        // if at 99 turtles, add exit
        if(strayTurtle == null) {
            if(numTurtlesSaved < MAX_TURTLES) {
                strayTurtle = new StrayTurtle(this);
                numTurtlesSaved++;
            } else
                addExit();
        }

        // add exit tiles
        for(Coordinate exit : exitTiles)
            this.board[exit.getY()][exit.getX()] = Tiles.Exit;

        // add more trash?

        // add stray turtle tile
        if(strayTurtle != null)
            this.board[strayTurtle.getC().getY()][strayTurtle.getC().getX()]
                    = Tiles.StrayTurtle;
    }

    private void initNothing() {
        for(int x = 1; x < WIDTH-1; x++)
            for(int y = 1; y < HEIGHT-1; y++)
                board[y][x] = Tiles.Nothing;
    }

    public boolean checkIfNothing(Coordinate c) {
        return board[c.getY()][c.getX()] == Tiles.Nothing;
    }

    private boolean checkIfStray(Coordinate c) {
        return board[c.getY()][c.getX()] == Tiles.StrayTurtle;
    }

    /* update board and return it */
    public Tiles[][] getBoard() {
        return board;
    }

    public static int getWIDTH() {
        return WIDTH;
    }

    public static int getMaxTurtles() {
        return MAX_TURTLES;
    }

    public int getNumTurtlesSaved() {
        return numTurtlesSaved;
    }

    public static int getHEIGHT() {
        return HEIGHT;
    }

    public boolean isLost() {
        return lost;
    }


}
