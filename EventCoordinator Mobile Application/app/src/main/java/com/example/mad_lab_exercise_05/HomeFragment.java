package com.example.mad_lab_exercise_05;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Timer;
import java.util.TimerTask;


public class HomeFragment extends Fragment {

   RecyclerView recycler_view;
   AutoScrollAdapter autoScrollAdapter;
   LinearLayoutManager layoutManager;
    private int currentPosition = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recycler_view = view.findViewById(R.id.recycle);
        setrv();

       return view;
    }

    private void setrv() {
        layoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        recycler_view.setLayoutManager(layoutManager);
        autoScrollAdapter = new AutoScrollAdapter(getActivity());
        recycler_view.setAdapter(autoScrollAdapter);
        LinearSnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(recycler_view);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (getActivity() != null) { // Check if the fragment is attached to an activity
                    if (currentPosition < autoScrollAdapter.getItemCount() - 1) {
                        currentPosition++;
                    } else {
                        currentPosition = 0;
                    }
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            recycler_view.smoothScrollToPosition(currentPosition);
                        }
                    });
                }
            }
        }, 0, 3000);

    }
}