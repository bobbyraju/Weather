package com.develogical;

import com.weather.Day;
import com.weather.Forecaster;
import com.weather.Region;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
/**
 * Created by ape11 on 18/01/2017.
 */
public class ForecasterAdapterTest {
    @Test
    public void ShouldGetForecastedDetails() {
        ForecasterAdapter forecasterAdapter = new ForecasterAdapter();
        Assert.assertTrue(forecasterAdapter.getForecastTemperature(Region.LONDON, Day.MONDAY) > -100);
    }
}
