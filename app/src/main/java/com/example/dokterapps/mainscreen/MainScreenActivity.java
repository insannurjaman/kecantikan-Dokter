package com.example.dokterapps.mainscreen;

import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.dokterapps.R;
import com.example.dokterapps.mainscreen.home.rekammedis.RekamMedisFragment;
import com.example.dokterapps.mainscreen.home.MotherHomeFragment;
import com.example.dokterapps.mainscreen.profile.ProfileFragment;

public class MainScreenActivity extends AppCompatActivity {
    public BottomNavigationView bottomNavigationView;
    private static Fragment selectedFragment;
    private static MainScreenActivity mainScreenActivity;
    public static int selectedMenuId;

    public static MainScreenActivity getInstance() {
        return mainScreenActivity;
    }
    Fragment home, unvailable;
    FragmentTransaction fragmentTransaction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        mainScreenActivity = this;
        home = new MotherHomeFragment();
        unvailable = new UnvailableFragment();

        selectedMenuId = R.id.menu_home;
        bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.menu_home:
                        selectedFragment = home;
                        break;
                    case R.id.menu_close:
                        selectedFragment = unvailable;

                }
                selectedMenuId = menuItem.getItemId();
                fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.content, selectedFragment);
                fragmentTransaction.commit();
                return true;
            }
        });
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.content, home);
        fragmentTransaction.commit();




    }



}

