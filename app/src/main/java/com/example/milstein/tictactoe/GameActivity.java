package com.example.milstein.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class GameActivity extends AppCompatActivity {

    private GameBoard board;
    private char player = 'x';
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
    }

    public void onClick(View v){

        switch (v.getId()) {

            case R.id.btnID1:
                board.setPlayerAt(0,0, this.player);
            case R.id.btnID2:
                board.setPlayerAt(0,1, this.player);
            case R.id.btnID3:
                board.setPlayerAt(0,2, this.player);
            case R.id.btnID4:
                board.setPlayerAt(1,0, this.player);
            case R.id.btnID5:
                board.setPlayerAt(1,1, this.player);
            case R.id.btnID6:
                board.setPlayerAt(1,2, this.player);
            case R.id.btnID7:
                board.setPlayerAt(2,0, this.player);
            case R.id.btnID8:
                board.setPlayerAt(2,1, this.player);
            case R.id.btnID9:
                board.setPlayerAt(2,2, this.player);
        }

        if(player=='x')
            player='o';
        else
            player='x';
    }
}
