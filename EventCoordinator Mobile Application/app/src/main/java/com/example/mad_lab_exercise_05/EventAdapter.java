package com.example.mad_lab_exercise_05;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder> {
    ArrayList<UploadEvent> list;
    Context context;

    public EventAdapter(ArrayList<UploadEvent> list, Context context) {
        this.list = list;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.completeevent, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView eventType, date, design, budget, expDesign, name, contact, eventVenue;
        ImageView uploadImage;


         public ViewHolder(@NonNull View itemView) {
             super(itemView);
             eventType = itemView.findViewById(R.id.eventType);
             date = itemView.findViewById(R.id.date);
             design = itemView.findViewById(R.id.design);
             budget = itemView.findViewById(R.id.budget);
             expDesign = itemView.findViewById(R.id.expDesign);
             name = itemView.findViewById(R.id.name);
             contact = itemView.findViewById(R.id.contact);
             eventVenue = itemView.findViewById(R.id.eventVenue);

             uploadImage= itemView.findViewById(R.id.uploadImage);
         }
     }
}
