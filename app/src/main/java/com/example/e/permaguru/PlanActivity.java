package com.example.e.permaguru;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;

import java.util.ArrayList;
import java.util.List;

public class PlanActivity extends AppCompatActivity {

    private List<Date> dates;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CollapsingToolbarLayout tl = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        tl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toMap();
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                //        .setAction("Action", null).show();

            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });

        dates = new ArrayList<>();
        dates.add(new Date(4, 5, 18, "act 1", "lorem ipsum",4));
        dates.add(new Date(5, 5, 18, "act 2", "lorem ipsum",5));
        dates.add(new Date(6, 5, 18, "act 3", "lorem ipsum",6));
        dates.add(new Date(7, 5, 18, "act 4", "lorem ipsum",7));
        dates.add(new Date(8, 5, 18, "act 5", "lorem ipsum",8));
        dates.add(new Date(4, 5, 18, "act 1", "lorem ipsum",4));
        dates.add(new Date(5, 5, 18, "act 2", "lorem ipsum",5));
        dates.add(new Date(6, 5, 18, "act 3", "lorem ipsum",6));
        dates.add(new Date(7, 5, 18, "act 4", "lorem ipsum",7));
        dates.add(new Date(8, 5, 18, "act 5", "lorem ipsum",8));
        dates.add(new Date(4, 5, 18, "act 1", "lorem ipsum",4));
        dates.add(new Date(5, 5, 18, "act 2", "lorem ipsum",5));
        dates.add(new Date(6, 5, 18, "act 3", "lorem ipsum",6));
        dates.add(new Date(7, 5, 18, "act 4", "lorem ipsum",7));
        dates.add(new Date(8, 5, 18, "act 5", "lorem ipsum",8));
        dates.add(new Date(4, 5, 18, "act 1", "lorem ipsum",4));
        dates.add(new Date(5, 5, 18, "act 2", "lorem ipsum",5));
        dates.add(new Date(6, 5, 18, "act 3", "lorem ipsum",6));
        dates.add(new Date(7, 5, 18, "act 4", "lorem ipsum",7));
        dates.add(new Date(8, 5, 18, "act 5", "lorem ipsum",8));

        RecyclerView calendar = (RecyclerView)findViewById(R.id.calendar);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        calendar.setLayoutManager(manager);

        //calendar.setOnItemTouchListener(new AdapterView.OnItemClickListener() {

            //@Override
            //public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                // TODO Auto-generated method stub

                // Here arg2 is a Postion
            //}
        //});

        RecycleAdapter adapter = new RecycleAdapter(dates);
        calendar.setAdapter(adapter);

    }

    protected void toMap() {
        Intent mapEntry = new Intent(PlanActivity.this, MapsActivity.class);
        //mapEntry.putExtra("Bar", daySelected);
        startActivity(mapEntry);
        //} else if (id == R.id.nav_slideshow) {
    }
}
