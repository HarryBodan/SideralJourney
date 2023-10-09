package com.example.sideraljourney;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class AchievementsFragment extends Fragment {

    List<Achievement> achievements;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_achievements, container, false);
        init(rootView);
        return rootView;
    }

    public void init(View rootView) {
        achievements = new ArrayList<>();
        achievements.add(new Achievement(01, "Eclipse Enthusiast\n", "Master the fundamentals!"));
        achievements.add(new Achievement(02, "Eclipse Explorer\n", "Uncover the mystery!"));
        achievements.add(new Achievement(03, "Celestial Guru\n", "Become a cosmic expert!"));
        achievements.add(new Achievement(04, "Eclipse Predictor\n", "Embrace the science!"));
        achievements.add(new Achievement(05, "Lunar vs Solar", "Distinguish the darkness!"));
        achievements.add(new Achievement(06, "Eclipse Season Scholar\n", "Timing is everything!"));


        AchievementAdapter achievementAdapter = new AchievementAdapter(achievements, getActivity());
        RecyclerView recyclerView = rootView.findViewById(R.id.listRecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(achievementAdapter);
    }
}