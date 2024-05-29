package com.example.mad_lab_exercise_05;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;
import com.squareup.picasso.Picasso;

public class Register extends AppCompatActivity {
    TextView eventType, date, design, budget, expDesign, name, contact, eventVenue;
    ImageView uploadbtn, uploadImage;
    Button submit, back01;
    Uri ImageUri;
    RelativeLayout relativeLayout;
    ProgressDialog dialog;
    private FirebaseDatabase database;
    private FirebaseStorage firebaseStorage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        database = FirebaseDatabase.getInstance();
        firebaseStorage = FirebaseStorage.getInstance();
        dialog = new ProgressDialog(this);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setMessage("Please Wait...");
        dialog.setCancelable(false);
        dialog.setTitle("Event Uploading");
        dialog.setCanceledOnTouchOutside(false);




        eventType = findViewById(R.id.eventType);
        date = findViewById(R.id.date);
        design = findViewById(R.id.design);
        budget = findViewById(R.id.budget);
        expDesign = findViewById(R.id.expDesign);
        name = findViewById(R.id.name);
        contact = findViewById(R.id.contact);
        eventVenue = findViewById(R.id.eventVenue);


        uploadbtn = findViewById(R.id.uploadbtn);
        uploadImage= findViewById(R.id.uploadImage);
        relativeLayout = findViewById(R.id.relative);


        submit = findViewById(R.id.submit);
        back01 = findViewById(R.id.back01);



        // Set click listener for the back button
        back01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        uploadbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadbtn();
                relativeLayout.setVisibility(View.VISIBLE);
                uploadbtn.setVisibility(View.GONE);

            }


        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.show();

                final StorageReference reference=firebaseStorage.getReference().child("Event")
                        .child(System.currentTimeMillis()+"");
                reference.putFile(ImageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        reference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                            @Override
                            public void onSuccess(Uri uri) {
                                UploadEvent model = new UploadEvent();
                                model.setUploadImage(uri.toString());
                                model.setEventType(eventType.getText().toString());
                                model.setDate(date.getText().toString());
                                model.setDesign(design.getText().toString());
                                model.setBudget(budget.getText().toString());
                                model.setExpDesign(expDesign.getText().toString());
                                model.setName(name.getText().toString());
                                model.setContact(contact.getText().toString());
                                model.setEventVenue(eventVenue.getText().toString());


                                database.getReference().child("Event").push().setValue(model)
                                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                                            @Override
                                            public void onSuccess(Void unused) {
                                                dialog.dismiss();
                                                Toast.makeText(Register.this,"Event upload Sucessfully ",Toast.LENGTH_SHORT).show();
                                                dialog.dismiss();

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
                                        }).addOnFailureListener(new OnFailureListener() {
                                            @Override
                                            public void onFailure(@NonNull Exception e) {
                                                Toast.makeText(Register.this,"Error Occurred",Toast.LENGTH_SHORT).show();
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



                            }
                        });
                    }
                });

            }
        });

    }


    private void uploadbtn() {

        Dexter.withContext(Register.this)
                .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                        Intent intent = new Intent();
                        intent.setType("image/*");
                        intent.setAction(Intent.ACTION_GET_CONTENT);
                        startActivityForResult(intent,101);

                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {
                        Toast.makeText(Register.this,"Permission Denied",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                        permissionToken.continuePermissionRequest();
                    }
                }).check();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 101 && resultCode == RESULT_OK) {
            ImageUri = data.getData();
            if (ImageUri != null) {
                // Load the image into the ImageView using Picasso
                Picasso.get().load(ImageUri).into(uploadImage);
            }
        }
        else {
            System.out.println("ImageUri is null");
        }
    }
}