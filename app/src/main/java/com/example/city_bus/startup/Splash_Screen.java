package com.example.city_bus.startup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.city_bus.R;
import com.example.city_bus.user.UserSideNavigation.UserSideNavigationActivity;

public class Splash_Screen extends AppCompatActivity {


    Animation top_animation, bottom_animation;

    TextView sologan, logo;
    ImageView image;

    SharedPreferences sharedPreferences;
    Boolean firstTime;

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


        sharedPreferences = getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        firstTime = sharedPreferences.getBoolean("firstTime",true);

        if(firstTime){
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    firstTime = false;
                    editor.putBoolean("firstTime",firstTime);
                    editor.apply();
                    startActivity(new Intent(Splash_Screen.this, ViewPagerScreen.class));
                    finish();
                }
            }, 3000);
        }
        else{

            startActivity(new Intent(Splash_Screen.this, UserSideNavigationActivity.class));
            finish();
        }



    }
}