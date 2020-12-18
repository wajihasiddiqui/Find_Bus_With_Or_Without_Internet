package com.example.city_bus.admin.AdminSideNavigation.ui.addbus;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.city_bus.R;
import com.example.city_bus.database.BusesDatabase;
import com.google.android.material.textfield.TextInputLayout;
import com.mikhaellopez.circularimageview.CircularImageView;


public class BusAddFragment extends Fragment {


    BusesDatabase BusDatabase;
    TextInputLayout bus_no, bus_startlocations, bus_endlocation, bus_time,bus_distance,bus_routename;
//    Button addbus;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bus_add, container, false);

        BusDatabase = new BusesDatabase(getActivity());

        bus_no = (TextInputLayout)view.findViewById(R.id.busNo);
        bus_startlocations = (TextInputLayout)view.findViewById(R.id.startLocation);
        bus_endlocation = (TextInputLayout)view.findViewById(R.id.endLocation);
        bus_time = (TextInputLayout)view.findViewById(R.id.time);
        bus_distance = (TextInputLayout)view.findViewById(R.id.distance);
        bus_routename = (TextInputLayout)view.findViewById(R.id.routeName);

        CircularImageView addbus = (CircularImageView)view.findViewById(R.id.adddBus);





        addbus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = BusDatabase.InsertData(Integer.parseInt( bus_no.getEditText().getText().toString()),bus_startlocations.getEditText().getText().toString(),bus_endlocation.getEditText().getText().toString(),Integer.parseInt(bus_time.getEditText().getText().toString()),bus_distance.getEditText().getText().toString(),bus_routename.getEditText().getText().toString());

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


}