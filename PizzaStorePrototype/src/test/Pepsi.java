package test;

public class Pepsi extends ColdDrink{

	public Pepsi (ItemSize is, float[] pepsiPriceArray) {
		setPrice(is, pepsiPriceArray);    // store the price
		super.setSize(is);  	 // store the size
		super.setName("Pepsi");			 // Set name		
	}
	

	
	@Override
	public void setPrice(ItemSize itemSize, float[] pepsiPriceArray) {
		// TODO Auto-generated method stub
		if(itemSize == ItemSize.SMALL) {
			m_price = pepsiPriceArray[0];
		}
		if(itemSize == ItemSize.MEDIUM) {
			m_price = pepsiPriceArray[1];
		}
		if(itemSize == ItemSize.LARGE) {
			m_price = pepsiPriceArray[2];
		}
		if(itemSize == ItemSize.EXLARGE) {
			m_price = pepsiPriceArray[3];
		}
	}

}
