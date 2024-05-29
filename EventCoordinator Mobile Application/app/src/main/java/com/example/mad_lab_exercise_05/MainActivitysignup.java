package com.example.mad_lab_exercise_05;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivitysignup extends AppCompatActivity {

    private FirebaseAuth auth;
    private EditText name, emailsignup,passwordsignup,phone;
    private Button signup,returnbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activitysignup);
        auth = FirebaseAuth.getInstance();
        signup = findViewById(R.id.signup);
        returnbutton= findViewById(R.id.returnbutton);
        emailsignup = findViewById(R.id.emailsignup);
        name = findViewById(R.id.name);
        phone = findViewById(R.id.phone);
        passwordsignup = findViewById(R.id.passwordsignup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = emailsignup.getText().toString().trim();
                String pass = passwordsignup.getText().toString().trim();


                if (user.isEmpty()){
                    emailsignup.setError("email cannot be Empty");
                }
                else if (pass.isEmpty()){
                  passwordsignup .setError("password cannot be Empty");
                }

                 else {
                     auth.createUserWithEmailAndPassword(user,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                         @Override
                         public void onComplete(@NonNull Task<AuthResult> task) {
                             if (task.isSuccessful()){
                                 Toast.makeText(MainActivitysignup.this,"Sucessfully SignUp",Toast.LENGTH_SHORT).show();
                                 startActivity(new Intent(MainActivitysignup.this,MainActivitylogin.class));
                             }
                             else {
                                 Toast.makeText(MainActivitysignup.this, "SignUp Failed", Toast.LENGTH_SHORT).show();
                             }
                         }
                     });
                }


            }
        });

        returnbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             startActivity(new Intent(MainActivitysignup.this,MainActivitylogin.class));
            }
        });
    }
}