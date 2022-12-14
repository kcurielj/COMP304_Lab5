package com.example.kcjm_comp304sec001_lab5_ex1;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class RestaurantsList extends ListActivity {

    String[] activities;
    Integer restaurantType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants_list);
        ListView lstView = getListView();

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                restaurantType = null;
            } else {
                restaurantType = extras.getInt("Type");
            }
        }
        lstView.setChoiceMode(ListView.CHOICE_MODE_NONE);
        lstView.setTextFilterEnabled(true);
        //populate the array activities
        activities = getResources().getStringArray(restaurantType);
        String[] nameOnly = new String[5];
        for (int i = 0; i < activities.length; i++) {
            String activity = activities[i];
            nameOnly[i] = activity.split(",")[0];
        }

        setListAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, nameOnly));
    }

    public void onListItemClick(ListView parent, View v, int position, long id) {
        Intent i = null;
        i = new Intent(this, RestaurantMapActivity.class);
        i.putExtra("Restaurant", activities[position]);


        startActivity(i);

    }
}
