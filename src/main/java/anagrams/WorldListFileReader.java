package anagrams;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by ippon on 23/11/16.
 */
public class WorldListFileReader {
    private String pathToFile;

    public WorldListFileReader(String pathToFile){
        this.pathToFile = pathToFile;
    }

    public List<String> read(){
        Stream<String> streamFile = null;
        try {
            streamFile = Files.lines(Paths.get(pathToFile));
        } catch (IOException e) {
            //On continue pour verifier si le fichier est dans les resources
        }

        try {
            streamFile = Files.lines(Paths.get(ClassLoader.getSystemResource(pathToFile).toURI()), Charset.forName("ISO-8859-1"));
        } catch (IOException | URISyntaxException e) {
            System.err.println("Erreur lors de la recuperation du fichier "+pathToFile + " : " +e.getMessage());
        }
        List list = new ArrayList<>();
        if(streamFile != null)
            streamFile.forEach(list::add);

        return list;
    }

}
