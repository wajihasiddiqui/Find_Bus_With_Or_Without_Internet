package com.example.city_bus.startup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.city_bus.R;

public class Splash_Screen extends AppCompatActivity {


    Animation top_animation, bottom_animation;

    TextView sologan, logo;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash__screen);


        top_animation = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottom_animation = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        image = findViewById(R.id.image);
        sologan = findViewById(R.id.sologan);
        logo = findViewById(R.id.logo);

        image.setAnimation(top_animation);
        sologan.setAnimation(bottom_animation);
        logo.setAnimation(bottom_animation);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(Splash_Screen.this, ViewPagerScreen.class));
            }
        }, 3000);
    }
}