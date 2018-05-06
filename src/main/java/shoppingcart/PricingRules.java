package shoppingcart;

public class PricingRules {
	private static final int A_UNIT_PRICE = 50;
	private static final int A_SPECIAL_PRICE = 130;
	
	private static final int B_UNIT_PRICE = 30;
	private static final int B_SPECIAL_PRICE = 45;
	
	private static final int C_UNIT_PRICE = 20;
	private static final int D_UNIT_PRICE = 15;
	
	public Price calculatePrice(Basket basket) {
		int value = formuleForA(basket.numberOfGoods(GOOD.A)) 
				+ formuleForB(basket.numberOfGoods(GOOD.B))
				+ formulmeForC(basket.numberOfGoods(GOOD.C))
				+ formulmeForD(basket.numberOfGoods(GOOD.D));
		return new Price(value);
	}

	private int formuleForA(int numberOfGoodsA) {
		return (numberOfGoodsA / 3) * A_SPECIAL_PRICE  + (numberOfGoodsA % 3) * A_UNIT_PRICE;
	}
	
	private int formuleForB(int numberOfGoodsB) {
		return (numberOfGoodsB / 2) * B_SPECIAL_PRICE  + (numberOfGoodsB % 2) * B_UNIT_PRICE;
	}
	
	private int formulmeForC(int numberOfGoodsC) {
		return C_UNIT_PRICE * numberOfGoodsC;
	}
	
	private int formulmeForD(int numberOfGoodsD) {
		return D_UNIT_PRICE * numberOfGoodsD;
	}

}
