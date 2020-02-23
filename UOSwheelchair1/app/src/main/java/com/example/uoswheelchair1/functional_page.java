package com.example.uoswheelchair1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class functional_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_functional_page);
        getSupportActionBar().setTitle("Function");
    }

    public void TOP(View view) {
        startActivity( new Intent(getApplicationContext(),bluetooth.class));

    }

    public void Right(View view) {
        startActivity( new Intent(getApplicationContext(),bluetooth.class));

    }

    public void left(View view) {
        startActivity( new Intent(getApplicationContext(),bluetooth.class));

    }

    public void Bottom(View view) {
        startActivity( new Intent(getApplicationContext(),bluetooth.class));

    }
}
