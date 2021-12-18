package com.example.restapidemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

//JSON meta data: https://www.metaweather.com/api/location/44418/
public class MainActivity extends AppCompatActivity {
    Button btn_cityID, btn_getWeatherByID, getBtn_getWeatherByName;
    EditText et_dataInput;
    ListView lv_weatherReport;

    //This is the data                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        that will be shown in the listview component.;
    List<WeatherReportModel> forecastList = new ArrayList<>();

    //Default value for city if not provided by the user.
    String cityName = "Phoenix";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Assign values to each control on the layout.
        btn_cityID = findViewById(R.id.btn_getCityID);
        getBtn_getWeatherByName = findViewById(R.id.weather_name);
        btn_getWeatherByID = findViewById(R.id.btn_getWeatherById);
        et_dataInput = findViewById(R.id.et_dataInput);

        //Set the listeners for each button
        btn_getWeatherByID.setOnClickListener(new View.OnClickListener(){
            @Override
            //This method runs everytime the get weather by ID is taken
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "You clicked get weather by ID", Toast.LENGTH_LONG);
                Log.d("Ran","Getting the weather ID");
            }
        });

        btn_cityID.setOnClickListener(new View.OnClickListener() {
            @Override
            //This method runs everytime the city ID button is clicked
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "You clicked get city by ID", Toast.LENGTH_LONG);
                Log.d("Ran","Searching for the city ID");
                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                String url = "https://www.metaweather.com/api/location/search/?query=london";
                JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        JSONObject cityInfo;
                        Toast.makeText(MainActivity.this, response.toString(), Toast.LENGTH_SHORT).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, "Something is wrong.", Toast.LENGTH_SHORT).show();
                    }
                });
                //Test a string response from the provided URL.
                //StringRequest stringRequest =

                //displayDecryptedChatMessageCaesar();
                //Now prompt the user for the key to use for decrypting the message
                //DecryptionPopup decryptionPopup = new DecryptionPopup();
                //startActivity(new Intent(MainActivityJ.this,DecryptionPopup.class));
            }

        });
        /*
        btn_cityID.setOnClickListener ({

        });
        */
    }
}