package com.example.city_bus.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.city_bus.R;
import com.example.city_bus.model.Places;
import com.example.city_bus.model.Stops;

import java.util.List;

public class stopsadapter extends RecyclerView.Adapter<stopsadapter.Holder>{

    private List<Stops> list;

    public stopsadapter(List<Stops> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.show_stops,parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

        Stops stop = list.get(position);
        holder.stop.setText(stop.getStop());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder{

        private TextView stop;

        public Holder(@NonNull View itemView) {
            super(itemView);

            stop = itemView.findViewById(R.id.adstop);

        }
    }

}
