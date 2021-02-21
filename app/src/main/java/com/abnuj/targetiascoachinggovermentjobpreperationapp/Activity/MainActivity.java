package com.abnuj.targetiascoachinggovermentjobpreperationapp.Activity;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.abnuj.targetiascoachinggovermentjobpreperationapp.Fragments.SubjectFragment;
import com.abnuj.targetiascoachinggovermentjobpreperationapp.Fragments.VideosFragment;
import com.abnuj.targetiascoachinggovermentjobpreperationapp.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationMenu;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationMenu = findViewById(R.id.bottom_navigation_menu);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportFragmentManager().beginTransaction().replace(R.id.main_activity_fragment_container, new SubjectFragment()).commit();

        bottomNavigationMenu.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_activity_fragment_container, new SubjectFragment()).commit();
                        return true;
                    case R.id.videos:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_activity_fragment_container, new VideosFragment()).commit();
                        return true;
                }
                return true;
            }
        });


    }
}