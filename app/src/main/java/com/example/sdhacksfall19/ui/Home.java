package com.example.sdhacksfall19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;


public class Home extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        Button toStart = (Button)findViewById(R.id.startButton);

        toStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent linkStart = new Intent(getApplicationContext(), TurtleGame.class);
                startActivity(linkStart);
                finish();

            }
        });

    }


}
