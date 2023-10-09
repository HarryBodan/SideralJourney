package com.example.sideraljourney;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import com.example.sideraljourney.databinding.ActivityMainBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        replaceFragment(new AchievementsFragment());
        binding.bottomNavigationView.setBackground(null);

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {

            if (item.getItemId() == R.id.achievements) {
                replaceFragment(new AchievementsFragment());
            } else if (item.getItemId() == R.id.sun) {
                replaceFragment(new SunFragment());
            } else if (item.getItemId() == R.id.earth) {
                replaceFragment(new EarthFragment());
            } else if (item.getItemId() == R.id.moon) {
                replaceFragment(new MoonFragment());
            } else if (item.getItemId() == R.id.user) {
                replaceFragment(new UserFragment());
            }
            return true;
        });

        FloatingActionButton floatingActionButton = findViewById(R.id.floating);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new EarthFragment());
                binding.bottomNavigationView.setSelectedItemId(R.id.earth);
            }
        });
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }
}