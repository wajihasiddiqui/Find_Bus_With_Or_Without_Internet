package com.example.city_bus.user.UserSideNavigation.ui.home;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import com.example.city_bus.FatchData.FatchSearchResultActivity;
import com.example.city_bus.R;
import com.example.city_bus.adapter.searchbusadapter;
import com.example.city_bus.database.BusesDatabase;
import com.example.city_bus.model.Buses;
import com.example.city_bus.model.Places;
import com.google.android.material.textfield.TextInputLayout;

import java.util.List;


public class UserHomeFragment extends Fragment  {


    AutoCompleteTextView bus_startlocations, bus_endlocation;
    Button search;

    BusesDatabase BusDatabase;
    public static String start, end;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_user_home, container, false);


        bus_endlocation = view.findViewById(R.id.end_location);

        bus_startlocations = view.findViewById(R.id.start_location);


        BusDatabase = new BusesDatabase(getActivity());
        List<String> list = BusDatabase.getAllPlaces();
        ArrayAdapter adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_dropdown_item,list);
        bus_startlocations.setAdapter(adapter);
        bus_startlocations.setThreshold(1);
        bus_endlocation.setAdapter(adapter);
        bus_endlocation.setThreshold(1);


        search = (Button)view.findViewById(R.id.search);


        search.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                start = bus_startlocations.getText().toString();
                end = bus_endlocation.getText().toString();

                Intent intent= new Intent(getActivity() , FatchSearchResultActivity.class);
                startActivity(intent);

            }
        });

        return view;
    }

}