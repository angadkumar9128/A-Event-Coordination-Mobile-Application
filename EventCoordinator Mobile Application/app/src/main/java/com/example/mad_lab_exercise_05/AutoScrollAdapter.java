package com.example.mad_lab_exercise_05;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AutoScrollAdapter extends RecyclerView.Adapter<AutoScrollAdapter.ViewHolder>  {
    private Context context;
    private int[] imageResources = {R.drawable.birthday1, R.drawable.birthday2, R.drawable.wed1 ,R.drawable.wed2 ,R.drawable.dead,R.drawable.dead2,R.drawable.cer,R.drawable.cer2,R.drawable.puja,R.drawable.puja2};
    private String[] titles = {"Title 1", "Title 2", "Title 3","Title 4","Title 5","Title 6","Title 7","Title 8","Title 9","Title 10"}; // Add your titles


    public AutoScrollAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rv_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override

    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int imageResource = imageResources[position % imageResources.length];
        String title = titles[position % imageResources.length]; // Use imageResources.length to cycle through titles


        holder.imageView.setImageResource(imageResource);
        holder.titleTextView.setText(title);

    }


    @Override
    public int getItemCount() {
        return Integer.MAX_VALUE; // To make it seem like an infinite list
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView titleTextView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView1);
            titleTextView = itemView.findViewById(R.id.titleTextView1);

            imageView = itemView.findViewById(R.id.imageView2);
            titleTextView = itemView.findViewById(R.id.titleTextView2);

            imageView = itemView.findViewById(R.id.imageView3);
            titleTextView = itemView.findViewById(R.id.titleTextView3);

            imageView = itemView.findViewById(R.id.imageView3);
            titleTextView = itemView.findViewById(R.id.titleTextView3);


        }
    }
}
