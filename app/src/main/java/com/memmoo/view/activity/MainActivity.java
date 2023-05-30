package com.memmoo.view.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import com.memmoo.R;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;
import com.memmoo.view.fragment.InfoAppFragment;
import com.memmoo.view.fragment.NoteFragment;
import com.memmoo.view.fragment.ProfileFragment;

// 10120051
// Muhammad Bagas Adikara
// IF - 2
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        View decorView = getWindow().getDecorView();
        // Hide the status bar.
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        // Hide ActionBar
//        if (getSupportActionBar() != null) {
//            getSupportActionBar().hide();
//
//        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setSupportActionBar(findViewById(R.id.topAppBar));

        replaceFragment(new NoteFragment());
        MaterialToolbar toolbar = findViewById(R.id.topAppBar);
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.navigation_view);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                drawerLayout.openDrawer(GravityCompat.START);

            }
        });

        replaceFragment(new NoteFragment());
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull @org.jetbrains.annotations.NotNull MenuItem item) {

                int id = item.getItemId();
                item.setChecked(true);
                drawerLayout.closeDrawer(GravityCompat.START);
                switch (id)
                {

                    case R.id.nav_home:
                        replaceFragment(new NoteFragment());break;
                    case R.id.nav_profile:
                        replaceFragment(new ProfileFragment());break;
                    case R.id.nav_infoapp:
                        replaceFragment(new InfoAppFragment());break;
                    default:
                        return true;
                }
                return true;
            }
        });
    }

    private void replaceFragment(Fragment fragment){

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,fragment);
        fragmentTransaction.commit();
    }
}