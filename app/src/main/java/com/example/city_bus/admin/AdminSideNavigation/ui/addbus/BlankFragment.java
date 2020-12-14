package com.example.city_bus.admin.AdminSideNavigation.ui.addbus;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.city_bus.R;
import com.example.city_bus.adapter.BusesDatabase;


public class BlankFragment extends Fragment {


    BusesDatabase BusDatabase;
    EditText bus_no, bus_startlocations, bus_endlocation, bus_time,bus_distance,bus_routename;
    Button addbus;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blank, container, false);



        EditText bus_no = (EditText)view.findViewById(R.id.busNo);


          //BusDatabase = new BusesDatabase(this);
//
//        bus_no = findViewById(R.id.busNo);
//        bus_startlocations = findViewById(R.id.startLocation);
//        bus_endlocation = findViewById(R.id.endLocation);
//        bus_time = findViewById(R.id.time);
//        bus_distance = findViewById(R.id.distance);
//        bus_routename = findViewById(R.id.routeName);
//
//        addbus = findViewById(R.id.addbus);
//
//        addbus.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                boolean isInserted = BusDatabase.InsertData(Integer.parseInt( bus_no.getText().toString()),bus_startlocations.getText().toString(),bus_endlocation.getText().toString(),Integer.parseInt(bus_time.getText().toString()),bus_distance.getText().toString(),bus_routename.getText().toString());
//
//                if(isInserted = true){
//
//                    Toast.makeText(BlankFragment.this, "Data Inserted", Toast.LENGTH_SHORT).show();
//
//                }
//
//                else{
//
//                    Toast.makeText(BlankFragment.this, "Data Not Inserted", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });

        return view;


    }
}