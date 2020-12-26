package com.example.city_bus.admin.AdminSideNavigation.ui.addplace;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.city_bus.R;
import com.example.city_bus.database.BusesDatabase;
import com.google.android.material.textfield.TextInputLayout;
import com.mikhaellopez.circularimageview.CircularImageView;


public class AddPlaceFragment extends Fragment {

    BusesDatabase BusDatabase;
    EditText addplace;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_place, container, false);


        BusDatabase = new BusesDatabase(getActivity());

        addplace = (EditText)view.findViewById(R.id.Place);
        CircularImageView btnaddplace = (CircularImageView)view.findViewById(R.id.btnaddplace);


        btnaddplace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean isInserted = BusDatabase.InsertPlace(addplace.getText().toString());

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