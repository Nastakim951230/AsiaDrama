package com.example.asia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;

import com.example.asia.Fragments.Glavnay_Fragment;
import com.example.asia.Fragments.Izbrannoe_Fragment;
import com.example.asia.Fragments.Nastroiki_Fragment;
import com.example.asia.Fragments.SpiskiFragment;
import com.google.android.material.navigation.NavigationView;

public class Navigate extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigate);

        final DrawerLayout drawerLayout=findViewById(R.id.navigas);

        findViewById(R.id.imageMenu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
 NavigationView navigationView=findViewById(R.id.nav_view);
        navigationView.setItemIconTintList(null);

        NavController navController= Navigation.findNavController(this,R.id.navHostFragment);
        NavigationUI.setupWithNavController(navigationView,navController);

    }


}