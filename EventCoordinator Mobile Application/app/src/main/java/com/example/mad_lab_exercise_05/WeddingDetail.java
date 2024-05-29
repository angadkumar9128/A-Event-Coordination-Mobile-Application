package com.example.mad_lab_exercise_05;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

public class WeddingDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wedding_detail);

        Button wedRegister = findViewById(R.id.wedbutton2);

        Button weddingButton = findViewById(R.id.wedbutton1);

        weddingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                // Get the FragmentManager
                FragmentManager fragmentManager = getSupportFragmentManager();

                if (fragmentManager.getBackStackEntryCount() > 0) {
                    // If there are fragments in the back stack, pop the top fragment
                    fragmentManager.popBackStack();
                } else {
                    // If there are no fragments in the back stack, you can handle this case as needed
                    // For example, navigate to a different activity or finish the current activity
                    finish();
                }
            }
        });

        wedRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WeddingDetail.this, Register.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        // Handle the back button press here
        // You can perform any additional actions before navigating back if needed

        // Check if there are fragments in the back stack
        FragmentManager fragmentManager = getSupportFragmentManager();
        if (fragmentManager.getBackStackEntryCount() > 0) {
            // If there are fragments in the back stack, pop the top fragment
            fragmentManager.popBackStack();
        } else {

            super.onBackPressed();
        }
    }
}





