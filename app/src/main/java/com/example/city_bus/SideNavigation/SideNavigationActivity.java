package com.example.city_bus.SideNavigation;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.view.WindowInsets;
import android.widget.TextView;

import com.example.city_bus.R;
import com.example.city_bus.SideNavigation.ui.home.HomeFragment;
import com.example.city_bus.admin.AdminSideNavigation.AdminSideNavigationActivity;
import com.example.city_bus.user.UserSideNavigation.UserSideNavigationActivity;
import com.example.city_bus.user.UserSideNavigation.ui.home.UserHomeFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class SideNavigationActivity extends AppCompatActivity {

        FirebaseAuth firebaseAuth;
        FirebaseUser currentUser;
        DatabaseReference databaseReference;

        private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_side_navigation);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        firebaseAuth = FirebaseAuth.getInstance();
        currentUser = firebaseAuth.getCurrentUser();
        databaseReference = FirebaseDatabase.getInstance().getReference("User");

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_help, R.id.nav_logout, R.id.nav_profile)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        updateNavHeader();


        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {
                if (destination.getId() == R.id.nav_logout){

                    FirebaseAuth.getInstance().signOut();
                    Intent loginActivity = new Intent(getApplicationContext(), UserSideNavigationActivity.class);
                    startActivity(loginActivity);
                    finish();
                }
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

//
//    protected void onStart() {
//        super.onStart();
//        if(firebaseAuth.getCurrentUser() != null){
//            finish();
//            startActivity(new Intent(SideNavigationActivity.this, AdminSideNavigationActivity.class));
//        }
//
//    }


    public void updateNavHeader() {
        NavigationView navigationView = findViewById(R.id.nav_view);
        View headerView= navigationView.getHeaderView(0);
        TextView navName= headerView.findViewById(R.id.user_name);
        TextView navEmail=headerView.findViewById(R.id.user_email);

        navName.setText(currentUser.getDisplayName());
        navEmail.setText(currentUser.getEmail());


    }
}