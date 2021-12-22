package com.example.restapidemo;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Response;
//import com.android.volley.Voll
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class WeatherDataService {
    private static final String QUERY_FOR_CITY_WEATHER_BY_ID = "https://www.metaweather.com/api/location/search/?query=";
    private static Context context = null;
    private static String cityID;

    public WeatherDataService(Context context){
        this.context = context;
    }

    public WeatherDataService() {

    }

    public interface ForeCastByIDResponse{
        void onError(String message);
        void onResponse(String cityID);

        void onResponse(List<WeatherReportModel> weatherReportModels);
    }

    public void getCityForecastByID(String cityID, ForeCastByIDResponse foreCastByIDResponse){
        List<WeatherReportModel> weatherReportModels = new ArrayList<>();
        String url = QUERY_FOR_CITY_WEATHER_BY_ID + cityID;

        //Get the JSON object
        JsonObjectRequest request = new JsonObjectRequest(url, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try{
                    Toast.makeText(context, response.toString(),Toast.LENGTH_LONG).show();
                    JSONArray consolodated_weather_list = response.getJSONArray("consolodated_weather");

                    //Get the first item in the array
                    for(int i = 0; i < consolodated_weather_list.length(); i++){
                        WeatherReportModel first_day = new WeatherReportModel();
                        JSONObject first_day_from_api = (JSONObject) consolodated_weather_list.get(i);
                        first_day.setId(first_day_from_api.getInt("id"));
                        first_day.setWeather_state_name(first_day_from_api.getString("weather_state_name"));
                        first_day.setWeather_state_abbr(first_day_from_api.getString("weather_state_abbr"));
                        first_day.setWind_direction_compass(first_day_from_api.getString("weather_direction_compass"));
                        first_day.setCreated(first_day_from_api.getString("created"));
                        first_day.setApplicable_date(first_day_from_api.getString("applicable_date"));
                        first_day.setMin_temp(first_day_from_api.getLong("min_temp"));
                        first_day.setMax_temp(first_day_from_api.getLong("max_temp"));
                        first_day.setThe_temp(first_day_from_api.getLong("the_temp"));
                        first_day.setWind_speed(first_day_from_api.getLong("wind_speed"));
                        first_day.setWind_direction(first_day_from_api.getLong("wind_direction"));
                        first_day.setAir_pressure(first_day_from_api.getInt("air_pressure"));
                        first_day.setHumidity(first_day_from_api.getInt("humidity"));
                        first_day.setVisibility(first_day_from_api.getLong("visibility"));
                        first_day.setPredictability(first_day_from_api.getInt("predicitability"));


                        /*
                        this.weather_state_abbr = weather_state_abbr;
                        this.wind_direction_compass = wind_direction_compass;
                        this.created = created;
                        this.applicable_date = applicable_date;
                        this.min_temp = min_temp;
                        this.max_temp = max_temp;
                        this.the_temp = the_temp;
                        this.wind_speed = wind_speed;
                        this.air_pressure = air_pressure;
                        this.humidity = humidity;
                        this.visibility = visibility;
                        this.predictability = predictability;
                        */
                    }
                }
                catch (Exception e){

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

    }

    /*
    private Object consolidated_weather_list(int i) {
        //return Request;
    }
    */

    public static String getCityID(String cityName, VolleyResponseListener volleyResponseListener){
        String url = QUERY_FOR_CITY_WEATHER_BY_ID + cityName;
        JsonArrayRequest request = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {

            /**
             * Called when a response is received.
             *
             * @param response
             */
            @Override
            public void onResponse(JSONArray response) {
                try {
                    Log.d("Weather data service", "onResponse: ");

                    //
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

    public interface GetCityForecastByNameCallback {
        void onError(String message);
        void onResponse(List<WeatherReportModel> weatherReportModels);
    }


    public void getCityForecastByName(String cityName, final GetCityForecastByNameCallback getCityForecastByNameCallback){
        //Fetch the city ID given the city name
        getCityID(cityName, new VolleyResponseListener(){

            @Override
            public void onError(String message) {

            }

            @Override
            public void onResponse(Object response) {

            }

            @Override
            public void onResponse(List<WeatherReportModel> weatherReportModels) {
                //We have the weather report
                getCityForecastByNameCallback.onResponse(weatherReportModels);
            }
        });
        //Fetch the city forecast give the city ID
    }


}
