package com.example.diceroll;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;
import java.util.Random;

import es.dmoral.toasty.Toasty;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer m1;
    private ImageView diceOne, diceTwo;
//    private String filename = "android.resource://" + MainActivity.this.getPackageName() + "/raw/dice";
    private Random randomDigit = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button rollButton;
        m1 = MediaPlayer.create(MainActivity.this, R.raw.dice);

        rollButton = findViewById(R.id.roll);
        diceOne = findViewById(R.id.diceOne);
        diceTwo = findViewById(R.id.diceTwo);
        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Roll();
            }
        });

//        m1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//            @Override
//            public void onCompletion(MediaPlayer mp) {
//
//                m1.stop();
//                try {
//                    m1.setDataSource(MainActivity.this, Uri.parse(filename));
//                    m1.prepare();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//
//            }
//        });

    }


    private void Roll() {

        m1.start();
        int random1 = randomDigit.nextInt(6) + 1;
        int random2 = randomDigit.nextInt(6) + 1;
        int total = 0;

        switch (random1) {
            case 1:
                diceOne.setImageResource(R.drawable.dice1);
                total += 1;
                break;
            case 2:
                diceOne.setImageResource(R.drawable.dice2);
                total += 2;
                break;
            case 3:
                diceOne.setImageResource(R.drawable.dice3);
                total += 3;
                break;
            case 4:
                diceOne.setImageResource(R.drawable.dice4);
                total += 4;
                break;
            case 5:
                diceOne.setImageResource(R.drawable.dice5);
                total += 5;
                break;
            case 6:
                diceOne.setImageResource(R.drawable.dice6);
                total += 6;
                break;
        }

        switch (random2) {
            case 1:
                diceTwo.setImageResource(R.drawable.dice1);
                total += 1;
                break;
            case 2:
                diceTwo.setImageResource(R.drawable.dice2);
                total += 2;
                break;
            case 3:
                diceTwo.setImageResource(R.drawable.dice3);
                total += 3;
                break;
            case 4:
                diceTwo.setImageResource(R.drawable.dice4);
                total += 4;
                break;
            case 5:
                diceTwo.setImageResource(R.drawable.dice5);
                total += 5;
                break;
            case 6:
                diceTwo.setImageResource(R.drawable.dice6);
                total += 6;
                break;
        }

        Toasty.normal(this,"Score is "+total+"", Toast.LENGTH_SHORT).show();
    }

}
