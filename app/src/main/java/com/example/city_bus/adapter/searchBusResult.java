package com.example.city_bus.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.city_bus.R;
import com.example.city_bus.model.searchBusResultlist;

import java.util.List;

public class searchBusResult extends RecyclerView.Adapter<searchBusResult.Holder> {

    private List<searchBusResultlist> list;
    private Context context;


    public searchBusResult(List<searchBusResultlist> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_show_bus_result, parent, false);
        return new Holder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

     searchBusResultlist searchBusResultlist = list.get(position);

        holder.tv_busno.setText(searchBusResultlist.getBus_no());
        holder.tv_time.setText(searchBusResultlist.getTime());
        holder.tv_distance.setText(searchBusResultlist.getDistance());
        holder.tv_routename.setText(searchBusResultlist.getRoute_name());


        //Glide.with(context).load(searchBusResultlist.getRoute_img()).into(holder.img_busroutemap);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder{
        private TextView tv_busno, tv_time, tv_distance, tv_routename;
        private ImageView img_busroutemap;

        public Holder(@NonNull View itemView) {
            super(itemView);

            tv_busno = itemView.findViewById(R.id.bus_no);
            tv_time = itemView.findViewById(R.id.time);
            tv_distance = itemView.findViewById(R.id.distance);
            tv_routename = itemView.findViewById(R.id.route_name);

            img_busroutemap = itemView.findViewById(R.id.bus_routes_map);
        }
    }
}
