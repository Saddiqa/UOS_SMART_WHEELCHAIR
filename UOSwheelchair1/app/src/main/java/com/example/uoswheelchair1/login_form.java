package com.example.uoswheelchair1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class login_form extends AppCompatActivity {

    EditText ed_email,ed_password;
    String   str_email,str_password;
    private String URL="https://asmazafar.000webhostapp.com/WheelChair/signup.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_form);
        getSupportActionBar().setTitle("Login");


        ed_email = findViewById(R.id.Email);
        ed_password = findViewById(R.id.Password);
    }

    public void btn_sginUp_form(View view) {

        startActivity(new Intent(getApplicationContext(),Signup_form.class));
    }


    public void Login(View view) {
        str_email = ed_email.getText().toString();
        str_password = ed_password.getText().toString();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                startActivity(new Intent(login_form.this,afterloginPage.class));                }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(login_form.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<String, String>();
                params.put("Email",str_email);
                params.put("Password",str_password);

                return params;
            }
        };
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    public int get(){
        return 1;
    }
}
