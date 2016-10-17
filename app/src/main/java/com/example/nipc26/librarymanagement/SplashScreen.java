package com.example.nipc26.librarymanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashScreen extends AppCompatActivity implements Animation.AnimationListener {

    private static final String TAG = "SplashScreen";
    private ImageView ivSplash;
    private Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        ivSplash = (ImageView) findViewById(R.id.ivSplash);
        animation = AnimationUtils.loadAnimation(getBaseContext(), R.anim.rotation);
        animation.setDuration(3000);
        ivSplash.setAnimation(animation);
        Thread thread = new Thread() {
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
        Intent intent = new Intent(SplashScreen.this, HomeMenu.class);
        startActivity(intent);
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}