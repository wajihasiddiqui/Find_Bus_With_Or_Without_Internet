package com.example.city_bus.SideNavigation.ui.home;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.city_bus.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

import static android.content.Context.LOCATION_SERVICE;

public class HomeFragment extends Fragment {

    private GoogleMap mMap;
    LocationManager location;

    private OnMapReadyCallback callback = new OnMapReadyCallback() {

        @Override
        public void onMapReady(GoogleMap googleMap) {
//            LatLng sydney = new LatLng(-34, 151);
//            googleMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
//            googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));


        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);


//        if (mapFragment != null) {
//            mapFragment.getMapAsync(callback);
//
//            location = (LocationManager)getActivity().getSystemService(LOCATION_SERVICE);
//
//            if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//                requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION}, 12);
//                return;
//            }
//
//            location.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, new LocationListener() {
//                @Override
//                public void onLocationChanged(@NonNull Location location) {
//
//
//                    String title = "";
//                    double lat = location.getLatitude();
//                    double longitude = location.getLongitude();
//
//                    try {
//                        Geocoder geo = new Geocoder(getActivity());
//                        List<Address> address = geo.getFromLocation(lat, longitude, 1);
//                        title = address.get(0).getCountryName() + " , " + address.get(0).getLocality();
//
//
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//
//
//                    LatLng mylocaion = new LatLng(lat, longitude);
//                    mMap.addMarker(new MarkerOptions().position(mylocaion).title(title));
//                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(mylocaion, 10.2f));
//
//
//                }
//            });
//
//
//            location.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, new LocationListener() {
//                @Override
//                public void onLocationChanged(@NonNull Location location) {
//
//
//                    String title = "";
//                    double lat = location.getLatitude();
//                    double longitude = location.getLongitude();
//
//
//                    try {
//                        Geocoder geo = new Geocoder(getActivity());
//                        List<Address> address = geo.getFromLocation(lat, longitude, 1);
//                        title = address.get(0).getCountryName() + " , " + address.get(0).getLocality();
//
//
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//
//
//                    LatLng mylocaion = new LatLng(lat, longitude);
//                    mMap.addMarker(new MarkerOptions().position(mylocaion).title(title));
//                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(mylocaion, 10.2f));
//
//
//                }
//            });
//
//        }
    }

//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//
//        if (requestCode == 12 && grantResults[0] == PackageManager.PERMISSION_DENIED) {
//
//            if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//
//                return;
//            }
//            location.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, new LocationListener() {
//                @Override
//                public void onLocationChanged(@NonNull Location location) {
//
//
//                    String title = "";
//                    double lat = location.getLatitude();
//                    double longitude = location.getLongitude();
//
//                    try {
//                        Geocoder geo = new Geocoder(getActivity());
//                        List<Address> address = geo.getFromLocation(lat, longitude, 1);
//                        title = address.get(0).getCountryName() + " , " + address.get(0).getLocality();
//
//
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//
//
//                    LatLng mylocaion = new LatLng(lat, longitude);
//                    mMap.addMarker(new MarkerOptions().position(mylocaion).title(title));
//                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(mylocaion, 10.2f));
//
//
//                }
//            });
//        }
//    }
}