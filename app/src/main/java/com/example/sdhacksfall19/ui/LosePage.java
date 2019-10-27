package com.example.sdhacksfall19.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import com.example.sdhacksfall19.R;
import com.example.sdhacksfall19.alerts.Facts;

import java.util.Timer;
import java.util.TimerTask;


public class LosePage extends AppCompatActivity {

    public TextView showFact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lose_page);

        Button toRestart = (Button)findViewById(R.id.restartButton);
        Button toHome = (Button)findViewById(R.id.homeButton);
        showFact = (TextView)findViewById(R.id.factsTextView);
        final Handler handler = new Handler();

        toRestart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Intent linkRestart = new Intent(getApplicationContext(), Turtle.class);
                startActivity(linkRestart);
                finish();
            }
        });

        toHome.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                Intent linkHome = new Intent(getApplicationContext(), Home.class);
                startActivity(linkHome);
                finish();
            }
        });

        class FadeTimerTask extends TimerTask {
            int keepShowing = 500, keepFading = 500;
            int iterations = 0;
            int period = keepFading + keepShowing + 512;
            public void run() {
                handler.post(new Runnable() {
                    public void run() {
                        if(iterations%period == 0){
                            showFact.setTextColor(showFact.getTextColors().withAlpha(0));
                            showFact.setText((CharSequence) Facts.generateRandomFact());
                        } else if(iterations%period > 0 && iterations%period < 256){
                            showFact.setTextColor(showFact.getTextColors().withAlpha(iterations%period));
                        } else if(iterations%period > 255 + keepShowing && iterations%period < period - keepFading){
                            showFact.setTextColor(showFact.getTextColors().withAlpha(period-keepFading-1-iterations%period));
                        }
                        iterations = (iterations+1)%period;
                    }
                });
            }
        }


        Timer fadeTimer = new Timer();
        TimerTask task = new FadeTimerTask();
        fadeTimer.schedule(task,2000,10);


    }

    @Override
    public void onBackPressed() {

        Intent linkHome = new Intent(getApplicationContext(),Home.class);
        startActivity(linkHome);
        finish();
    }

}
