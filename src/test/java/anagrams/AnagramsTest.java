package anagrams;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by ippon on 17/11/16.
 */
public class AnagramsTest {

    public void testAnagram(String word1, String word2, Boolean expected){
        Assert.assertEquals(expected, Anagram.isAnagram(word1, word2));
    }

    @Test
    public void isAnagramTest(){
        String word1 = "kinship";
        String word2 = "pinkish";

        testAnagram(word1, word2, true);
    }

    @Test
    public void isNotAnagram_multiple_letter_Test(){
        String word1 = "azerrrrty";
        String word2 = "zaertyyyy";

        testAnagram(word1, word2, false);
    }

    @Test
    public void isNotAnagram_different_length_Test(){
        String word1 = "fish";
        String word2 = "cat";

        testAnagram(word1, word2, false);
    }

    @Test
    public void isNotAnagram_same_length_Test(){
        String word1 = "fish";
        String word2 = "same";

        testAnagram(word1, word2, false);
    }

}
