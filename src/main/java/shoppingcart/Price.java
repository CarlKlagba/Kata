package shoppingcart;

public class Price {
	final int value;
	public Price(int value) {
		this.value = value;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + value;
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
		Price other = (Price) obj;
		if (value != other.value)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Price [value=" + value + "]";
	}
	
	
	
	
	
}
