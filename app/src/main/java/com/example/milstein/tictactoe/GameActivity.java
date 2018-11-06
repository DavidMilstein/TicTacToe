package com.example.milstein.tictactoe;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {


    private GameBoard board;
    private String player = "X";
    private Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    private String win="";
    private TextView turn, scoreX, scoreO, scoreDraw;
    //int countX=0, countO=0, countDraw=0;
    private int currentXScore, currentOScore, currentDrawScore;
    private Button restart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        board = new GameBoard();
        btn1= findViewById(R.id.btnID1);
        btn2= findViewById(R.id.btnID2);
        btn3= findViewById(R.id.btnID3);
        btn4= findViewById(R.id.btnID4);
        btn5= findViewById(R.id.btnID5);
        btn6= findViewById(R.id.btnID6);
        btn7= findViewById(R.id.btnID7);
        btn8= findViewById(R.id.btnID8);
        btn9= findViewById(R.id.btnID9);
        restart = findViewById(R.id.btnPlayAgainID);

        turn = findViewById(R.id.turnID);
        scoreX = findViewById(R.id.xScoreID);
        scoreO = findViewById(R.id.oScoreID);
        scoreDraw = findViewById(R.id.drawsID);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        restart.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){

        if(v.getId() == R.id.btnID1) {
            btn1.setText(this.player);
            btn1.setClickable(false);
            board.setPlayerAt(0, 0, this.player);
        }
        else if(v.getId() == R.id.btnID2) {
            btn2.setText(this.player);
            btn2.setClickable(false);
            board.setPlayerAt(0,1, this.player);
        }
        else if(v.getId() == R.id.btnID3) {
            btn3.setText(this.player);
            btn3.setClickable(false);
            board.setPlayerAt(0,2, this.player);
        }
        else if(v.getId() == R.id.btnID4) {
            btn4.setText(this.player);
            btn4.setClickable(false);
            board.setPlayerAt(1,0, this.player);
        }
        else if(v.getId() == R.id.btnID5) {
            btn5.setText(this.player);
            btn5.setClickable(false);
            board.setPlayerAt(1,1, this.player);
        }
        else if(v.getId() == R.id.btnID6) {
            btn6.setText(this.player);
            btn6.setClickable(false);
            board.setPlayerAt(1,2, this.player);
        }
        else if(v.getId() == R.id.btnID7) {
            btn7.setText(this.player);
            btn7.setClickable(false);
            board.setPlayerAt(2,0, this.player);
        }
        else if(v.getId() == R.id.btnID8) {
            btn8.setText(this.player);
            btn8.setClickable(false);
            board.setPlayerAt(2,1, this.player);
        }
        else if(v.getId() == R.id.btnID9) {
            btn9.setText(this.player);
            btn9.setClickable(false);
            board.setPlayerAt(2,2, this.player);
        }

        if(v.getId() == R.id.btnID1 || v.getId() == R.id.btnID2 || v.getId() == R.id.btnID3 || v.getId() == R.id.btnID4 || v.getId() == R.id.btnID5|| v.getId() == R.id.btnID6 || v.getId() == R.id.btnID7 || v.getId() == R.id.btnID8 || v.getId() == R.id.btnID9  ) {// swap player
            if (this.player == "X") {
                this.player = "O";
                turn.setText(player + " turn");
            } else {
                this.player = "X";
                turn.setText(player + " turn");
            }
        }
        //call to the win function
        win = board.isWin();

        //check win or draw
        if (win == "X") {
            currentXScore++;
            scoreX.setText(""+currentXScore);
            turn.setText("X won!");

        }
        if (win == "O") {
            currentOScore++;
            scoreO.setText(""+currentOScore);
            turn.setText("O won!");
        }
        if(win == "d"){
            currentDrawScore++;
            scoreDraw.setText(""+currentDrawScore);
            turn.setText("DRAW!");
        }

        if(v.getId() == R.id.btnPlayAgainID){
            board=new GameBoard();
        }
    }


    //save the score
    @Override
    protected void onResume() {
        super.onResume();

        // read saved data from sheardPrefrences
        // read the results of the games of all app lifecycle
        SharedPreferences sp = getSharedPreferences("MyPref" , Context.MODE_PRIVATE);
        currentXScore = sp.getInt("lastXScore",0);
        currentOScore = sp.getInt("lastOScore",0);
        currentDrawScore = sp.getInt("lastDrawScore",0);

        //Log.d("debug", ">>>>>>>>>> onResume()");
    }

    @Override
    protected void onPause()
    {
        super.onPause();

        // save data (games result) into sheardPrefrences
        SharedPreferences sp = getSharedPreferences("MyPref" , Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt("lastXScore",currentXScore);
        editor.putInt("lastOScore",currentOScore);
        editor.putInt("lastDrawScore",currentDrawScore);
        editor.commit();



       // Log.d("debug", ">>>>>>>>>> onPause()");
    }
}
