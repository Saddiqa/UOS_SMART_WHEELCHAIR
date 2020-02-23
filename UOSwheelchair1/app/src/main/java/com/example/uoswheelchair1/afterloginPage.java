package com.example.uoswheelchair1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class afterloginPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afterlogin_page);
        getSupportActionBar().setTitle("Home");
    }

    public void submit_Application(View view) {
        startActivity( new Intent(getApplicationContext(),Requestform.class));
    }

    public void function_Application(View view) {
        startActivity( new Intent(getApplicationContext(),functional_page.class));
    }
}
