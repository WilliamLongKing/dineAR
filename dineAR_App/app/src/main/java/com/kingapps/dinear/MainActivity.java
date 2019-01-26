package com.kingapps.dinear;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerViewAdapter.OnRestaurantListener {

    private ArrayList<String> mNames = new ArrayList<>();
    ArrayList<Restaurant> restaurantList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
        getSupportActionBar().hide(); //hide the title bar
        setContentView(R.layout.activity_main);
        initData();
        ImageButton visualize = findViewById(R.id.visualize);
        visualize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fileIntent = new Intent(MainActivity.this, RestaurantActivity.class);
                MainActivity.this.startActivity(fileIntent);

            }
        });
    }

    private void initData() {
        mNames.add("Deltahacks");
        mNames.add("McDonalds");
        mNames.add("Second Cup");
        mNames.add("Burger King");
        mNames.add("Starbucks");
        mNames.add("Tim Hortons");
        initRecyclerView();
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(mNames, this, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onRestaurantClick(int position) {
        mNames.get(position);
        Intent intent = new Intent(this, FoodActivity.class);
        startActivity(intent);
    }
}
