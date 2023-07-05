package test;

public class OnionPizza extends Pizza {
	
	public OnionPizza (ItemSize is, float[] onionPizzaPriceArray) {
		setPrice(is, onionPizzaPriceArray);    // store the price
		super.setSize(is);  	 // store the size
		super.setName("Onion Pizza");		 // Set name		
	}
	

	@Override
	public void setPrice(ItemSize itemSize, float[] onionPizzaPriceArray) {
		// TODO Auto-generated method stub
		if (itemSize == ItemSize.SMALL) {
			m_price = onionPizzaPriceArray[0];
		}
		if (itemSize == ItemSize.MEDIUM) {
			m_price = onionPizzaPriceArray[1];
		}
		if (itemSize == ItemSize.LARGE) {
			m_price =onionPizzaPriceArray[2];
		}
		if (itemSize == ItemSize.EXLARGE) {
			m_price = onionPizzaPriceArray[3];
		}

	}

}
