package com.example.milstein.tictactoe;

public class GameBoard {

    public String [][] board;
    int flag=0;

    public GameBoard() {
        int countInt =1;
        String count = "" + countInt;
        this.board = new String[3][3];
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
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

    public String isWin(){

        //check row winner
        if(board[0][0]==board[0][1] && board [0][1]==board[0][2])
            return board[0][0];

        else if(board[1][0]==board[1][1] && board [1][1]==board[1][2])
            return board[1][0];

        else if(board[2][0]==board[2][1] && board [2][1]==board[2][2])
            return board[2][0];

        //check diagonal winner
        else if(board[0][0]==board[1][1] && board [1][1]==board[2][2])
            return board[0][0];

        else if(board[0][2]==board[1][1] && board [1][1]==board[2][0])
            return board[0][2];

        //check colon winner
        else if(board[0][0]==board[1][0] && board [1][0]==board[2][0])
            return board[0][0];

        else if(board[0][1]==board[1][1] && board [1][1]==board[2][1])
            return board[0][1];

        else if(board[0][2]==board[1][2] && board [1][2]==board[2][2])
            return board[0][2];

        //check if there is draw
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++) {
                if (this.board[i][j] != "X" && this.board[i][j] != "O")
                    flag=1;
            }
        }
        if(flag==1)
            return "n";
        return "d";
    }
}
