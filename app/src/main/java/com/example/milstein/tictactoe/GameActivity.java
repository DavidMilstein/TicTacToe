package com.example.milstein.tictactoe;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class GameActivity extends AppCompatActivity implements View.OnClickListener {


    private GameBoard board;
    private String player = "X";
    private Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, restart;
    private String win="";
    private TextView turn, scoreX, scoreO, scoreDraw;
    //int countX=0, countO=0, countDraw=0;
    private int currentXScore, currentOScore, currentDrawScore;

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
            win = board.isWin();
        }
        else if(v.getId() == R.id.btnID2) {
            btn2.setText(this.player);
            btn2.setClickable(false);
            board.setPlayerAt(0,1, this.player);
            win = board.isWin();
        }
        else if(v.getId() == R.id.btnID3) {
            btn3.setText(this.player);
            btn3.setClickable(false);
            board.setPlayerAt(0,2, this.player);
            win = board.isWin();
        }
        else if(v.getId() == R.id.btnID4) {
            btn4.setText(this.player);
            btn4.setClickable(false);
            board.setPlayerAt(1,0, this.player);
            win = board.isWin();
        }
        else if(v.getId() == R.id.btnID5) {
            btn5.setText(this.player);
            btn5.setClickable(false);
            board.setPlayerAt(1,1, this.player);
            win = board.isWin();
        }
        else if(v.getId() == R.id.btnID6) {
            btn6.setText(this.player);
            btn6.setClickable(false);
            board.setPlayerAt(1,2, this.player);
            win = board.isWin();
        }
        else if(v.getId() == R.id.btnID7) {
            btn7.setText(this.player);
            btn7.setClickable(false);
            board.setPlayerAt(2,0, this.player);
            win = board.isWin();
        }
        else if(v.getId() == R.id.btnID8) {
            btn8.setText(this.player);
            btn8.setClickable(false);
            board.setPlayerAt(2,1, this.player);
            win = board.isWin();
        }
        else if(v.getId() == R.id.btnID9) {
            btn9.setText(this.player);
            btn9.setClickable(false);
            board.setPlayerAt(2,2, this.player);
            win = board.isWin();
        }

        //check win or draw
        if (win == "X") {
            currentXScore++;
            scoreX.setText(""+currentXScore);
            turn.setText("X won!");
            btn1.setClickable(false);
            btn2.setClickable(false);
            btn3.setClickable(false);
            btn4.setClickable(false);
            btn5.setClickable(false);
            btn6.setClickable(false);
            btn7.setClickable(false);
            btn8.setClickable(false);
            btn9.setClickable(false);
            win="n";

        }
        if (win == "O") {
            Toast.makeText(getApplicationContext(),"O win",Toast.LENGTH_SHORT).show();
            turn.setText("O won!");
            currentOScore++;
            scoreO.setText(""+currentOScore);
            btn1.setClickable(false);
            btn2.setClickable(false);
            btn3.setClickable(false);
            btn4.setClickable(false);
            btn5.setClickable(false);
            btn6.setClickable(false);
            btn7.setClickable(false);
            btn8.setClickable(false);
            btn9.setClickable(false);
            win="n";
        }
        if(win == "d"){
            Toast.makeText(getApplicationContext(),"DRAW",Toast.LENGTH_SHORT).show();
            turn.setText("DRAW!");
            currentDrawScore++;
            scoreDraw.setText(""+currentDrawScore);
            win="n";

        }
        if(win == "n") {
            Toast.makeText(getApplicationContext(),"Hello Javatpoint",Toast.LENGTH_SHORT).show();
        }
        if(v.getId() != R.id.btnPlayAgainID && win!="X" && win!="O") {
            // swap player

            if (this.player == "X") {
                this.player = "O";
                turn.setText(player + " turn");
            } else {
                this.player = "X";
                turn.setText(player + " turn");
            }
        }
        if(v.getId() == R.id.btnPlayAgainID){

            win="n";
            this.player = "X";
            turn.setText(player + " turn");
            board=new GameBoard();
            btn1.setText(" ");
            btn2.setText(" ");
            btn3.setText(" ");
            btn4.setText(" ");
            btn5.setText(" ");
            btn6.setText(" ");
            btn7.setText(" ");
            btn8.setText(" ");
            btn9.setText(" ");
            btn1.setClickable(true);
            btn2.setClickable(true);
            btn3.setClickable(true);
            btn4.setClickable(true);
            btn5.setClickable(true);
            btn6.setClickable(true);
            btn7.setClickable(true);
            btn8.setClickable(true);
            btn9.setClickable(true);
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

//    public void unclickButton(Button btn)
//    {
//        btn.setClickable(false);
//    }
//
//    public void clickableButton(Button btn)
//    {
//        btn.setClickable(true);
//    }
//    public void removeText(Button btn){
//        btn.setText(" ");
//    }

}
