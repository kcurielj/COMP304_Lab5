package com.example.kcjm_comp304sec001_lab5_ex1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class RestaurantMapActivity extends AppCompatActivity {

    String restaurantName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_map);

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                restaurantName = null;
            } else {
                restaurantName = extras.getString("RestaurantName");
            }
        }


    }
}