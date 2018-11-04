package com.example.milstein.tictactoe;

public class GameBoard {

    public char [][] board;

    public GameBoard() {

        this.board = new char[3][3];
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                this.board[i][j] = ' ';
            }
        }
    }

    public char[][] getBoard() {
        return board;
    }

    public void setPlayerAt(int row, int column, char player) {
        this.board[row][column] = player;
    }

    public char isWin(){

        //check row winner
        if(board[0][0]==board[0][1] && board [0][1]==board[0][2])
            return board[0][0];
        if(board[1][0]==board[1][1] && board [1][1]==board[1][2])
            return board[1][0];
        if(board[2][0]==board[2][1] && board [2][1]==board[2][2])
            return board[2][0];

        //check diagonal winner
        if(board[0][0]==board[1][1] && board [1][1]==board[2][2])
            return board[0][0];
        if(board[0][2]==board[1][1] && board [1][1]==board[2][0])
            return board[0][2];

        //check colon winner
        if(board[0][0]==board[1][0] && board [2][0]==board[0][2])
            return board[0][0];
        if(board[0][1]==board[1][1] && board [2][1]==board[0][2])
            return board[0][1];
        if(board[0][2]==board[1][2] && board [2][2]==board[0][2])
            return board[0][2];

        //check if there is draw
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(this.board[i][j] == ' ')
                    break;
            }
            return 'd';
        }
        return 'n';
    }
}
