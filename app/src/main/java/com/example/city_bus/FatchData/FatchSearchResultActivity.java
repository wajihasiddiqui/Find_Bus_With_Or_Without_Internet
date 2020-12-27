package com.example.city_bus.FatchData;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;

import com.example.city_bus.R;
import com.example.city_bus.adapter.busadapter;
import com.example.city_bus.adapter.searchbusadapter;
import com.example.city_bus.database.BusesDatabase;
import com.example.city_bus.model.Buses;

import java.util.ArrayList;

public class FatchSearchResultActivity extends AppCompatActivity {

    RecyclerView recyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fatch_search_result);


        ArrayList list = new ArrayList();

        recyclerview = findViewById(R.id.recyclerview);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));

        Cursor cr = new BusesDatabase(this).GetSearchResult();
        cr.moveToFirst();
        while (!cr.isAfterLast())  {

            Buses obj = new Buses(cr.getString(1),cr.getString(2),cr.getString(3),cr.getString(4),cr.getString(5),cr.getString(6));
            list.add(obj);
            cr.moveToNext();
        }


        searchbusadapter adapter = new searchbusadapter(list);
        recyclerview.setAdapter(adapter);



    }
}