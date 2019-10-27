package com.example.sdhacksfall19;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;

import com.example.sdhacksfall19.views.TurtleView;

public class MainActivity extends AppCompatActivity {
    private TurtleView gameView;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gameView = new TurtleView(this);
        setContentView(gameView);

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
    }
}
