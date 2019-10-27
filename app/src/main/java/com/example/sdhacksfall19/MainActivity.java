package com.example.sdhacksfall19;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;

import com.example.sdhacksfall19.views.TurtleView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
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
                    }
                });
            }
        },0,Interval);
/*
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(!gameView.getBoard().isLost()) {
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            gameView.invalidate();
                        }
                    }, 2000);
                }
            }
        }).start();
        */
    }
}
