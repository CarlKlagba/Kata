package datamunging.dao;

import datamunging.domain.Day;
import datamunging.domain.Weather;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Travail on 29/10/2016.
 */
public class WeatherFileDao implements AbstractWeatherDao {

    String pathToFile;
    Stream<String> streamFile;

    public WeatherFileDao(String pathToFile){
        this.pathToFile =  pathToFile;
    }

    public void intialze(){

        try {
            streamFile = Files.lines(Paths.get(pathToFile));
        } catch (IOException e) {
            //On continue pour verifier si le fichier est dans les resources
        }

        try {
            streamFile = Files.lines(Paths.get(ClassLoader.getSystemResource(pathToFile).toURI()));
        } catch (IOException | URISyntaxException e) {
            System.err.println("Erreur lors de la recuperation du fichier "+pathToFile + " : " +e.getMessage());
        }


    }

    public Weather getWeather(){
        if(streamFile == null){
            intialze();
        }
        List<String> weatherFileLignes = streamFile
                .filter(line -> !line.startsWith("  Dy") && !line.isEmpty() && !line.startsWith("  mo"))
                .map(ligne -> ligne.replaceAll("\\s\\s*", " ").replaceFirst("\\s", "").replaceAll("\\*",""))
                .collect(Collectors.toList());

        return parsOutWeather(weatherFileLignes);
    }
    private Weather parsOutWeather(List<String> lignes){
       Map<Integer, Day> daysMap = lignes.stream()
               .map(ligne -> parseOutDay(ligne))
               .collect(Collectors.toMap(day -> day.getNumber(), day -> day));
        return new Weather(daysMap);
    }
    private Day parseOutDay(String ligne){
        String[] splitedLigne = ligne.split(" ");
        return new Day(Integer.parseInt(splitedLigne[0]), Integer.parseInt(splitedLigne[1]), Integer.parseInt(splitedLigne[2]));

    }

    
}
