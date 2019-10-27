package com.example.sdhacksfall19.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.sdhacksfall19.alerts.GameDialog;
import com.example.sdhacksfall19.views.TurtleView;

import java.util.Timer;
import java.util.TimerTask;

public class Turtle extends AppCompatActivity {
    private TurtleView gameView;
    private Handler handler = new Handler();
    private final static long Interval = 500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gameView = new TurtleView(this);
        setContentView(gameView);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        gameView.invalidate();
                        if(gameView.getBoard().isLost() || gameView.getBoard().isWon()){
                            Thread.currentThread().interrupt();}

                    }
                });



                if(gameView.getBoard().isLost()){
                    goToLosePage();
                    this.cancel();

                } else if(gameView.getBoard().isWon()) {
                    goToWinPage();
                    this.cancel();
                }
            }
        },0,Interval);



    }



    protected void goToLosePage() {

        Intent linkLose = new Intent(getApplicationContext(), LosePage.class);
        startActivity(linkLose);
        finish();
    }

    protected void goToWinPage() {
        Intent linkWin = new Intent(getApplicationContext(), WinPage.class);
        startActivity(linkWin);
        finish();
    }

    @Override
    public void onBackPressed() {

        GameDialog gameDialog = new GameDialog(this);
        gameDialog.show(getSupportFragmentManager(),"gameDialog");
    }

}
