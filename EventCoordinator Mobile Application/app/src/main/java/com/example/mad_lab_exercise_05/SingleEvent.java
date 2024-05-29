package com.example.mad_lab_exercise_05;



import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class SingleEvent extends AppCompatActivity {
    TextView singleTitle, singleVenue, singleBudget, singleDesign;
    ImageView singleImg;
    Button sinBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_single_event);
        singleTitle = findViewById(R.id.singleTitle);
        singleVenue = findViewById(R.id.singleVenue);
        singleBudget = findViewById(R.id.singleBudget);
        singleDesign = findViewById(R.id.singleDesign);
        singleImg = findViewById(R.id.singleImg);

        sinBack = findViewById(R.id.sinBack); // Fix the button ID

        // Set click listener for the back button
        sinBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        Picasso.get().load(getIntent().getStringExtra("singleImg"))
                .placeholder((R.drawable.birthday))
                .into(singleImg);
        singleTitle.setText(getIntent().getStringExtra("singleTitle"));
        singleVenue.setText(getIntent().getStringExtra("singleVenue"));
        singleBudget.setText(getIntent().getStringExtra("singleBudget"));
        singleDesign.setText(getIntent().getStringExtra("singleDesign"));

    }
}