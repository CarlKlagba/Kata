package datamunging.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Travail on 29/10/2016.
 */
public class Weather {
    Map<Integer, Day> days;

    public Weather(Map<Integer, Day> days){
        this.days = days;
    }

    public int getMinTempOfDay(int dayNumber){
        return days.get(dayNumber).getMinTemps();
    }

    public int getMaxTempOfDay(int dayNumber){
        return days.get(dayNumber).getMaxTemps();
    }

    public List<Day> getDays() {
        return new ArrayList<Day>(days.values());
    }
}
