package com.example.asia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Input extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
    }
    public void perehod(View v)
    {
        Intent intent = new Intent( this, Registrasua.class);
        startActivity(intent);
    }
    public void iz(View v)
    {
        Intent intent = new Intent( this, Navigate.class);
        startActivity(intent);
    }
}