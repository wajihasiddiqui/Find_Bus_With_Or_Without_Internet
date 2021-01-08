package com.example.city_bus.admin.AdminSideNavigation.ui.addbus;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.city_bus.R;
import com.example.city_bus.database.BusesDatabase;
import com.google.android.material.textfield.TextInputLayout;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.List;


public class BusAddFragment extends Fragment implements AdapterView.OnItemSelectedListener {


    BusesDatabase BusDatabase;
    TextInputLayout bus_no, bus_time,bus_distance,bus_routename;

    Spinner bus_startlocations, bus_endlocation;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bus_add, container, false);

        BusDatabase = new BusesDatabase(getActivity());

        bus_no = (TextInputLayout)view.findViewById(R.id.busNo);
        bus_startlocations = (Spinner)view.findViewById(R.id.startLocation);
        bus_endlocation = (Spinner)view.findViewById(R.id.endLocation);
        bus_time = (TextInputLayout)view.findViewById(R.id.time);
        bus_distance = (TextInputLayout)view.findViewById(R.id.distance);
        bus_routename = (TextInputLayout)view.findViewById(R.id.routeName);

        CircularImageView addbus = (CircularImageView)view.findViewById(R.id.adddBus);

        bus_startlocations.setOnItemSelectedListener(this);
        bus_endlocation.setOnItemSelectedListener(this);



        loadSpinnerData();

        loadSpinnerEndLocatio();



        addbus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = BusDatabase.InsertData(Integer.parseInt( bus_no.getEditText().getText().toString()),bus_startlocations.getSelectedItem().toString(),bus_endlocation.getSelectedItem().toString(),Integer.parseInt(bus_time.getEditText().getText().toString()),bus_distance.getEditText().getText().toString(),bus_routename.getEditText().getText().toString());

                if(isInserted = true){

                    Toast.makeText(getActivity(), "Data Inserted", Toast.LENGTH_SHORT).show();

                }

                else{

                    Toast.makeText(getActivity(), "Data Not Inserted", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;

    }

    private void loadSpinnerEndLocatio() {

        //database handler
        BusDatabase = new BusesDatabase(getActivity());
        //spinner drop down elements
        List<String> list = BusDatabase.getAllPlaces();
        //creating adapter for spinner
        ArrayAdapter<String> placeadapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, list);
        //drop down layout style - list view with radio button
        placeadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //attaching data adapter to spinner
        bus_endlocation.setAdapter(placeadapter);

    }

    private void loadSpinnerData() {

        //database handler
        BusDatabase = new BusesDatabase(getActivity());
        //spinner drop down elements
        List<String> list = BusDatabase.getAllPlaces();
        //creating adapter for spinner
        ArrayAdapter<String> placeadapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, list);
        //drop down layout style - list view with radio button
        placeadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //attaching data adapter to spinner
        bus_startlocations.setAdapter(placeadapter);


    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        // On selecting a spinner item
        String list = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}