package test;

public abstract class Item {
	protected String m_name;
	protected String m_size;
	protected float m_price;
	
	//public abstract void setSize(ItemSize itemSize);
	
	public void setSize(ItemSize itemSize) {
		m_size = itemSize.toString();
	}
	
	public void setName(String name) {
		m_name = name;
	}
	
	public abstract void setPrice(ItemSize itemSize, float[] itemsArr);
	
}
