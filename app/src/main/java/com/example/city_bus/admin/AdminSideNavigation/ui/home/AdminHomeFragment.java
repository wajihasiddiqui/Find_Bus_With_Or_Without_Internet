    package com.example.city_bus.admin.AdminSideNavigation.ui.home;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.city_bus.FatchData.FatchBusDataActivity;
import com.example.city_bus.FatchData.FatchPlacesActivity;
import com.example.city_bus.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class AdminHomeFragment extends Fragment {

//    Button showbus;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_admin_home, container, false);
        
        Button showbus = (Button) view.findViewById(R.id.showbus);

        Button showplace = (Button) view.findViewById(R.id.showplace);


        showbus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                startActivity(new Intent(getActivity(), FatchBusDataActivity.class));

            }
        });


        showplace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                startActivity(new Intent(getActivity(), FatchPlacesActivity.class));

            }
        });

        return view;
    }
}