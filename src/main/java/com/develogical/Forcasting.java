package com.develogical;

import com.weather.Day;
import com.weather.Region;

/**
 * Created by ape11 on 18/01/2017.
 */
public interface Forcasting {

    public int getForecastTemperature(Region region, Day day);
}
