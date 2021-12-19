package com.example.restapidemo;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONObject;
import java.util.List;

public class WeatherDataService {
    private static String query = "https://www.metaweather.com/api/location/search/?query=";
    private static Context context = null;
    private static String cityID;

    public WeatherDataService(Context context){
        this.context = context;
    }

    public WeatherDataService() {

    }

    public static String getCityID(String cityName){
        String url = query + cityName;
        JsonArrayRequest request = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            /**
             * Called when a response is received.
             *
             * @param response
             */
            @Override
            public void onResponse(JSONArray response) {
                try {
                    cityID = "";
                    JSONObject cityInfo = null;
                    cityID = cityInfo.getString("woeid");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Log.d("Weather data service", "onResponse: ");
                //Toast.makeText(WeatherDataService.this, response.toString(), Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Weather data service", "onErrorResponse: ");
            }
        });
        MySingleton.getInstance(context).addToRequestQueue(request);
        //MySingleton singleton


        /*
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try
                {
                    JSONObject cityInfo = null;
                    String cityID = cityInfo.getString("woeid");
                }
                catch (Exception e)
                {

                }
                //Toast.makeText(WeatherDataService.this, response.toString(), Toast.LENGTH_SHORT).show();
            }
        });
        */

        return cityID;
    }

    /*
    public List<WeatherReportModel> getCityForecastByID(String cityID){

    }

    public List<WeatherReportModel> getCityForecastByName(String cityName){

    }
    */
}
