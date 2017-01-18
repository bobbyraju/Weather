package com.develogical;


import com.weather.Day;
import com.weather.Forecast;
import com.weather.Forecaster;
import com.weather.Region;

/**
 * Created by ape11 on 18/01/2017.
 */
public class ForecasterAdapter implements Forcasting {
    @Override
    public int getForecastTemperature(Region region, Day day) {

        Forecaster forcaster = new Forecaster();
        Forecast forecast = forcaster.forecastFor(region,day);
        System.out.println(forecast.temperature());
        return forecast.temperature();
    }
}
