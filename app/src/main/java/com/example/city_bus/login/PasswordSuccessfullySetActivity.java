package com.example.city_bus.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.city_bus.R;
import com.example.city_bus.SideNavigation.ui.home.HomeFragment;
import com.example.city_bus.SideNavigation.ui.login.LoginFragment;

public class PasswordSuccessfullySetActivity extends AppCompatActivity {

    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_successfully_set);


        login = findViewById(R.id.btn_login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(PasswordSuccessfullySetActivity.this, LoginFragment.class);
                startActivity(intent);

            }
        });

    }
}