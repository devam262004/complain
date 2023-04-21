package com.example.myapplication;

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
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {


    BottomNavigationView bottom_navigation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        bottom_navigation=findViewById(R.id.bottom_navigation);



        bottom_navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId())
                {
                    case R.id.Home:
                        replaceFragment(new HomeFragment());break;


                    case R.id.Chat:
                        replaceFragment(new ChathelpFragment());
                        break;

                    case R.id.Complain:
                        replaceFragment(new complainrequestFragment());break;

                    case R.id.Circular:
                        replaceFragment(new CircularFragment());
                }

                return true;
            }
        });





        MaterialToolbar toolbar = findViewById(R.id.topAppBar);
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.navigation_view);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                drawerLayout.openDrawer(GravityCompat.START);

            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull @org.jetbrains.annotations.NotNull MenuItem item) {

                int id = item.getItemId();
                item.setChecked(true);
                drawerLayout.closeDrawer(GravityCompat.START);
                switch (id) {

                    case R.id.nav_home:
                        replaceFragment(new HomeFragment());break;
                    case R.id.nav_chat:
                        replaceFragment(new ChathelpFragment());break;
                    case R.id.nav_map:
                        replaceFragment(new MapFragment());break;
                    case R.id.circular:
                        replaceFragment(new CircularFragment());break;
                    case R.id.nav_login:
                        replaceFragment(new LoginFragment());break;
                    case R.id.nav_complainrequest:
                        replaceFragment(new complainrequestFragment());break;
                    case R.id.nav_complainstatus:
                       replaceFragment(new ComplainstatusFragment());break;
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