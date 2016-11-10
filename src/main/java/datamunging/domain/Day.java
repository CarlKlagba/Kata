package datamunging.domain;

/**
 * Created by Travail on 29/10/2016.
 */
public class Day {
    private int number;
    private int maxTemps;
    private int minTemps;

    public Day(int number, int maxTemps, int minTemps) {
        this.number = number;
        this.maxTemps = maxTemps;
        this.minTemps = minTemps;
    }

    public int getNumber() {
        return number;
    }

    public int getMaxTemps() {
        return maxTemps;
}

    public int getMinTemps() {
        return minTemps;
    }
}


