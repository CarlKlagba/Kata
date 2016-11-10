package datamunging.repository;

import datamunging.dao.AbstractWeatherDao;
import datamunging.domain.Weather;

/**
 * Created by Travail on 29/10/2016.
 */
public class WeatherRespository {
    AbstractWeatherDao weatherDao;
    public WeatherRespository(AbstractWeatherDao weatherDao){
        this.weatherDao = weatherDao;
    }

    public Weather getWeather(){
        return weatherDao.getWeather();
    }
}
