package anagrams;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by ippon on 17/11/16.
 */
public class AnagramUtilsTest {

    @Test
    public void areAllAnagramTest(){
        String word = "kinship pinkish";
        testAreAllAnagram(word, true);
    }
    @Test
    public void areAllAnagram_mutiple_word_Test(){
        String words = "paste pates peats septa spate tapes tepas";
        testAreAllAnagram(words, true);
    }

    @Test
    public void areNotAllAnagram_multiple_letter_Test(){
        String word = "azerrrrty zaertyyyy";
        testAreAllAnagram(word, false);
    }

    @Test
    public void areNotAllAnagram_different_length_Test(){
        String word = "fish cat";
        testAreAllAnagram(word, false);
    }

    @Test
    public void areNotAllAnagram_same_length_Test(){
        String word = "fish same";
        testAreAllAnagram(word, false);
    }



    public void testAreAllAnagram(String words, Boolean expected){
        ArrayList<String> wordList = AnagramUtils.splitLine(words);
        Assert.assertEquals(expected, AnagramUtils.areAllAnagrams(wordList));
    }

}
