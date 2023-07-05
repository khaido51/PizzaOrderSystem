package test;

public class Coke extends ColdDrink {

	public Coke (ItemSize is, float[] cokePrice) {
		setPrice(is, cokePrice);    // store the price
		super.setSize(is);  	 // store the size
		super.setName("Coke");			 // Set name		
	}


	
	
	@Override
	public void setPrice(ItemSize itemSize, float[] cokePrice) {
		// TODO Auto-generated method stub
		if(itemSize == ItemSize.SMALL) {
			m_price = cokePrice[0];
		}
		if(itemSize == ItemSize.MEDIUM) {
			m_price = cokePrice[1];
		}
		if(itemSize == ItemSize.LARGE) {
			m_price = cokePrice[2];
		}
		if(itemSize == ItemSize.EXLARGE) {
			m_price = cokePrice[3];
		}
	}

}
