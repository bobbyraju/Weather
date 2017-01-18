package com.develogical;

import com.weather.Day;
import com.weather.Forecaster;
import com.weather.Region;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.jmock.*;

import java.security.Timestamp;
import java.sql.Date;
import java.sql.Time;

import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by ape11 on 18/01/2017.
 */
public class CachedForecasterTest {

    @Test
    public void isCachingTemperature() {
        Mockery context = new Mockery();
        final Forcasting forcasting = context.mock(Forcasting.class);
        CachedForecaster cachedForecaster = new CachedForecaster(forcasting);
        context.checking(new Expectations(){{
            oneOf(forcasting).getForecastTemperature(Region.LONDON, Day.MONDAY);
            will(returnValue(25));

        }});

        Assert.assertThat(cachedForecaster.getForecastTemperature(Region.LONDON, Day.MONDAY), equalTo(25));
        Assert.assertThat(cachedForecaster.getForecastTemperature(Region.LONDON, Day.MONDAY), equalTo(25));
    }

    @Test
    public void doesNotReadCacheForDifferentRegionsOrDays() {
        Mockery context = new Mockery();
        final Forcasting forcasting = context.mock(Forcasting.class);
        CachedForecaster cachedForecaster = new CachedForecaster(forcasting);
        context.checking(new Expectations(){{
            oneOf(forcasting).getForecastTemperature(Region.LONDON, Day.MONDAY);
            will(returnValue(25));
            oneOf(forcasting).getForecastTemperature(Region.EDINBURGH, Day.MONDAY);
            will(returnValue(32));

        }});
        Assert.assertThat(cachedForecaster.getForecastTemperature(Region.LONDON, Day.MONDAY), equalTo(25));
        Assert.assertThat(cachedForecaster.getForecastTemperature(Region.EDINBURGH, Day.MONDAY), equalTo(32));
    }
    
//    @Test
//    public void dataShouldBeCachedForUpToOneHour() {
//        Mockery context = new Mockery();
//        final Forcasting forcasting = context.mock(Forcasting.class);
//        CachedForecaster cachedForecaster = new CachedForecaster(forcasting);
//        context.checking(new Expectations(){{
//            oneOf(forcasting).getForecastTemperature(Region.LONDON, Day.MONDAY);
//            will(returnValue(25));
//            oneOf(forcasting).getForecastTemperature(Region.EDINBURGH, Day.MONDAY);
//            will(returnValue(32));
//
//        }});
//
//        Assert.assertThat(cachedForecaster.getForecastTemperature(Region.LONDON, Day.MONDAY), equalTo(25));
//        Assert.assertThat(cachedForecaster.getForecastTemperature(Region.EDINBURGH, Day.MONDAY), equalTo(32));
//    }
}
