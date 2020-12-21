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
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.city_bus.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.mikhaellopez.circularimageview.CircularImageView;

public class StopsAddFragment extends Fragment {

   // LinearLayout layoutlist;
    static int totalEditTexts = 0;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.route_add_fragment, container, false);

        LinearLayout layoutlist = (LinearLayout)view.findViewById(R.id.listlayout);
        CircularImageView addtextbox = (CircularImageView)view.findViewById(R.id.addtb);

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


        return view;


    }



}