package com.example.kcjm_comp304sec001_lab5_ex1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends ListActivity {

    String[] activities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView lstView = getListView();

        lstView.setChoiceMode(ListView.CHOICE_MODE_NONE);
        lstView.setTextFilterEnabled(true);
        //populate the array activities
        activities = getResources().getStringArray(R.array.Cuisine);
        setListAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, activities));

    }

    public void onListItemClick(
            ListView parent, View v, int position, long id)
    {
        Intent i=null;
        switch (position)
        {
            case 0:
                i = new Intent(this, RestaurantsList.class);
                i.putExtra("Type", R.array.Italian);
                break;
            case 1:
                i = new Intent(this, RestaurantsList.class);
                i.putExtra("Type", R.array.Greek);
                break;
            case 2:
                i = new Intent(this, RestaurantsList.class);
                i.putExtra("Type", R.array.Japanese);
                break;
            case 3:
                i = new Intent(this, RestaurantsList.class);
                i.putExtra("Type", R.array.Korean);
                break;
            case 4:
                i = new Intent(this, RestaurantsList.class);
                i.putExtra("Type", R.array.Indian);
                break;
        }
        startActivity(i);

    }
}