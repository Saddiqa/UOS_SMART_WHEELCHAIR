package com.example.uoswheelchair1;

import androidx.appcompat.app.AppCompatActivity;
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

public class Requestform extends AppCompatActivity {

    EditText ed_CNIC,ed_homeAddress,ed_phoneNo,ed_packageStatus;
    String  str_CNIC,str_homeAddress,str_phoneNo,str_packageStatus;
    private String URL="https://asmazafar.000webhostapp.com/WheelChair/Requestform.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requestform);

        ed_CNIC = findViewById(R.id.CNIC);
        ed_homeAddress = findViewById(R.id.homeAddress);
        ed_phoneNo = findViewById(R.id.phoneNo);
        ed_packageStatus = findViewById(R.id.packageStatus);

    }

    public void wheelchairRequest(View view) {

        str_CNIC = ed_CNIC.getText().toString();
        str_homeAddress = ed_homeAddress.getText().toString();
        str_phoneNo = ed_phoneNo.getText().toString();
        str_packageStatus = ed_packageStatus.getText().toString();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(Requestform.this, response, Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Requestform.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<String, String>();
                params.put("CNIC",str_CNIC);
                params.put("homeAddress",str_homeAddress);
                params.put("phoneNo",str_phoneNo);
                params.put("packageStatus",str_packageStatus);

                return params;
            }
        };
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}
