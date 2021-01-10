package com.vindevelopment.diceroller;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView show_no;
    Button roll_dice;
    LottieAnimationView RollingDiceAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        show_no = findViewById(R.id.show_no);
        roll_dice = findViewById(R.id.roll_dice);
        RollingDiceAnim = findViewById(R.id.diceRollingAnim);



        RollingDiceAnim.addAnimatorListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                hideDice();
                Random rand = new Random();
                int i = rand.nextInt(7-1)+1;
                show_no.setText(String.valueOf(i));
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

    }

    private void showDice(){
        roll_dice.setEnabled(false);
        show_no.setVisibility(View.INVISIBLE);
        RollingDiceAnim.setVisibility(View.VISIBLE);
        MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.dicerol);
        mediaPlayer.start();

    }

    private void hideDice(){
        roll_dice.setEnabled(true);
        show_no.setVisibility(View.VISIBLE);
        RollingDiceAnim.setVisibility(View.INVISIBLE);
    }

    public void rolldice(View view) {
        showDice();
        RollingDiceAnim.playAnimation();
    }
}