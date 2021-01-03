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


    EditText bus_startlocations, bus_endlocation;
    Button search;

    AutoCompleteTextView autoComplete;

    BusesDatabase BusDatabase;
    public static String start, end;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_user_home, container, false);


        bus_startlocations = (EditText)view.findViewById(R.id.start_location);
        bus_endlocation = (EditText)view.findViewById(R.id.end_location);

        autoComplete = view.findViewById(R.id.autocomplete);


//        BusDatabase = new BusesDatabase(getActivity());
//        List<String> list = BusDatabase.getAllPlaces();
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,list);
//        autoComplete = view.findViewById(R.id.autoComplete);
//        autoComplete.setAdapter(adapter);
//

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