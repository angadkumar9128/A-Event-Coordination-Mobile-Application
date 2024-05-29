package com.example.mad_lab_exercise_05;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;

public class ProfileFragment extends Fragment {
    private FirebaseAuth auth;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_profile, container, false);
        auth = FirebaseAuth.getInstance();

        Button logoutButton = rootView.findViewById(R.id.logoutButton);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Attempt to sign out the user
                auth.signOut();

                // Check if signout was successful or failed
                if (auth.getCurrentUser() == null) {
                    // User is successfully signed out
                    Toast.makeText(getActivity(), "Logout Successful", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(getActivity(), MainActivitylogin.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    getActivity().finish();

                } else {
                    // Signout failed
                    Toast.makeText(getActivity(), "Logout Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return rootView;
    }
}
