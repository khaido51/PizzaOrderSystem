package test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrderedItems {
	public List<Item> m_itemList = new ArrayList<Item>();
	public int m_orderID;
	public Customer m_customer;
	public LocalDateTime dateOrder;
	public Table m_table;
	public boolean isPaid;
	
	public void addItems(Item item) {
		m_itemList.add(item);
	}
	
	public void removeItem(int index) {
		//m_itemList.remove(item);
		m_itemList.remove(index);
	}
	
	public float getCost() {
		float total = 0;
		for(Item item: m_itemList) {
			
			total += item.m_price; 
		}
		return total;
	}

	public void addTable() {
		m_table = new Table();
		m_table.setTableNumber("T21");
	}
	
	//public void addCustomer(Customer customer) {
	public void addCustomer(String name) {
		m_customer = new Customer(name);
		//m_customer = customer;
		//......
	}
	
	
	
	public void showItem() {
		for(Item item: m_itemList) {
			System.out.println("Item name: " + item.m_name);
			System.out.println("Item size: " + item.m_size);
			System.out.println("Item price: " + item.m_price);
			System.out.println("");
			
		}
	}
}
