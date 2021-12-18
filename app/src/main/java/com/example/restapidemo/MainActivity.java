package com.example.restapidemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

//JSON meta data: https://www.metaweather.com/api/location/44418/
public class MainActivity extends AppCompatActivity {
    Button btn_cityID, btn_cityName, btn_getWeatherByID, getBtn_getWeatherByName;
    EditText et_dataInput;
    ListView lv_weatherReport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Assign values to each control on the layout.
        btn_cityID = findViewById(R.id.btn_getCityID);
        btn_cityName = findViewById(R.id.btn_getCityName);
        et_dataInput = findViewById(R.id.et_dataInput);
        btn_cityID.setOnClickListener(new View.OnClickListener() {
            @Override
            //This method runs everytime the decrypt button is clicked
            public void onClick(View v) {
                //Log statement to assure us that we have gotten here
                Log.d("Ran","Searching for the city ID");

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