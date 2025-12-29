package com.example.tictactoe;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    Button b00,b01,b02,b10,b11,b12,b20,b21,b22;
    GameLogic gameLogic = new GameLogic();
    AlertDialog alertDialog;
    TextView current;
    ArrayList<Button> buttons = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b00 = findViewById(R.id.b11);
        b01 = findViewById(R.id.b12);
        b02 = findViewById(R.id.b13);
        b10 = findViewById(R.id.b21);
        b11 = findViewById(R.id.b22);
        b12 = findViewById(R.id.b23);
        b20 = findViewById(R.id.b31);
        b21 = findViewById(R.id.b32);
        b22 = findViewById(R.id.b33);

        current = findViewById(R.id.current);


        b00.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonPressed(0,0,b00);
            }
        });
        b01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonPressed(0,1,b01);
            }
        });
        b02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonPressed(0,2,b02);
            }
        });
        b10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonPressed(1,0,b10);
            }
        });
        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonPressed(1,1,b11);
            }
        });
        b12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonPressed(1,2,b12);
            }
        });
        b20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonPressed(2,0,b20);
            }
        });
        b21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonPressed(2,1,b21);
            }
        });

        b22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonPressed(2,2,b22);
            }
        });




    }
    private void buttonPressed(int x, int y, Button b){
        current.setText(String.valueOf(GameBord.previousMove));
        String status = gameLogic.make_move(x,y,b);
        buttons.add(b);
        if(!status.equals("1")){
            if(status.equals("win")){
                show_dialog("Game Over!!",GameBord.previousMove+" won !!");
            }
            else if(status.equals("draw")){
                show_dialog("Game Over!!","DRAW");
            }
        }
    }

    //popup message
    private void show_dialog(String title, String message) {
        new AlertDialog.Builder(this)
                .setTitle(title)
                .setMessage(message)
                .setCancelable(false)
                .setPositiveButton("Reset", (dialog, which) -> {
                    resetGame();
                    dialog.dismiss();
                })
                .show();
    }

    private void resetGame(){
        for (Button b:buttons) {
            b.setEnabled(true);
            b.setText(" ");
        }
        GameBord.resetBord();
    }

}
