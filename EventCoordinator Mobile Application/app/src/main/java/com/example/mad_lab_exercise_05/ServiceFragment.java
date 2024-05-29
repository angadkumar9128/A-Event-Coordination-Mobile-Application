package com.example.mad_lab_exercise_05;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

public class ServiceFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_service, container, false);

        // Find the CardView elements by their IDs
        CardView birthdayCardView = view.findViewById(R.id.birthday);
        CardView weddingCardView = view.findViewById(R.id.wedding);
        CardView corporateCardView = view.findViewById(R.id.corporate);
        CardView ceremonyCardView = view.findViewById(R.id.ceremony);
        CardView conferenceCardView = view.findViewById(R.id.conference);
        CardView specialCardView = view.findViewById(R.id.special);

        // Set OnClickListener for each CardView
        birthdayCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle click for Venue CardView
                Intent intent = new Intent(getActivity(), BirthdayDetail.class);
                startActivity(intent);

                // Add your logic for handling the click here
            }
        });

        weddingCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle click for Book CardView
                Intent intent = new Intent(getActivity(), WeddingDetail.class);
                startActivity(intent);

                // Add your logic for handling the click here
            }
        });

        corporateCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CorporateDetail.class);
                startActivity(intent);
            }
        });

        ceremonyCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CeremonyDetail.class);
                startActivity(intent);
            }
        });

        conferenceCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ConferenceDetail.class);
                startActivity(intent);
            }
        });

        specialCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle click for Logout CardView
                Intent intent = new Intent(getActivity(), SpecialDetail.class);
                startActivity(intent);
                Toast.makeText(getActivity(), "special Clicked", Toast.LENGTH_SHORT).show();
                // Add your logic for handling the click here
            }
        });

        return view;
    }
}
