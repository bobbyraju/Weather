package com.develogical;

import com.weather.Day;
import com.weather.Forecast;
import com.weather.Forecaster;
import com.weather.Region;

import java.util.HashMap;

/**
 * Created by ape11 on 18/01/2017.
 */
public class CachedForecaster{

    private final Forcasting forcasting;
    Integer temperature = null;
    HashMap<String,Integer> cache = new HashMap();

    public CachedForecaster(Forcasting forcasting) {
        this.forcasting = forcasting;
    }

    public int getForecastTemperature(Region region, Day day) {

        String key = region.toString() + ":" + day.toString();
        if (this.cache.containsKey(key)) {
            return this.cache.get(key).intValue();
        } else {
            temperature = forcasting.getForecastTemperature(region, day);
            this.cache.put(key , temperature);
            return temperature;
        }
    }

}
