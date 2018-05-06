package shoppingcart;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by User on 06/05/2018.
 */
public class BasketTest {

    Basket sut;

    @Before
    public void setUp() throws Exception {
        sut = new Basket();

    }

    @Test
    public void should_have_one_good_when_one_was_added() throws Exception {
        //GIVEN
        sut.add(GOOD.A);
        //WHEN
        int actual = sut.numberOfGoods(GOOD.A);
        //THEN
        assertEquals(1, actual);
    }
    @Test
    public void should_have_5_ood_when_5_were_added() throws Exception {
        //GIVEN
        sut.add(GOOD.A);
        sut.add(GOOD.A);
        sut.add(GOOD.A);
        sut.add(GOOD.A);
        sut.add(GOOD.A);
        //WHEN
        int actual = sut.numberOfGoods(GOOD.A);
        //THEN
        assertEquals(5, actual);
    }
}
