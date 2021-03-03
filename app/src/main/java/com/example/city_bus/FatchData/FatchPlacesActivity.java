package com.example.city_bus.FatchData;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;

import com.example.city_bus.R;
import com.example.city_bus.adapter.placeadapter;
import com.example.city_bus.admin.AdminSideNavigation.ui.addbus.BusAddFragment;
import com.example.city_bus.admin.AdminSideNavigation.ui.addplace.AddPlaceFragment;
import com.example.city_bus.database.BusesDatabase;
import com.example.city_bus.model.Places;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class FatchPlacesActivity extends AppCompatActivity {

    RecyclerView recyclerview;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fatch_places);


      //  getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        ArrayList list = new ArrayList();

        recyclerview = findViewById(R.id.recyclerview);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));

        Cursor cr = new BusesDatabase(this).GetAllDataPlace();
        cr.moveToFirst();
        while (!cr.isAfterLast())  {

            Places obj = new Places(cr.getString(1));
            list.add(obj);
            cr.moveToNext();
        }


        placeadapter adapter = new placeadapter(list);
        recyclerview.setAdapter(adapter);


    }
}