package com.example.tictactoe;

import android.widget.Button;

public class GameLogic {
    GameBord bord = new GameBord();
    // make move position x or o status check
    public String make_move(int x , int y, Button b){

        char move = GameBord.getMove();

        bord.setToPosition(x,y,move);
        b.setEnabled(false);
        b.setText(String.valueOf(move));
        return GameBord.GameStatusCheck();
        // ill add game status message later
    }
}
