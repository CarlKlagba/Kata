package shoppingcart;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CheckoutTest {
	
	
	PricingRules pricingRules;
	Basket basket;
	
	@Before
	public void setup() {
		this.pricingRules = mock(PricingRules.class);
		this.basket= new Basket();
	}
	
	@Test
	public void should_cost_zero_when_no_items_have_been_scaned() {
		when(pricingRules.calculatePrice(basket)).thenReturn(new Price(0));
		assertEquals(new Price(0), new Checkout(pricingRules).getTotalPrice());
	}
	
	@Test
	public void should_cost_the_unit_price_when_one_item_have_been_scaned() {
		//GIVEN
		final Checkout checkout = new Checkout(pricingRules);
		basket.add(GOOD.A);
		when(pricingRules.calculatePrice(basket)).thenReturn(new Price(50));
		
		//WHEN
		checkout.scan(GOOD.A);
		
		//THEN
		assertEquals(new Price(50), checkout.getTotalPrice());
	}
	
	@Test
	public void should_cost_the_added_price_when_two_items_have_been_scaned() {
		//GIVEN
		final Checkout checkout = new Checkout(pricingRules);
		basket.add(GOOD.A);
		basket.add(GOOD.B);
		when(pricingRules.calculatePrice(basket)).thenReturn(new Price(80));
		
		//WHEN
		checkout.scan(GOOD.A);
		checkout.scan(GOOD.B);
		
		//THEN
		assertEquals(new Price(80), checkout.getTotalPrice());
	}
}
