package com.example.city_bus.startup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.city_bus.R;

public class GetStarted1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_started1);

        
    }

    public void skip(View view) {
        startActivity(new Intent(this, GetStarted3.class));
    }

    public void cont(View view) {
        startActivity(new Intent(this, GetStarted2.class));
    }

    public void one(View view) {
    }

    public void two(View view) {
    }

    public void three(View view) {
    }
}