package com.example.macstudent.parkingticket;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import de.keyboardsurfer.android.widget.crouton.Crouton;
import de.keyboardsurfer.android.widget.crouton.Style;

public class HelpActivity extends AppCompatActivity {

    Button btnShowAlert;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        btnShowAlert = findViewById(R.id.btnShowHelp);
        btnShowAlert.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(HelpActivity.this);
                alertDialogBuilder.setTitle("Help");
                alertDialogBuilder.setMessage("Email: help@carservice.com  Phone:(333) 777 7777");
                alertDialogBuilder.setCancelable(false);
                alertDialogBuilder.setIcon(android.R.drawable.ic_dialog_alert);
                alertDialogBuilder.setPositiveButton("DISCARD", new DialogInterface.OnClickListener()
                {
                    public void onClick(DialogInterface dialog, int which)
                    {
                        // continue with discard
                        Crouton.showText(HelpActivity.this, "Success", Style.ALERT);
                        //Toast.makeText(MainActivity.this, "Discard", Toast.LENGTH_SHORT).show();
                    }
                });
                
                alertDialogBuilder.show();

            }
        });
    }



}
