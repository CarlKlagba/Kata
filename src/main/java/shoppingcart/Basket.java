package shoppingcart;

import java.util.ArrayList;
import java.util.List;

public class Basket {
	private ArrayList<GOOD> basket;
	
	public Basket() {
		this.basket = new ArrayList<>();
	}
	public void add(GOOD good) {
		basket.add(good);
	}
	
	public int numberOfGoods(GOOD good) {
		return ((int) basket.stream()
				.filter(x -> good.equals(x))
				.count());
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((basket == null) ? 0 : basket.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Basket other = (Basket) obj;
		if (basket == null) {
			if (other.basket != null)
				return false;
		} else if (!basket.equals(other.basket))
			return false;
		return true;
	}
}
