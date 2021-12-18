package com.example.restapidemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.List;

//JSON meta data: https://www.metaweather.com/api/location/44418/
public class MainActivity extends AppCompatActivity {
    Button btn_cityID, btn_cityName, btn_getWeatherByID, getBtn_getWeatherByName;
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
        btn_cityName = findViewById(R.id.btn_getCityName);
        et_dataInput = findViewById(R.id.et_dataInput);
        btn_cityID.setOnClickListener(new View.OnClickListener() {
            @Override
            //This method runs everytime the decrypt button is clicked
            public void onClick(View v) {
                                                                                       Log.d("Ran","Searching for the city ID");
                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                String url = "https://www.metaweather.com/api/location/search/?query=london";

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