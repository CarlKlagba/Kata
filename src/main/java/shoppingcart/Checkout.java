package shoppingcart;

public class Checkout {
	
	final private PricingRules pricingRules;
	final private Basket basket;
	
	public Checkout(PricingRules pricingRules) {
		this.pricingRules = pricingRules;
		this.basket = new Basket();
	}

	public void scan(GOOD good) {
		this.basket.add(good); 
	}

	public Price getTotalPrice() {
		return pricingRules.calculatePrice(basket);
	}

}
