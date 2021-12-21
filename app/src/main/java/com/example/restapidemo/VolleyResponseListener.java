package com.example.restapidemo;

import java.util.List;

public interface VolleyResponseListener {
    void onError(String message);

    void onResponse(Object response);

    void onResponse(List<WeatherReportModel> weatherReportModels);
}
