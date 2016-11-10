package datamuging.service;

import datamunging.domain.Day;
import datamunging.domain.Weather;
import datamunging.repository.WeatherRespository;
import datamunging.service.WeatherService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Travail on 06/11/2016.
 */
public class WeatherServiceTest {



    @Test
    public void calculateDayWithMinSpreadTest(){
        List<Day>  days = Arrays.asList(
                new Day(1, 34, 24),
                new Day(2, 23, 21),
                new Day(3, 30, 15)
        );
        Map<Integer, Day> daysMap = days.stream()
                .collect(Collectors.toMap(day -> day.getNumber(), day -> day));
        Weather weather = new Weather(daysMap);

        WeatherRespository weatherRespository = mock(WeatherRespository.class);

        when(weatherRespository.getWeather()).thenReturn(weather);

        WeatherService weatherService = new WeatherService(weatherRespository);
        int actualDay = weatherService.calculateDayWithMinSpread();
        Assert.assertEquals("",2, actualDay);
    }
}
