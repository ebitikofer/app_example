package com.example.e.permaguru;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by e on 11/15/17.
 */

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.DateViewHolder>{

    private List<Date> dates;

    public static class DateViewHolder extends RecyclerView.ViewHolder {
        CardView date;
        TextView activity;
        TextView description;
        ImageView number;

        DateViewHolder(View itemView) {
            super(itemView);
            date = (CardView)itemView.findViewById(R.id.date);
            activity = (TextView)itemView.findViewById(R.id.activity);
            description = (TextView)itemView.findViewById(R.id.description);
            number = (ImageView)itemView.findViewById(R.id.number);
        }
    }

    public RecycleAdapter(List<Date> dates){
        this.dates = dates;
    }

    @Override
    public int getItemCount() {
        return dates.size();
    }

    @Override
    public DateViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.date_card, viewGroup, false);
        DateViewHolder dvh = new DateViewHolder(v);
        return dvh;
    }

    @Override
    public void onBindViewHolder(DateViewHolder dateViewHolder, int i) {
        dateViewHolder.activity.setText(dates.get(i).name);
        dateViewHolder.description.setText(Integer.toString(dates.get(i).month) + "/" + Integer.toString(dates.get(i).year));
        //dateViewHolder.number.setImageResource(dates.get(i).id);
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }



}
