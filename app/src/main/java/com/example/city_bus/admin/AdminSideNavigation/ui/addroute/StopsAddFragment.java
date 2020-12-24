package com.example.city_bus.admin.AdminSideNavigation.ui.addroute;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.city_bus.R;
import com.example.city_bus.database.BusesDatabase;
import com.example.city_bus.model.Stops;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.List;

public class StopsAddFragment extends Fragment implements AdapterView.OnItemSelectedListener  {

    TextInputLayout stop;
    static int totalEditTexts = 0;

    BusesDatabase BusDatabase;


    Spinner spbusno, routename;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.route_add_fragment, container, false);

        BusDatabase = new BusesDatabase(getActivity());

        LinearLayout layoutlist = (LinearLayout)view.findViewById(R.id.listlayout);
        CircularImageView addtextbox = (CircularImageView)view.findViewById(R.id.addtb);
        CircularImageView insertdata = (CircularImageView)view.findViewById(R.id.insert_data);
        spbusno = (Spinner)view.findViewById(R.id.busNo);
        routename = (Spinner)view.findViewById(R.id.route_name);
        stop = (TextInputLayout)view.findViewById(R.id.stop);

        //spbusno.setOnItemSelectedListener(this);

        routename.setOnItemSelectedListener(this);


        loadSpinnerbusno();

        loadSpinnerroutename();


        addtextbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addbox();
            }

            private void addbox() {
                totalEditTexts++;
                if (totalEditTexts > 100)
                    return;
                View box = getLayoutInflater().inflate(R.layout.row_add_tvstop,null,false);
                layoutlist.addView(box);

            }

        });


        insertdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for(int i = 0; i < layoutlist.getChildCount(); i++){
                    View box = layoutlist.getChildAt(i);

//                    if(!stop.getEditText().getText().toString().equals("")){
//                        Stops.setStop(stop.getEditText().getText().toString());
//                    }
//                    else{
//
//                        break;
//                    }

//                    boolean isInserted = BusDatabase.InsertStops(Integer.parseInt(spbusno.getSelectedItem().toString()),routename.getSelectedItem().toString(),stop.getEditText().getText().toString());
//
//                    if(isInserted = true){
//
//                        Toast.makeText(getActivity(), "Data Inserted", Toast.LENGTH_SHORT).show();
//
//                    }
//
//                    else{
//
//                        Toast.makeText(getActivity(), "Data Not Inserted", Toast.LENGTH_SHORT).show();
//                    }
                }
            }
        });


        return view;


    }

    private void loadSpinnerroutename() {

        BusDatabase = new BusesDatabase(getActivity());
        //spinner drop down elements
        List<String> list = BusDatabase.getroutename();
        //creating adapter for spinner
        ArrayAdapter<String> busadapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, list);
        //drop down layout style - list view with radio button
        busadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //attaching data adapter to spinner
        routename.setAdapter(busadapter);

    }


    private void loadSpinnerbusno() {

        //database handler
        BusDatabase = new BusesDatabase(getActivity());
        //spinner drop down elements
        List<String> list = BusDatabase.getbusno();
        //creating adapter for spinner
        ArrayAdapter<String> busadapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, list);
        //drop down layout style - list view with radio button
        busadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //attaching data adapter to spinner
        spbusno.setAdapter(busadapter);


    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        String list = parent.getItemAtPosition(position).toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}