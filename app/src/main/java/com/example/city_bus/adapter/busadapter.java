package com.example.city_bus.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.city_bus.R;
import com.example.city_bus.model.Buses;

import java.util.ArrayList;
import java.util.List;

public class busadapter extends RecyclerView.Adapter<busadapter.Holder> {

    private List<Buses> list;


    public busadapter(List<Buses> list) {
        this.list = list;

    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.show_buses_layout,parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

        Buses bus = list.get(position);

        holder.bus_no.setText(bus.getBus_no());
        holder.route_name.setText(bus.getRoute_name());
        holder.time.setText(bus.getTime());
        holder.distance.setText(bus.getDistance());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder{

        private TextView bus_no,route_name,time,distance;

        public Holder(@NonNull View itemView) {
            super(itemView);

            bus_no = itemView.findViewById(R.id.adbus_no);
            route_name = itemView.findViewById(R.id.adroute_name);
            time = itemView.findViewById(R.id.adtime);
            distance = itemView.findViewById(R.id.addistance);

        }
    }
}
