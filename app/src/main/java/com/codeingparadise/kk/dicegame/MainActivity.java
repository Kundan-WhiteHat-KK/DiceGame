package com.codeingparadise.kk.dicegame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView imageCPU,imagePlayer;
    TextView textCPU,textPlayer;
    int cpuPoints = 0,playerPoints = 0;
    Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageCPU = (ImageView)findViewById(R.id.image1);
        imagePlayer = (ImageView)findViewById(R.id.image2);
        textCPU = (TextView)findViewById(R.id.cpu);
        textPlayer = (TextView)findViewById(R.id.player);

        random = new Random();

        imagePlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int cpuThrow = random.nextInt(6) + 1;
                int playerThrow = random.nextInt(6) + 1;

                setImageCPU(cpuThrow);
                setImagePlayer(playerThrow);

                if (cpuThrow > playerThrow) {
                    cpuPoints++;
                }
                if (playerThrow == cpuThrow) {
                    Toast.makeText(MainActivity.this,"Draw!",Toast.LENGTH_SHORT).show();
                }
                if (playerThrow > cpuThrow) {
                    playerPoints++;
                }
                textCPU.setText("CPU : "+cpuPoints);
                textPlayer.setText("You : "+playerPoints);

                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate);
                imageCPU.startAnimation(animation);
                imagePlayer.startAnimation(animation);
            }
        });
    }
    public void setImageCPU(int num) {
        switch (num) {
            case 1:
                imageCPU.setImageResource(R.drawable.dice1);
                break;
            case 2:
                imageCPU.setImageResource(R.drawable.dice2);
                break;
            case 3:
                imageCPU.setImageResource(R.drawable.dice3);
                break;
            case 4:
                imageCPU.setImageResource(R.drawable.dice4);
                break;
            case 5:
                imageCPU.setImageResource(R.drawable.dice5);
                break;
            case 6:
                imageCPU.setImageResource(R.drawable.dice6);
                break;
        }
    }
    public void setImagePlayer(int num) {
        switch (num) {
            case 1:
                imagePlayer.setImageResource(R.drawable.dice1);
                break;
            case 2:
                imagePlayer.setImageResource(R.drawable.dice2);
                break;
            case 3:
                imagePlayer.setImageResource(R.drawable.dice3);
                break;
            case 4:
                imagePlayer.setImageResource(R.drawable.dice4);
                break;
            case 5:
                imagePlayer.setImageResource(R.drawable.dice5);
                break;
            case 6:
                imagePlayer.setImageResource(R.drawable.dice6);
                break;
        }
    }
}