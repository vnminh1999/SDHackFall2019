package com.example.sdhacksfall19.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;

import com.example.sdhacksfall19.R;
import com.example.sdhacksfall19.alerts.GameDialog;

public class BonusRound extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bonus_round);

        Button toWin = (Button)findViewById(R.id.winButton);
        toWin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToWinPage();
            }
        });
    }

    protected void goToWinPage() {
        Intent linkWin = new Intent(getApplicationContext(), WinPage.class);
        startActivity(linkWin);
        finish();

    }

    public void onBackPressed() {

        GameDialog gameDialog = new GameDialog(this);
        gameDialog.show(getSupportFragmentManager(),"gameDialog");
    }

}
