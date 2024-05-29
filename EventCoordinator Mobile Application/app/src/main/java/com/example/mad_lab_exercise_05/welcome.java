package com.example.mad_lab_exercise_05;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class welcome extends AppCompatActivity {

    private EditText editText;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);

        editText = findViewById(R.id.editText);
        imageView = findViewById(R.id.imageView);

        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    updateImageView();
                }
            }
        });
    }

    private void updateImageView() {
        String enteredText = editText.getText().toString().trim();
        // You can use enteredText to determine which image to display.
        // For this example, we'll just use a default image.
        imageView.setImageResource(R.drawable.welcome);
    }
}
