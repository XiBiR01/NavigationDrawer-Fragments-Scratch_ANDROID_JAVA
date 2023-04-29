package com.example.navigationdrawerwithfragment_scratch;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import static com.example.navigationdrawerwithfragment_scratch.R.id.home;
import static com.example.navigationdrawerwithfragment_scratch.R.string.close;
import static com.example.navigationdrawerwithfragment_scratch.R.string.open;

public class MainActivity extends AppCompatActivity {
    NavigationView navDrawer;
    DrawerLayout drawer;
    Toolbar toolbar;
    ActionBarDrawerToggle toggle;
    ConstraintLayout fragContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawer = findViewById(R.id.drawerLayout);
        navDrawer = findViewById(R.id.navDrawer);
        toolbar = findViewById(R.id.toolbar);
        fragContainer = findViewById(R.id.fragContainer);

//        Implementing NavDrawer
        toggle = new ActionBarDrawerToggle(this, drawer, R.string.drawer_open, R.string.drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

//        Replace Toolbar with our Custom Toolbar
//        setSupportActionBar(toolbar);



//        Display an Arrow instead of Hamburger Icon when Drawer is Open
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//        NavDrawer EventClickListeners
        navDrawer.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.home:
                        BlankFragment homeFrag= BlankFragment.newInstance("Home");
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragContainer, homeFrag).commit();
                        drawer.close();
                        getSupportActionBar().setTitle("Home");
                        break;
                    case R.id.status:
                        BlankFragment statusFrag=BlankFragment.newInstance("Status");
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragContainer, statusFrag).commit();
                        drawer.close();
                        getSupportActionBar().setTitle("Status");
                        break;
                    case R.id.calls:
                        BlankFragment callsFrag=BlankFragment.newInstance("Calls");
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragContainer, callsFrag).commit();
                        drawer.close();
                        getSupportActionBar().setTitle("Calls");
                        break;

                }
                return true;
            }
        });


    }
//NavDrawer EventClickListeners Activation-->
//    Important for the navDrawer to work
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}