package com.mmuhamadamirzaidi;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {

    private ImageView SplashLogo;
    private int SPLASH_TIME_OUT=1000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // let's make this activity on full screen

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.splashlogo);

        // hide the action bar

        getSupportActionBar().hide();

        SplashLogo = (ImageView)findViewById(R.id.splash_logo_startup);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent splash = new Intent(SplashActivity.this,MainActivity.class);
                startActivity(splash);
                finish();
            }
        },SPLASH_TIME_OUT);

        Animation myanim = AnimationUtils.loadAnimation(this,R.anim.splashanimation);
        SplashLogo.startAnimation(myanim);
    }
}
