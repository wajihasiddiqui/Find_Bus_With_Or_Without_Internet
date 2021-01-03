package com.example.city_bus.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import android.widget.LinearLayout;
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

            R.drawable.getstarted,
            R.drawable.getstarted2,
            R.drawable.getstarted,

    };

    public String[] heading = {


            "Search Your Bus",
            "Search Your Bus",
            "Sit Back And Enjoy"

    };

    public String[] description = {


            "You can search any place with-in the karachi." +
                    "We will display specific or all related " +
                    "buses to match your search",
            "You can search any place with-in the karachi." +
                    "We will display specific or all related " +
                    "buses to match your search",
            "We will handle everything for you. As you have" +
                    " the app in your pocket then you don't have" +
                    "to worry about anything."

    };

    @Override
    public int getCount() {
        return heading.length;
    }



    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {

        return view == (LinearLayout)object;
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

        container.removeView((LinearLayout)object);
    }

}
