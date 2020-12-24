package com.example.city_bus.FatchData;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;

import com.example.city_bus.R;
import com.example.city_bus.adapter.placeadapter;
import com.example.city_bus.database.BusesDatabase;
import com.example.city_bus.model.Places;
import com.example.city_bus.model.Stops;

import java.util.ArrayList;

public class FatchStopsActivity extends AppCompatActivity {

    RecyclerView recyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fatch_stops);


        ArrayList list = new ArrayList();

        recyclerview = findViewById(R.id.recyclerview);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));

        Cursor cr = new BusesDatabase(this).GetAllDataPlace();
        cr.moveToFirst();
        while (!cr.isAfterLast())  {

            Stops obj = new Stops(cr.getString(1));
            list.add(obj);
            cr.moveToNext();
        }


        placeadapter adapter = new placeadapter(list);
        recyclerview.setAdapter(adapter);




    }
}