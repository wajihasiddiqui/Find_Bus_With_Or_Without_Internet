package com.example.city_bus.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.city_bus.R;

public class slideAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public slideAdapter(Context context) {
        this.context = context;
    }


    int[] img = {

            R.drawable.sho,
            R.drawable.sho,
            R.drawable.sho,

    };

    public String[] heading = {

            "kjehjd",
            "kjbkjjjmmmmmmmmmmmm",
            "kjehjd"

    };

    public String[] description = {

            "kjehjd",
            "kjehjd",
            "kjehjd"

    };

    @Override
    public int getCount() {
        return heading.length;
    }



    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {

        return view == (RelativeLayout)object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);

        ImageView image = (ImageView)view.findViewById(R.id.image);
        TextView text = (TextView)view.findViewById(R.id.heading);
        TextView text2 = (TextView)view.findViewById(R.id.desc);

        //image.setImageDrawable(image.getResources().getDrawable(imagec[position]));

        image.setImageResource(img[position]);
        text.setText(heading[position]);
        text2.setText(description[position]);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((RelativeLayout)object);
    }

}
