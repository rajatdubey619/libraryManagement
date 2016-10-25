package com.example.nipc26.librarymanagement.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.nipc26.librarymanagement.R;

public class SplashScreen extends AppCompatActivity implements Animation.AnimationListener {

    private static final String TAG = "SplashScreen";
    private ImageView ivSplash;
    private Animation animation;
    private Thread thread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        ivSplash = (ImageView) findViewById(R.id.ivSplash);
        animation = AnimationUtils.loadAnimation(getBaseContext(), R.anim.rotation);
        animation.setDuration(2000);
        ivSplash.setAnimation(animation);
        thread = new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    sleep(4000);
                    onAnimationEnd(animation);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        finish();
        Intent intent = new Intent(SplashScreen.this, LoginActivity.class);
        startActivity(intent);
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }

    @Override
    protected void onPause() {
        super.onPause();
//        thread.stop();

    }
}