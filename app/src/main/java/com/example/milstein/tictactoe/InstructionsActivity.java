package com.example.milstein.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InstructionsActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnStartGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions);

        btnStartGame = findViewById(R.id.btnStart2ID);
        btnStartGame.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent in = new Intent(this, GameActivity.class);
        startActivity(in);
    }
}
