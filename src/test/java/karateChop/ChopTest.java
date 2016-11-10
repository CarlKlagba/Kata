package karateChop;

import static org.junit.Assert.*;

import karateChop.Karate;
import karateChop.Kyokushin;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Travail on 28/09/2016.
 */
public class ChopTest {
    Karate karate;
    @Test
    public void testChop(){
        karate = new Aikido();

        List<Integer> empty = new ArrayList<>();

        List<Integer> size1 = new ArrayList<>();
        size1.add(1);

        List<Integer> size2 = new ArrayList<>();
        size2.add(1);
        size2.add(3);
        size2.add(5);

        List<Integer> size3 =new ArrayList<>();
        size3.add(1);
        size3.add(3);
        size3.add(5);
        size3.add(7);

        assertEquals(-1, karate.chop(3, empty));
        assertEquals(-1, karate.chop(3, size1));
        assertEquals("{1}", 0, karate.chop(1, size1));

        assertEquals("1 in {1,3,5}",0, karate.chop(1, size2));
        assertEquals("3 in {1,3,5}",1, karate.chop(3, size2));
        assertEquals("5 in {1,3,5}", 2, karate.chop(5, size2));
        assertEquals("0 in {1,3,5}",-1, karate.chop(0, size2));
        assertEquals("2 in {1,3,5}",-1, karate.chop(2, size2));
        assertEquals("4 in {1,3,5}",-1, karate.chop(4, size2));
        assertEquals("6 in {1,3,5}",-1, karate.chop(6, size2));

        assertEquals("1 in {1, 3, 5, 7}",0, karate.chop(1, size3));
        assertEquals("3 in {1, 3, 5, 7}", 1, karate.chop(3, size3));
        assertEquals("5 in {1, 3, 5, 7}",2, karate.chop(5, size3));
        assertEquals(3, karate.chop(7, size3));
        assertEquals(-1, karate.chop(0, size3));
        assertEquals(-1, karate.chop(2, size3));
        assertEquals(-1, karate.chop(4, size3));
        assertEquals(-1, karate.chop(6, size3));
        assertEquals(-1, karate.chop(8, size3));
    }
}
