package com.example.sdhacksfall19.alerts;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.example.sdhacksfall19.ui.Home;

public class GameDialog extends AppCompatDialogFragment {

    Activity page;

    public GameDialog(Activity parameter){
        super();
        page = parameter;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Options:")
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                        }
                    })
                    .setPositiveButton("Home", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent linkHome = new Intent(page.getApplicationContext(), Home.class);
                            startActivity(linkHome);
                            page.finish();
                        }
                    });


        return builder.create();
    }
}
