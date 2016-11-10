package datamuging.dao;

import static org.junit.Assert.*;

import datamunging.dao.WeatherFileDao;
import datamunging.domain.Weather;
import org.junit.Test;

/**
 * Created by Travail on 29/10/2016.
 */
public class WeatherFileDaoTest {

    @Test
    public void testGetSteamFileTest(){
        try {
            WeatherFileDao weatherFileDao = new WeatherFileDao("weather.dat");
            weatherFileDao.intialze();
            assertTrue(true);
        }catch (Exception e){
            fail("WeatherFileDao has been intialze properly");
        }

    }
    @Test
    public void getWeatherTest(){
        WeatherFileDao weatherFileDao = new WeatherFileDao("weather.dat");
        weatherFileDao.intialze();

        Weather weather =weatherFileDao.getWeather();

        assertEquals("Max Temperature of day 1 is not correct", 88, weather.getMaxTempOfDay(1));
        assertEquals("Min Temperature of day 1 is not correct", 59, weather.getMinTempOfDay(1));

        assertEquals("Min Temperature of day 19 is not correct", 81, weather.getMaxTempOfDay(19));
        assertEquals("Min Temperature of day 19 is not correct", 61, weather.getMinTempOfDay(19));

        assertEquals("Min Temperature of day 30 is not correct", 90, weather.getMaxTempOfDay(30));
        assertEquals("Min Temperature of day 30 is not correct", 45, weather.getMinTempOfDay(30));
    }

}
