package shoppingcart;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

// http://codekata.com/kata/kata09-back-to-the-checkout/
// https://www.youtube.com/watch?v=kBNThogwWYw&t=360s
// https://markhneedham.com/blog/2008/11/06/object-calisthenics-first-thoughts/
public class IntegrationTest {
	
	@Test
	public void integrationTest() throws Exception {
		assertEquals(new Price(0), new Checkout(new PricingRules()).getTotalPrice());
		assertEquals(new Price(50), calculatePrice("A"));
		assertEquals(new Price(80), calculatePrice("AB"));
		assertEquals(new Price(115), calculatePrice("CDBA"));
		
		assertEquals(new Price(100), calculatePrice("AA"));
		assertEquals(new Price(130), calculatePrice("AAA"));
		assertEquals(new Price(180), calculatePrice("AAAA"));
		assertEquals(new Price(230), calculatePrice("AAAAA"));
		assertEquals(new Price(260), calculatePrice("AAAAAA"));


		assertEquals(new Price(160), calculatePrice("AAAB"));
		assertEquals(new Price(175), calculatePrice("AAABB"));
		assertEquals(new Price(190), calculatePrice("AAABBD"));
		assertEquals(new Price(190), calculatePrice("DABABA"));

	}
	
	Price calculatePrice(String goods) {
		final Checkout checkout = new Checkout(new PricingRules());
		Arrays.asList(goods.split("")).stream()
			.map(GOOD::valueOf)
			.forEach(good -> checkout.scan(good));
		
		return checkout.getTotalPrice();
	}
	
}
