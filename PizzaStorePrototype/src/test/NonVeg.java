package test;

public class NonVeg extends Pizza{

	public NonVeg (ItemSize is, float[] nonVegPizzaArray) {
		setPrice(is, nonVegPizzaArray);    // store the price
		super.setSize(is);  	 // store the size
		super.setName("Non-Veggie");			 // Set name		
	}
	

	@Override
	public void setPrice(ItemSize itemSize,  float[] nonVegPizzaArray) {
		// TODO Auto-generated method stub
		if(itemSize == ItemSize.SMALL) {
			m_price = nonVegPizzaArray[0];
		}
		if(itemSize == ItemSize.MEDIUM) {
			m_price = nonVegPizzaArray[1];
		}
		if(itemSize == ItemSize.LARGE) {
			m_price = nonVegPizzaArray[2];
		}
		if(itemSize == ItemSize.EXLARGE) {
			m_price = nonVegPizzaArray[3];
		}
	}

}
