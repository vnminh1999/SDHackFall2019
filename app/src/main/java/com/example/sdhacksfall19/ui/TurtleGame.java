package com.example.sdhacksfall19.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.example.sdhacksfall19.R;
import com.example.sdhacksfall19.alerts.GameDialog;


public class TurtleGame extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.turtle);

        Button toBonus = findViewById(R.id.bonusButton);
        Button toLose = findViewById(R.id.loseButton);

        toBonus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToBonusPage();
            }
        });

        toLose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToLosePage();
            }
        });

    }

    protected void goToLosePage() {
        Intent linkLose = new Intent(getApplicationContext(), LosePage.class);
        startActivity(linkLose);
        finish();
    }

    protected void goToBonusPage() {
        Intent linkBonus = new Intent(getApplicationContext(), BonusRound.class);
        startActivity(linkBonus);
        finish();
    }

    @Override
    public void onBackPressed() {

        GameDialog gameDialog = new GameDialog(this);
        gameDialog.show(getSupportFragmentManager(),"gameDialog");
    }

}
