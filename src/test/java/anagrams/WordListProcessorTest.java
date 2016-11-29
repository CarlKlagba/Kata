package anagrams;

import org.junit.Test;
import org.springframework.util.StopWatch;

import java.util.List;

/**
 * Created by ippon on 22/11/16.
 */
public class WordListProcessorTest {
    @Test
    public void processTest(){
        StopWatch stwtch = new StopWatch(getClass().getSimpleName());
        WorldListFileReader wlfr = new WorldListFileReader("wordlist.txt");
        List<String> wl = wlfr.read();

        stwtch.start();
        WordListProcessor wlp = new WordListProcessor(wl);
        wlp.process();
        stwtch.stop();

        wlp.writeResult();
        System.out.println();
        System.out.println("Process time : ");
        System.out.println(stwtch.prettyPrint());
    }

}
