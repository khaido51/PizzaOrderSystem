package test;
import java.util.HashMap;


//Store a list of orders
public class OrderList {
	HashMap<String, OrderedItems> listOfOrders = new HashMap<String, OrderedItems>();
	
	String m_countStr ="";
	
	public void addOrder(String countStr, OrderedItems orderedItem) {
		m_countStr = countStr;
		listOfOrders.put(countStr, orderedItem);
	}
	
	public void showOrder() {
		for(String i: listOfOrders.keySet()) {
			OrderedItems oi = listOfOrders.get(i);
			
			System.out.println("Order ID: " + oi.m_orderID + ", Customer Name: " + oi.m_customer.getName());
		}
	}
	

	
}
