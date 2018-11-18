package com.example.milstein.tictactoe;
import android.support.v7.app.AppCompatActivity;

import android.widget.Toast;

public class GameBoard extends AppCompatActivity {

    public String[][] board;
    private int DrawCount;
    private int flag = 0;

    // make new (clear) board
    public GameBoard() {
        int countInt = 1;
        String count = "" + countInt;
        this.board = new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.board[i][j] = count;
                countInt++;
            }
        }
    }

    public String[][] getBoard() {
        return board;
    }

    public void setPlayerAt(int row, int column, String player) {
        this.board[row][column] = player;
    }

    public String isWin() {

        //check row winner
        if (board[0][0] == board[0][1] && board[0][1] == board[0][2])
            return board[0][0];

        else if (board[1][0] == board[1][1] && board[1][1] == board[1][2])
            return board[1][0];

        else if (board[2][0] == board[2][1] && board[2][1] == board[2][2])
            return board[2][0];

            //check diagonal winner
        else if (board[0][0] == board[1][1] && board[1][1] == board[2][2])
            return board[0][0];

        else if (board[0][2] == board[1][1] && board[1][1] == board[2][0])
            return board[0][2];

            //check colon winner
        else if (board[0][0] == board[1][0] && board[1][0] == board[2][0])
            return board[0][0];

        else if (board[0][1] == board[1][1] && board[1][1] == board[2][1])
            return board[0][1];

        else if (board[0][2] == board[1][2] && board[1][2] == board[2][2])
            return board[0][2];

        //check if there is draw
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (this.board[i][j] == "X" || this.board[i][j] == "O"){
                    Toast.makeText(getApplicationContext(), "count"+DrawCount,Toast.LENGTH_SHORT).show();

                    DrawCount++;
                }
            }
        }

//        for(int i=0; i<3; i++){
//            for(int j=0; j<3; j++) {
//                if (this.board[i][j] != null)
//                    DrawCount++;
//            }
//        }


        if (DrawCount == 9)
            return "d";
        else
            return "n";
    }
}
