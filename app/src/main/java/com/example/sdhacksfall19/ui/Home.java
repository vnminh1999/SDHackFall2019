package com.example.sdhacksfall19.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.sdhacksfall19.alerts.Facts;
import com.example.sdhacksfall19.R;

import java.util.Timer;
import java.util.TimerTask;


public class Home extends AppCompatActivity {

    public TextView showFact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        Button toStart = (Button)findViewById(R.id.startButton);
        showFact = (TextView)findViewById(R.id.factsTextView);
        final Handler handler = new Handler();

        toStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent linkStart = new Intent(getApplicationContext(), Turtle.class);
                startActivity(linkStart);
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
                            showFact.setText((CharSequence)Facts.generateRandomFact());
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
}
