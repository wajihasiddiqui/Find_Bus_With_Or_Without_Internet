package com.example.city_bus.FatchData;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.city_bus.R;
import com.example.city_bus.SideNavigation.ui.login.LoginFragment;
import com.example.city_bus.adapter.busadapter;
import com.example.city_bus.admin.AdminSideNavigation.ui.addbus.BusAddFragment;
import com.example.city_bus.database.BusesDatabase;
import com.example.city_bus.login.SignupActivity;
import com.example.city_bus.model.Buses;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class FatchBusDataActivity extends AppCompatActivity {


    RecyclerView recyclerview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fatch_bus_data);


        ArrayList list = new ArrayList();

        recyclerview = findViewById(R.id.recyclerview);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));

        Cursor cr = new BusesDatabase(this).GetAllData();
        cr.moveToFirst();
        while (!cr.isAfterLast())  {

            Buses obj = new Buses(cr.getString(1),cr.getString(2),cr.getString(3),cr.getString(4),cr.getString(5),cr.getString(6));
            list.add(obj);
            cr.moveToNext();
        }


        busadapter adapter = new busadapter(list);
        recyclerview.setAdapter(adapter);

    }

}