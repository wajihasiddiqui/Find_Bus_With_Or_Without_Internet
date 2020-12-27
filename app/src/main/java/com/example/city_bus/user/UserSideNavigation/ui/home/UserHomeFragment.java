package com.example.city_bus.user.UserSideNavigation.ui.home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.city_bus.R;
import com.google.android.material.textfield.TextInputLayout;


public class UserHomeFragment extends Fragment {


    TextInputLayout bus_startlocations, bus_endlocation;
    Button search;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_user_home, container, false);

        bus_startlocations = (TextInputLayout)view.findViewById(R.id.start_location);
        bus_endlocation = (TextInputLayout)view.findViewById(R.id.end_location);

        search = (Button)view.findViewById(R.id.search);


        search.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


            }
        });



        return view;
    }
}