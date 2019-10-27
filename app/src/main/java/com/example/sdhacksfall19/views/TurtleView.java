package com.example.sdhacksfall19.views;

import android.content.Context;
import android.graphics.*;
import android.view.*;

import com.example.sdhacksfall19.R;
import com.example.sdhacksfall19.board.Board;

public class TurtleView extends View  {
    // game board
    private Board board;

    private Bitmap backgroundImg;
    private Bitmap[] mamaTurtleImg = new Bitmap[4];
    private Bitmap[] babyTurtleImg = new Bitmap[4];
    private Bitmap strayTurtleImg;
    private Bitmap[] trashImg = new Bitmap[5];
    private Bitmap nothingImg;

    private int blockSize;

    public Paint paint;
    public Paint scorePaint;

    public TurtleView(Context context){
        super(context);

        setupImg();

        board = new Board();

        // map
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        paint.setDither(true);

        // score
        scorePaint.setColor(Color.WHITE);
        scorePaint.setTextSize(69);
        scorePaint.setTypeface(Typeface.DEFAULT);
        scorePaint.setAntiAlias(true);
        scorePaint.setShadowLayer(8,0,0,Color.BLACK);
    }

    private void drawBoard(Canvas canvas) {
        for(int x = 0; x < Board.getWIDTH(); x++) {
            for(int y = 0; y < Board.getHEIGHT(); y++) {
                switch(board.getBoard()[y][x]) {
                    case MamaTurtleUp:
                        canvas.drawBitmap(mamaTurtleImg[0], x*blockSize,
                                y*blockSize, paint);
                        break;
                    case MamaTurtleDown:
                        canvas.drawBitmap(mamaTurtleImg[1], x*blockSize,
                                y*blockSize, paint);
                        break;
                    case MamaTurtleLeft:
                        canvas.drawBitmap(mamaTurtleImg[2], x*blockSize,
                                y*blockSize, paint);
                        break;
                    case MamaTurtleRight:
                        canvas.drawBitmap(mamaTurtleImg[3], x*blockSize,
                                y*blockSize, paint);
                        break;
                    case MamaTurtleShield:
                        canvas.drawBitmap(nothingImg, x*blockSize,
                                y*blockSize, paint);
                        break;
                    case BabyTurtleUp:
                        canvas.drawBitmap(babyTurtleImg[0], x*blockSize,
                                y*blockSize, paint);
                        break;
                    case BabyTurtleDown:
                        canvas.drawBitmap(babyTurtleImg[1], x*blockSize,
                                y*blockSize, paint);
                        break;
                    case BabyTurtleLeft:
                        canvas.drawBitmap(babyTurtleImg[2], x*blockSize,
                                y*blockSize, paint);
                        break;
                    case BabyTurtleRight:
                        canvas.drawBitmap(babyTurtleImg[3], x*blockSize,
                                y*blockSize, paint);
                        break;
                    case StrayTurtle:
                        canvas.drawBitmap(strayTurtleImg, x*blockSize,
                                y*blockSize, paint);
                        break;
                    case Nothing:
                        canvas.drawBitmap(nothingImg, x*blockSize,
                                y*blockSize, paint);
                        break;
                    case TrashBottle:
                        canvas.drawBitmap(trashImg[0], x*blockSize,
                                y*blockSize, paint);
                        break;
                    case TrashBag:
                        canvas.drawBitmap(trashImg[1], x*blockSize,
                                y*blockSize, paint);
                        break;
                    case TrashStraw:
                        canvas.drawBitmap(trashImg[2], x*blockSize,
                                y*blockSize, paint);
                        break;
                    case TrashCan:
                        canvas.drawBitmap(trashImg[3], x*blockSize,
                                y*blockSize, paint);
                        break;
                    case TrashWall:
                        canvas.drawBitmap(trashImg[4], x*blockSize,
                                y*blockSize, paint);
                        break;
                    case Exit:
                        canvas.drawBitmap(nothingImg, x*blockSize,
                                y*blockSize, paint);
                        break;
                }
            }
        }
    }

    private void drawScore(Canvas canvas) {
        canvas.drawText("Turtles saved: " + board.getNumTurtlesSaved() + "/" +
                Board.getMaxTurtles(), blockSize*(Board.getHEIGHT()+1), blockSize,
                scorePaint);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        blockSize = canvas.getWidth()/Board.getWIDTH();

        board.updateBoard();

        rescaleImg(canvas);
        canvas.drawBitmap(backgroundImg, 0, 0, paint);

        // draw board
        drawBoard(canvas);

        // draw score
        drawScore(canvas);
    }

    private void setupImg () {
        backgroundImg = BitmapFactory.decodeResource(getResources(), R.drawable.background);
        strayTurtleImg = BitmapFactory.decodeResource(getResources(), R.drawable.baby_turtle_stray);
        nothingImg = BitmapFactory.decodeResource(getResources(), R.drawable.nothing);

        mamaTurtleImg[0] = BitmapFactory.decodeResource(getResources(), R.drawable.mama_turtle_up);
        mamaTurtleImg[1] = BitmapFactory.decodeResource(getResources(), R.drawable.mama_turtle_down);
        mamaTurtleImg[2] = BitmapFactory.decodeResource(getResources(), R.drawable.mama_turtle_left);
        mamaTurtleImg[3] = BitmapFactory.decodeResource(getResources(), R.drawable.mama_turtle_right);

        mamaTurtleImg[0] = BitmapFactory.decodeResource(getResources(), R.drawable.mama_turtle_up);
        mamaTurtleImg[1] = BitmapFactory.decodeResource(getResources(), R.drawable.mama_turtle_down);
        mamaTurtleImg[2] = BitmapFactory.decodeResource(getResources(), R.drawable.mama_turtle_left);
        mamaTurtleImg[3] = BitmapFactory.decodeResource(getResources(), R.drawable.mama_turtle_right);

        babyTurtleImg[0] = BitmapFactory.decodeResource(getResources(), R.drawable.baby_turtle_up);
        babyTurtleImg[1] = BitmapFactory.decodeResource(getResources(), R.drawable.baby_turtle_down);
        babyTurtleImg[2] = BitmapFactory.decodeResource(getResources(), R.drawable.baby_turtle_left);
        babyTurtleImg[3] = BitmapFactory.decodeResource(getResources(), R.drawable.baby_turtle_right);

        trashImg[0] = BitmapFactory.decodeResource(getResources(), R.drawable.trash_bottle);
        trashImg[1] = BitmapFactory.decodeResource(getResources(), R.drawable.trash_bag);
        trashImg[2] = BitmapFactory.decodeResource(getResources(), R.drawable.trash_straw);
        trashImg[3] = BitmapFactory.decodeResource(getResources(), R.drawable.trash_can);
        trashImg[4] = BitmapFactory.decodeResource(getResources(), R.drawable.trash_wall);
    }

    private void rescaleImg (Canvas canvas) {
        backgroundImg = Bitmap.createScaledBitmap(backgroundImg, canvas.getWidth(),
                canvas.getHeight(), true);
        strayTurtleImg = Bitmap.createScaledBitmap(strayTurtleImg,
                canvas.getWidth()/Board.getWIDTH(),
                canvas.getHeight()/Board.getHEIGHT(), true);
        nothingImg = Bitmap.createScaledBitmap(nothingImg,
                canvas.getWidth()/Board.getWIDTH(),
                canvas.getHeight()/Board.getHEIGHT(), true);

        mamaTurtleImg[0] = Bitmap.createScaledBitmap(mamaTurtleImg[0],
                canvas.getWidth()/Board.getWIDTH(),
                canvas.getHeight()/Board.getHEIGHT(), true);
        mamaTurtleImg[1] = Bitmap.createScaledBitmap(mamaTurtleImg[1],
                canvas.getWidth()/Board.getWIDTH(),
                canvas.getHeight()/Board.getHEIGHT(), true);
        mamaTurtleImg[2] = Bitmap.createScaledBitmap(mamaTurtleImg[2],
                canvas.getWidth()/Board.getWIDTH(),
                canvas.getHeight()/Board.getHEIGHT(), true);
        mamaTurtleImg[3] = Bitmap.createScaledBitmap(mamaTurtleImg[3],
                canvas.getWidth()/Board.getWIDTH(),
                canvas.getHeight()/Board.getHEIGHT(), true);

        babyTurtleImg[0] = Bitmap.createScaledBitmap(babyTurtleImg[0],
                canvas.getWidth()/Board.getWIDTH(),
                canvas.getHeight()/Board.getHEIGHT(), true);
        babyTurtleImg[1] = Bitmap.createScaledBitmap(babyTurtleImg[1],
                canvas.getWidth()/Board.getWIDTH(),
                canvas.getHeight()/Board.getHEIGHT(), true);
        babyTurtleImg[2] = Bitmap.createScaledBitmap(babyTurtleImg[2],
                canvas.getWidth()/Board.getWIDTH(),
                canvas.getHeight()/Board.getHEIGHT(), true);
        babyTurtleImg[3] = Bitmap.createScaledBitmap(babyTurtleImg[3],
                canvas.getWidth()/Board.getWIDTH(),
                canvas.getHeight()/Board.getHEIGHT(), true);

        trashImg[0] = Bitmap.createScaledBitmap(trashImg[0],
                canvas.getWidth()/Board.getWIDTH(),
                canvas.getHeight()/Board.getHEIGHT(), true);
        trashImg[1] = Bitmap.createScaledBitmap(trashImg[1],
                canvas.getWidth()/Board.getWIDTH(),
                canvas.getHeight()/Board.getHEIGHT(), true);
        trashImg[2] = Bitmap.createScaledBitmap(trashImg[2],
                canvas.getWidth()/Board.getWIDTH(),
                canvas.getHeight()/Board.getHEIGHT(), true);
        trashImg[3] = Bitmap.createScaledBitmap(trashImg[3],
                canvas.getWidth()/Board.getWIDTH(),
                canvas.getHeight()/Board.getHEIGHT(), true);
        trashImg[4] = Bitmap.createScaledBitmap(trashImg[4],
                canvas.getWidth()/Board.getWIDTH(),
                canvas.getHeight()/Board.getHEIGHT(), true);
    }
}
