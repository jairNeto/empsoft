package com.delaroystudios.MatchFood;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.delaroystudios.MatchFood.R;

public class SplashActivity extends AppCompatActivity {
    private static final long SPLASH_TIME_OUT = 2978;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ImageView myImageView= (ImageView)findViewById(R.id.imgLogo);
        Animation myFadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        myImageView.startAnimation(myFadeInAnimation);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                openLoginScreen();
            }
        }, SPLASH_TIME_OUT);
    }

        private void openLoginScreen() {
            Intent i;
            i = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(i);
            finish();
        }
}
