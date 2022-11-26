package com.example.asia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Registrasua extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrasua);
    }
    public void perehod(View v)
    {
        Intent intent = new Intent( this, Input.class);
        startActivity(intent);
    }
}