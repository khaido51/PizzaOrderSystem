package test;

public class CheesePizza extends VegPizza {

	// Read prices from the file from main first
	// store the in array or list 
	// public static float[] priceList = new float[4];
	
	// Constructor.
	public CheesePizza (ItemSize is, float[] cheesePizzaPriceArray) {
		setPrice(is, cheesePizzaPriceArray);    // store the price
		super.setSize(is);  	 // store the size
		super.setName("Cheese Pizza");			 // Set name		
	}
	
	
	@Override
	public void setPrice(ItemSize itemSize, float[] cheesePizzaPriceArray) {
		// TODO Auto-generated method stub
		if(itemSize == ItemSize.SMALL) {
			m_price = cheesePizzaPriceArray[0];
		}
		if(itemSize == ItemSize.MEDIUM) {
			m_price = cheesePizzaPriceArray[1];
		}
		if(itemSize == ItemSize.LARGE) {
			m_price = cheesePizzaPriceArray[2];
		}
		if(itemSize == ItemSize.EXLARGE) {
			m_price = cheesePizzaPriceArray[3];
		}
	}
	/*

	@Override
	public String name() {
		m_name = "Chesse Pizza";
		// TODO Auto-generated method stub
		return m_name ;
	}
	*/

	/*
	@Override
	public void setSize(ItemSize itemSize) {
		m_size = itemSize.toString();
	}
	*/		
}
