package com.example.asia;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asia.Fragments.Glavnay_Fragment;
import com.example.asia.Fragments.Izbrannoe_Fragment;
import com.example.asia.Fragments.KInoAndSerial;
import com.example.asia.Fragments.Nastroiki_Fragment;
import com.example.asia.Fragments.SpiskiFragment;
import com.google.android.material.navigation.NavigationView;

import java.text.BreakIterator;
import java.util.Base64;

public class Navigate extends AppCompatActivity{

    public static int index;
    public static int role;
    public static String  name;
    public static String  photo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigate);
        Bundle arguments = getIntent().getExtras();
        index = arguments.getInt("key");
        role=arguments.getInt("role");
        name=arguments.getString("name");
        photo=arguments.getString("photo");
      final TextView nameuser=findViewById(R.id.NameUsers);
     final ImageView photouser=findViewById(R.id.imageViewUsers);


       /* nameuser.setText(name);
        photouser.setImageBitmap(getImgBitmap(photo));*/

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

        final TextView textTitle = findViewById(R.id.textTitle);

        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController navController, @NonNull NavDestination navDestination, @Nullable Bundle bundle) {
                textTitle.setText(navDestination.getLabel());

            }
        });

    }

    private Bitmap getImgBitmap(String encodedImg) {
        if(encodedImg!=null&& !encodedImg.equals("null")) {
            byte[] bytes = new byte[0];
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                bytes = Base64.getDecoder().decode(encodedImg);
            }
            return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
        }
        else{
            return BitmapFactory.decodeResource(Navigate.this.getResources(),
                    R.drawable.users);
        }

    }


}