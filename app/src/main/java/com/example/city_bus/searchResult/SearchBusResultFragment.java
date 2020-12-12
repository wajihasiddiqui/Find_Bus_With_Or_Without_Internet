package com.example.city_bus.searchResult;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.city_bus.R;
import com.example.city_bus.model.searchBusResultlist;

import java.util.ArrayList;
import java.util.List;

public class SearchBusResultFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_search_bus_result, container, false);

        RecyclerView recyclerview = view.findViewById(R.id.recyclerview);
        recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));

        List<searchBusResultlist> list = new ArrayList<>();

        list.add(new searchBusResultlist("M7","15 min","45km","Via Shah Faisal","https://tse3.mm.bing.net/th?id=OIP.Xa_FUFxWwz48najD3i5uCAHaFY&pid=Api&P=0&w=254&h=185"));


//        recyclerview.setAdapter(new searchBusResultlist(list,getContext()));


        return view;

    }
}