package com.example.milstein.tictactoe;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnInstructions;
    private Button btnStart;
   // private GameBoard board;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInstructions = findViewById(R.id.btnInsructionsID);
        btnStart = findViewById(R.id.btnStartID);

        btnInstructions.setOnClickListener(this);
        btnStart.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.btnInsructionsID) {
            Intent in = new Intent(this, InstructionsActivity.class);
            startActivity(in);
        }
        else {
            Intent in = new Intent(this, GameActivity.class);
            startActivity(in);
        }
    }

}