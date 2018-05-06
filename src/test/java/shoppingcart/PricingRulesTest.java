package shoppingcart;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class PricingRulesTest {
	
	PricingRules sut;
	Basket basket;
	
	@Before
	public void setup() {
		sut = new PricingRules();
		basket = mock(Basket.class);
	}
	
	
	@Test
	public void should_cost_nothing_when_the_basket_is_empty() {
		//GIVEN
		when(basket.numberOfGoods(GOOD.A)).thenReturn(0);
		//WHEN
		Price actualPrice = sut.calculatePrice(basket);
		//THEN
		assertEquals(new Price(0), actualPrice);
	}
	
	@Test
	public void should_cost_50_when_the_basket_contains_only_A() {
		//GIVEN
		when(basket.numberOfGoods(GOOD.A)).thenReturn(1);
		//WHEN
		Price actualPrice = sut.calculatePrice(basket);
		//THEN
		assertEquals(new Price(50), actualPrice);
	}
	
	@Test
	public void should_cost_100_when_the_basket_contains_2_A() {
		//GIVEN
		when(basket.numberOfGoods(GOOD.A)).thenReturn(2);
		//WHEN
		Price actualPrice = sut.calculatePrice(basket);
		//THEN
		assertEquals(new Price(100), actualPrice);
	}
	
	@Test
	public void should_cost_130_when_the_basket_contains_3_A() {
		//GIVEN
		when(basket.numberOfGoods(GOOD.A)).thenReturn(3);
		//WHEN
		Price actualPrice = sut.calculatePrice(basket);
		//THEN
		assertEquals(new Price(130), actualPrice);
	}
	
	@Test
	public void should_cost_180_when_the_basket_contains_4_A() {
		//GIVEN
		when(basket.numberOfGoods(GOOD.A)).thenReturn(4);
		//WHEN
		Price actualPrice = sut.calculatePrice(basket);
		//THEN
		assertEquals(new Price(180), actualPrice);
	}
	
	@Test
	public void should_cost_30_when_the_basket_contains_only_B() {
		//GIVEN
		when(basket.numberOfGoods(GOOD.B)).thenReturn(1);
		//WHEN
		Price actualPrice = sut.calculatePrice(basket);
		//THEN
		assertEquals(new Price(30), actualPrice);
	}
	
	@Test
	public void should_cost_45_when_the_basket_contains_2_B() {
		//GIVEN
		when(basket.numberOfGoods(GOOD.B)).thenReturn(2);
		//WHEN
		Price actualPrice = sut.calculatePrice(basket);
		//THEN
		assertEquals(new Price(45), actualPrice);
	}
	
	@Test
	public void should_cost_20_when_the_basket_contains_1_C() {
		//GIVEN
		when(basket.numberOfGoods(GOOD.C)).thenReturn(1);
		//WHEN
		Price actualPrice = sut.calculatePrice(basket);
		//THEN
		assertEquals(new Price(20), actualPrice);
	}
	
	@Test
	public void should_cost_15_when_the_basket_contains_1_D() {
		//GIVEN
		when(basket.numberOfGoods(GOOD.D)).thenReturn(1);
		//WHEN
		Price actualPrice = sut.calculatePrice(basket);
		//THEN
		assertEquals(new Price(15), actualPrice);
	}
}
