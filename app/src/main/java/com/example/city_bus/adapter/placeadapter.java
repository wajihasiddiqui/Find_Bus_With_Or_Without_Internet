package com.example.city_bus.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.city_bus.R;
import com.example.city_bus.model.Places;

import java.util.List;

public class placeadapter extends RecyclerView.Adapter<placeadapter.Holder>{

    private List<Places> list;

    public placeadapter(List<Places> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.show_places,parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

        Places place = list.get(position);

        holder.place.setText(place.getPlace());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder{

        private TextView place;

        public Holder(@NonNull View itemView) {
            super(itemView);

            place = itemView.findViewById(R.id.adplace);

        }
    }

}
