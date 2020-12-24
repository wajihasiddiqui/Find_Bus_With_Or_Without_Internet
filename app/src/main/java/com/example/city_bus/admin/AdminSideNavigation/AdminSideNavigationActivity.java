package com.example.city_bus.admin.AdminSideNavigation;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.city_bus.R;
import com.google.android.material.navigation.NavigationView;

public class AdminSideNavigationActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfigurationa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_side_navigation);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfigurationa = new AppBarConfiguration.Builder(
                R.id.nav_home_admin)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.admin_nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfigurationa);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.admin_nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfigurationa)
                || super.onSupportNavigateUp();
    }

}