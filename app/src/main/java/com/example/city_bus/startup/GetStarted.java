package com.example.city_bus.startup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.example.city_bus.R;
import com.example.city_bus.user.UserSideNavigation.UserSideNavigationActivity;
import com.example.city_bus.user.UserSideNavigation.ui.home.UserHomeFragment;

public class GetStarted extends AppCompatActivity {

    Button getstart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_started);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        getstart = findViewById(R.id.getstarted);

        getstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(), UserSideNavigationActivity.class));

            }
        });
    }
}