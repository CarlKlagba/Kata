package datamunging.service;

import datamunging.domain.Day;
import datamunging.domain.Weather;
import datamunging.repository.WeatherRespository;

import java.util.Comparator;

/**
 * Created by Travail on 29/10/2016.
 */
public class WeatherService {
    WeatherRespository weatherRespository;
    public WeatherService(WeatherRespository respository){
        weatherRespository = respository;
    }

    public int calculateDayWithMinSpread(){
        Weather weather = weatherRespository.getWeather();

        Day dayWithMinSpread = weather.getDays().stream()
            .min(Comparator.comparing(day -> day.getMaxTemps() - day.getMinTemps()))
            .get();

        return dayWithMinSpread.getNumber();
    }

}
