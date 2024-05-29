package com.example.mad_lab_exercise_05;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mad_lab_exercise_05.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivitylogin extends AppCompatActivity {

    private FirebaseAuth auth;
    private EditText email , password;
    Button login , register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activitylogin);
        auth = FirebaseAuth.getInstance();
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
        register =findViewById(R.id.register);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Email_login = email.getText().toString();
                String password_login = password.getText().toString();

                 if(!Email_login.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(Email_login).matches()){
                      if (!password_login.isEmpty()){
                          auth.signInWithEmailAndPassword(Email_login ,password_login).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                              @Override
                              public void onSuccess(AuthResult authResult) {
                                  Toast.makeText(MainActivitylogin.this, "Login Sucessful", Toast.LENGTH_SHORT).show();
                                  startActivity(new Intent(MainActivitylogin.this,MainActivity.class));
                                  finish();
                              }
                          }).addOnFailureListener(new OnFailureListener() {
                              @Override
                              public void onFailure(@NonNull Exception e) {
                                  Toast.makeText(MainActivitylogin.this, "Login Failed: ", Toast.LENGTH_SHORT).show();
                              }

                          });
                      }
                      else {
                          password.setError("Password cannot be Empty");
                      }

                 } else if (Email_login.isEmpty()) {
                     email.setError("Email cannot be Empty");
                 }
                 else {
                     email.setError("Please Enter valid Email");
                 }
            }
        });

      register.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              startActivity(new Intent(MainActivitylogin.this,MainActivitysignup.class));
          }
      });

    }
}