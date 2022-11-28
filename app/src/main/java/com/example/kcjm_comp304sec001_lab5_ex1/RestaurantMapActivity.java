package com.example.kcjm_comp304sec001_lab5_ex1;

import android.os.Bundle;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class RestaurantMapActivity extends FragmentActivity implements OnMapReadyCallback {
    private GoogleMap mMap;

    String restaurant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_map);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);



    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        restaurant = getIntent().getExtras().getString("Restaurant");
        String[] restaurantBody = restaurant.split(",");

        TextView restaurantName = findViewById(R.id.RestaurantName);
        restaurantName.setText(restaurantBody[0]);

        LatLng restaurant = new LatLng(Double.parseDouble(restaurantBody[1]), Double.parseDouble(restaurantBody[2]));
        mMap.addMarker(new MarkerOptions().position(restaurant).title(restaurantBody[0]));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(restaurant,12f));

    }
}
