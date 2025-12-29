package com.example.tictactoe;

public class GameBord {
    private static char Bored [][] = {
            {' ',' ',' '},
            {' ',' ',' '},
            {' ',' ',' '}
    };
    private static char currentMove = 'X';
    public static char previousMove = 'O';
    private static int count = 0;
    private static boolean win = false;

    private static boolean gameOver = false;
    private static void statusCheck() {
        count ++;
        if(count == 9){
            gameOver = true;
        }


        if (
            // ROWS
                (Bored[0][0] == Bored[0][1] && Bored[0][1] == Bored[0][2] && Bored[0][0] != ' ') ||
                        (Bored[1][0] == Bored[1][1] && Bored[1][1] == Bored[1][2] && Bored[1][0] != ' ') ||
                        (Bored[2][0] == Bored[2][1] && Bored[2][1] == Bored[2][2] && Bored[2][0] != ' ') ||

                        // COLUMNS
                        (Bored[0][0] == Bored[1][0] && Bored[1][0] == Bored[2][0] && Bored[0][0] != ' ') ||
                        (Bored[0][1] == Bored[1][1] && Bored[1][1] == Bored[2][1] && Bored[0][1] != ' ') ||
                        (Bored[0][2] == Bored[1][2] && Bored[1][2] == Bored[2][2] && Bored[0][2] != ' ') ||

                        // DIAGONALS
                        (Bored[0][0] == Bored[1][1] && Bored[1][1] == Bored[2][2] && Bored[0][0] != ' ') ||
                        (Bored[0][2] == Bored[1][1] && Bored[1][1] == Bored[2][0] && Bored[0][2] != ' ')
        ) {
            gameOver = true;
            win = true;
        }
    }

    public static String GameStatusCheck(){
        statusCheck();
        if(gameOver){
            if(win){
                return "win";
            }
            return "draw";
        }
        return "1";
    }

    public void setToPosition(int x, int y, char val){
        Bored[x][y] = val;
    }

    public static char getMove() {
        char move = currentMove;

        if (currentMove == 'X') {
            previousMove = currentMove;
            currentMove = 'O';

        } else {
            previousMove = currentMove;
            currentMove = 'X';
        }

        return move;
    }
    public static void resetBord(){
        gameOver = false;
        win = false;
        currentMove = 'X';
        previousMove = 'O';
        count = 0;
      for(int r = 0;r<=2;r++){
          for(int c = 0;c<=2;c++){
              Bored[r][c] = ' ';
          }
      }
    }

}
