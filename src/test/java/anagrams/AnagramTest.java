package anagrams;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.*;

/**
 * Created by ippon on 23/11/16.
 */
public class AnagramTest {
    public void testEquals(Anagram anagram1, Anagram anagram2){
        Boolean equals = anagram1.equals(anagram2);
        Boolean hashCode = anagram1.hashCode() == anagram2.hashCode();

        if(equals){
            assertTrue("The hashCodes are different while the anagrams are equals", hashCode);
        }else{
            fail("The anagrams "+anagram1+" and "+anagram2+" are not equals when they should.");
        }
    }

    public void testNotEquals(Anagram anagram1, Anagram anagram2){
        Boolean equals = anagram1.equals(anagram2);
        assertTrue("The anagrams "+anagram1+" and "+anagram2+" are equals when they shouldn't.", !equals);
    }

    public void testAllEquals(ArrayList<Anagram> anagramList){
        for (Anagram a1 : anagramList){
            for(Anagram a2 : anagramList){
                testEquals(a1, a2);
            }
        }
    }
    @Test
    public void hashCode_and_equal_AnagramTest(){
        Anagram anagram1 = new Anagram("kinship");
        Anagram anagram2 = new Anagram("pinkish");

        testEquals(anagram1, anagram2);
    }

    @Test
    public void hashCode_and_equal_multiple_AnagramTest(){
        //paste pates peats septa spate tapes tepas
        ArrayList<Anagram> anagramList = new ArrayList();
        anagramList.add(new Anagram("paste"));
        anagramList.add(new Anagram("pates"));
        anagramList.add(new Anagram("peats"));
        anagramList.add(new Anagram("septa"));
        anagramList.add(new Anagram("spate"));
        anagramList.add(new Anagram("tapes"));
        anagramList.add(new Anagram("tepas"));

        testAllEquals(anagramList);
    }

    @Test
    public void notEquals_AnagramTest(){
        Anagram anagram1 = new Anagram("fish");
        Anagram anagram2 = new Anagram("cat");

        testNotEquals(anagram1, anagram2);
    }

    @Test
    public void contains_in_hashset_AnagramTest(){
        HashSet anagramSet = new HashSet<>(
                Arrays.asList(new Anagram("kinship"), new Anagram("fish"), new Anagram("cat")));

        Anagram notInSet = new Anagram("notinset");
        Anagram exactSame = new Anagram("fish");
        Anagram anagram = new Anagram("pinkish");

        assertTrue("The set shouldn't contain the anagram "+notInSet, !anagramSet.contains(notInSet));
        assertTrue("The set should contain the anagram "+exactSame, anagramSet.contains(exactSame));
        assertTrue("The set should contain the anagram "+anagram, anagramSet.contains(anagram));
    }

}
