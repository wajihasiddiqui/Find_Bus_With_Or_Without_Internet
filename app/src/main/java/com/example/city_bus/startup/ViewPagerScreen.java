package com.example.city_bus.startup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.city_bus.R;
import com.example.city_bus.SideNavigation.ui.home.HomeFragment;
import com.example.city_bus.adapter.slideAdapter;
import com.example.city_bus.user.UserSideNavigation.UserSideNavigationActivity;

import static android.graphics.Color.BLACK;

public class ViewPagerScreen extends AppCompatActivity {


    ViewPager viewpager;
    LinearLayout dotlayout;
    private slideAdapter  SlideAdapter;
    private TextView[] mDots;

    Button nextbtn,backbtn;
    private int CurrentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_screen);

        viewpager = findViewById(R.id.viewpager);
        dotlayout = findViewById(R.id.dotlayout);

        SlideAdapter = new slideAdapter(this);
        viewpager.setAdapter(SlideAdapter);

        nextbtn = findViewById(R.id.nextbtn);
        backbtn = findViewById(R.id.backbtn);

        addDotsIndecator(0);
        viewpager.addOnPageChangeListener(viewListener);

        nextbtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if(nextbtn.getText() == "Get Started"){

                    startActivity(new Intent(getApplicationContext(), GetStarted.class));
                }
                else{

                    viewpager.setCurrentItem(CurrentPage+1);
                }

            }
        });

        backbtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                viewpager.setCurrentItem(CurrentPage-1);
            }
        });

    }

    public void addDotsIndecator(int position){

        mDots = new TextView[3];
        dotlayout.removeAllViews();

        for(int i = 0; i < mDots.length; i++){

            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226"));
            mDots[i].setTextSize(45);
            mDots[i].setTextColor(getResources().getColor(R.color.black));
            dotlayout.addView(mDots[i]);

        }

        if(mDots.length > 0){

            mDots[position].setTextColor(getResources().getColor(R.color.purple_500));
        }
    }


    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int i) {

            addDotsIndecator(i);
            CurrentPage = i;
            if(i == 0){
                nextbtn.setEnabled(true);
                backbtn.setEnabled(false);
                backbtn.setVisibility(View.INVISIBLE);
                nextbtn.setText("Next");
                backbtn.setText("");
            }
            else if(i == mDots.length -1){

                nextbtn.setEnabled(true);
                backbtn.setEnabled(true);
                backbtn.setVisibility(View.VISIBLE);
                nextbtn.setText("Get Started");

                backbtn.setText("Back");
            }
            else{
                nextbtn.setEnabled(true);
                backbtn.setEnabled(true);
                backbtn.setVisibility(View.VISIBLE);
                nextbtn.setText("Next");
                backbtn.setText("Back");
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}