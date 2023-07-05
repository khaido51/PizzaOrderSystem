package test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import swt.SWTResourceManager;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import javax.swing.JOptionPane;
import java.io.BufferedReader;  
import java.io.FileReader;  
import java.io.IOException;  


public class MainWindow {

	protected Shell shell;
	// OrderedItems m_listOfOrderItems = new OrderedItems();
	OrderedItems m_listOfOrderItems;
	private Table tableOrder;
	String[] titles = { "Name", "Size", "Price" };
	String[] orderListTitles = { "Order ID", "Customer", "Date", "Table", "IsPaid"};
	String[] orderHistoryTitles = {"Name", "Size", "Price"};
	private Text totalValue;
	private Text txtTotal;
	OrderList m_orderList = new OrderList();
	int m_orderNo = 1;
	private Table table;
	private Table tableHistory;
	DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
	Button btnSubmit;
	PriceOfAllItems priceItems;
	
	
	
	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			MainWindow window = new MainWindow();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		
		
		// get price here...
		
		priceItems = new PriceOfAllItems();
		priceItems.readFile();
		
		
		
		shell = new Shell();
		shell.setSize(1313, 750);
		shell.setText("SWT Application");
		
		m_listOfOrderItems = new OrderedItems();
				
		btnSubmit = new Button(shell, SWT.NONE);
		btnSubmit.setEnabled(false);
		btnSubmit.setBounds(805, 350, 90, 30);
		btnSubmit.setText("Submit");
		
		Button btnRemoveItem = new Button(shell, SWT.NONE);
		btnRemoveItem.setEnabled(false);
		btnRemoveItem.setBounds(1002, 350, 100, 30);
		btnRemoveItem.setText("Remove Item");
		
		Label lblVegePizza = new Label(shell, SWT.NONE);
		lblVegePizza.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		lblVegePizza.setBounds(22, 43, 99, 20);
		lblVegePizza.setText("Veggie Pizza");
		
		Label lblChessePizza = new Label(shell, SWT.NONE);
		lblChessePizza.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		lblChessePizza.setBounds(23, 87, 98, 20);
		lblChessePizza.setText("Chesse Pizza");
		
		Combo cbCheesePizza = new Combo(shell, SWT.NONE);
		cbCheesePizza.setItems(new String[] {"Small", "Medium", "Large", "ExLarge"});
		cbCheesePizza.setBounds(24, 119, 97, 28);
		cbCheesePizza.select(0);
		
		Button btnCheesePizza = new Button(shell, SWT.NONE);
		btnCheesePizza.setBounds(22, 168, 90, 30);
		btnCheesePizza.setText("Add");
		addItem(btnCheesePizza, cbCheesePizza, "CheesePizza");
		/*
		btnCheesePizza.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				
				// Get pizza size from the combo box
				String textSel = cbCheesePizza.getText();
				textSel = textSel.toUpperCase();
				ItemSize iSize = ItemSize.valueOf(textSel);
				
				Item cheesePizza = new CheesePizza(iSize);
				m_listOfOrderItems.addItems(cheesePizza);			
				m_listOfOrderItems.showItem();
				//m_listOfOrderItems.getCost();
				totalValue.setText(m_listOfOrderItems.getCost() + "");
				displayItemToTable();
				btnSubmit.setEnabled(true);
			
			}
		});*/
		
		Label lblOnionLabel = new Label(shell, SWT.NONE);
		lblOnionLabel.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		lblOnionLabel.setBounds(22, 220, 97, 20);
		lblOnionLabel.setText("Onion Pizza");
		
		Combo cbOnion = new Combo(shell, SWT.NONE);
		cbOnion.setItems(new String[] {"Small", "Medium", "Large", "ExLarge"});
		cbOnion.setBounds(24, 257, 97, 28);
		cbOnion.select(0);
		
		Button btnOnionPizza = new Button(shell, SWT.NONE);
		btnOnionPizza.setBounds(22, 299, 90, 30);
		btnOnionPizza.setText("Add");
		addItem(btnOnionPizza, cbOnion, "OnionPizza");
		/*
		btnOnionPizza.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				String textSel = cbOnion.getText();
				textSel = textSel.toUpperCase();
				ItemSize iSize = ItemSize.valueOf(textSel);
				
				Item onionPizza = new OnionPizza(iSize);
				m_listOfOrderItems.addItems(onionPizza);
				m_listOfOrderItems.showItem();
				totalValue.setText(m_listOfOrderItems.getCost() + "");
				displayItemToTable();
				btnSubmit.setEnabled(true);
			}
		});*/
		
		
		
		tableOrder = new Table(shell, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION);
		tableOrder.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int indexSel = tableOrder.getSelectionIndex();
				btnRemoveItem.setEnabled(true);
				
				if(tableOrder.getItemCount() > 0) {
					btnSubmit.setEnabled(true);
				}
			}
		});
		tableOrder.setBounds(768, 58, 403, 286);
		tableOrder.setHeaderVisible(true);
		tableOrder.setLinesVisible(true);
		
		
		
		totalValue = new Text(shell, SWT.BORDER);
		totalValue.setEditable(false);
		//System.out.println("tot cost: " + m_listOfOrderItems.getCost());
		
		totalValue.setBounds(1177, 318, 78, 26);
		
		
		txtTotal = new Text(shell, SWT.BORDER);
		txtTotal.setText("Total");
		txtTotal.setEnabled(false);
		txtTotal.setBounds(1177, 271, 78, 26);
		
		
		
		Label lblNonVeggiePizza = new Label(shell, SWT.NONE);
		lblNonVeggiePizza.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		lblNonVeggiePizza.setBounds(254, 43, 139, 20);
		lblNonVeggiePizza.setText("Non Veggie Pizza");
		
		Label lblColdDrink = new Label(shell, SWT.NONE);
		lblColdDrink.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		lblColdDrink.setBounds(502, 43, 90, 20);
		lblColdDrink.setText("Cold Drink");
		
		Label lblNonvegPizza = new Label(shell, SWT.NONE);
		lblNonvegPizza.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		lblNonvegPizza.setBounds(275, 87, 99, 20);
		lblNonvegPizza.setText("NonVeg Pizza");
		
		Combo comboNonVeg = new Combo(shell, SWT.NONE);
		comboNonVeg.setItems(new String[] {"Small", "Medium", "Large", "ExLarge"});
		comboNonVeg.setBounds(275, 119, 97, 28);
		comboNonVeg.select(0);
		
		Button btnNonVegAdd = new Button(shell, SWT.NONE);
		btnNonVegAdd.setBounds(275, 168, 90, 30);
		btnNonVegAdd.setText("Add");
		addItem(btnNonVegAdd, comboNonVeg, "NonVeg");
		
		/*
		btnNonVegAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				String textSel = comboNonVeg.getText();
				textSel = textSel.toUpperCase();
				ItemSize iSize = ItemSize.valueOf(textSel);
				
				Item nonVegPizza = new NonVeg(iSize);
				m_listOfOrderItems.addItems(nonVegPizza);
				m_listOfOrderItems.showItem();
				totalValue.setText(m_listOfOrderItems.getCost() + "");
				displayItemToTable();
				btnSubmit.setEnabled(true);
			}
		});*/
		
		Label lblCoke = new Label(shell, SWT.NONE);
		lblCoke.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		lblCoke.setBounds(502, 87, 70, 20);
		lblCoke.setText("Coke");
		
		Combo comboCoke = new Combo(shell, SWT.NONE);
		comboCoke.setItems(new String[] {"Small", "Medium", "Large", "ExLarge"});
		comboCoke.setBounds(502, 119, 97, 28);
		comboCoke.select(0);
		
		Button btnAddCoke = new Button(shell, SWT.NONE);
		btnAddCoke.setBounds(502, 168, 90, 30);
		btnAddCoke.setText("Add");
		addItem(btnAddCoke, comboCoke, "Coke");
		/*
		btnAddCoke.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				String textSel = comboCoke.getText();
				textSel = textSel.toUpperCase();
				ItemSize iSize = ItemSize.valueOf(textSel);
				
				Item coke = new Coke(iSize);
				m_listOfOrderItems.addItems(coke);
				m_listOfOrderItems.showItem();
				totalValue.setText(m_listOfOrderItems.getCost() + "");
				displayItemToTable();
				btnSubmit.setEnabled(true);
			}
		});*/
		
		Label lblPepsi = new Label(shell, SWT.NONE);
		lblPepsi.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.BOLD));
		lblPepsi.setBounds(502, 220, 70, 20);
		lblPepsi.setText("Pepsi");
		
		Combo comboPepsi = new Combo(shell, SWT.NONE);
		comboPepsi.setItems(new String[] {"Small", "Medium", "Large", "ExLarge"});
		comboPepsi.setBounds(502, 257, 97, 28);
		comboPepsi.select(0);
		
		Button btnAddPepsi = new Button(shell, SWT.NONE);
		btnAddPepsi.setBounds(502, 299, 90, 30);
		btnAddPepsi.setText("Add");
		
		addItem(btnAddPepsi, comboPepsi, "Pepsi");
		/*
		btnAddPepsi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				String textSel = comboPepsi.getText();
				textSel = textSel.toUpperCase();
				ItemSize iSize = ItemSize.valueOf(textSel);
				
				Item pepsi = new Pepsi(iSize);
				m_listOfOrderItems.addItems(pepsi);
				m_listOfOrderItems.showItem();
				totalValue.setText(m_listOfOrderItems.getCost() + "");
				displayItemToTable();
				btnSubmit.setEnabled(true);
			}
		});
		*/
		
		
		
		Label label = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label.setBackground(SWTResourceManager.getColor(128, 128, 128));
		label.setBounds(23, 381, 1261, 2);
		
		Label label_1 = new Label(shell, SWT.SEPARATOR | SWT.VERTICAL);
		label_1.setForeground(SWTResourceManager.getColor(128, 128, 128));
		label_1.setBounds(680, 43, 2, 340);
		
		Label label_2 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_2.setForeground(SWTResourceManager.getColor(128, 128, 128));
		label_2.setBounds(10, 69, 672, 2);
		
		Label label_3 = new Label(shell, SWT.SEPARATOR | SWT.VERTICAL);
		label_3.setForeground(SWTResourceManager.getColor(128, 128, 128));
		label_3.setBounds(198, 71, 2, 312);
		
		Label label_4 = new Label(shell, SWT.SEPARATOR | SWT.VERTICAL);
		label_4.setForeground(SWTResourceManager.getColor(128, 128, 128));
		label_4.setBounds(439, 69, 2, 314);
		
		Label label_5 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_5.setForeground(SWTResourceManager.getColor(128, 128, 128));
		label_5.setBounds(10, 212, 672, 2);
		
		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int indexSel = table.getSelectionIndex();
				System.out.println("Test " + indexSel);
				
				OrderedItems oi = m_orderList.listOfOrders.get(indexSel + 1 +"" );
				//oi.showItem();
				displayOrderHistory(oi);
		
				
			}
		});
		table.setBounds(56, 428, 440, 229);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		Label lblListOfOrders = new Label(shell, SWT.NONE);
		lblListOfOrders.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.BOLD));
		lblListOfOrders.setBounds(768, 24, 153, 28);
		lblListOfOrders.setText("List Of Orders");
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.BOLD));
		lblNewLabel.setBounds(56, 389, 110, 33);
		lblNewLabel.setText("Orders List");
		
		Label label_6 = new Label(shell, SWT.SEPARATOR | SWT.VERTICAL);
		label_6.setBounds(680, 381, 2, 312);
		
		tableHistory = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		tableHistory.setBounds(768, 428, 391, 229);
		tableHistory.setHeaderVisible(true);
		tableHistory.setLinesVisible(true);
		
		Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.BOLD));
		lblNewLabel_1.setBounds(768, 389, 214, 33);
		lblNewLabel_1.setText("Order Details History");
		
		
		
	
		btnRemoveItem.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseDown(MouseEvent e) {
				//Select item on the list
			
				int indexSel = tableOrder.getSelectionIndex();
				
				if(indexSel > -1) {
					m_listOfOrderItems.removeItem(indexSel);
					//Click remove button to remove
					
					displayItemToTable();
					//btnRemoveItem.getEnabled();
					totalValue.setText(m_listOfOrderItems.getCost() + "");
					
				}
				if(tableOrder.getItemCount() < 1) {
					btnRemoveItem.setEnabled(false);
					btnSubmit.setEnabled(false);
				}
				
				
			}
		});
		
	
		
		btnSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				// add order to the list
				//Customer c = new Customer("Khai Do");
				//c.setName("Khai Do");
				//m_listOfOrderItems.addCustomer(c);
				String customerName = JOptionPane.showInputDialog("Enter Customer Name");
				System.out.println("Name: " + customerName );
				if(customerName == null) {
					customerName = "No Name Enter";
				}
				else if(customerName.isEmpty()) {
					customerName = "No Name Enter";
				}
				
				m_listOfOrderItems.addCustomer(customerName);
				m_listOfOrderItems.m_orderID = m_orderNo;
				m_listOfOrderItems.addTable();
				m_listOfOrderItems.dateOrder = LocalDateTime.now();
				
				m_listOfOrderItems.isPaid = false;
			  
				
				//m_listOfOrderItems.m_customer = new Customer ("Khai Do");
				
				m_orderList.addOrder(m_orderNo+"", m_listOfOrderItems);
				// Show order in the order list GUI
				m_orderList.showOrder();  //testing
				m_orderNo++;
				m_listOfOrderItems = new OrderedItems();
				btnRemoveItem.setEnabled(false);
				displayOrdersToOrderTable();
				tableOrder.removeAll();
				btnSubmit.setEnabled(false);
				
				
			}
		});
		

		
		//List of Orders Table
		for(int i = 0; i < titles.length; i++) {
			TableColumn column = new TableColumn(tableOrder, SWT.NULL);
			column.setText(titles[i]);
		}
		//Display titles of table
		for(int i = 0; i < titles.length; i++) {
			tableOrder.getColumn(i).pack();
		}
		
		
		
		
		//Ordered List Table
		for(int i = 0; i < orderListTitles.length; i++) {
			TableColumn column = new TableColumn(table, SWT.NULL);
			column.setText(orderListTitles[i]);
		}
		//Display titles to table
		for(int i = 0; i < orderListTitles.length; i++) {
			table.getColumn(i).pack();
		}
		
		
		//Order History Table
		for(int i = 0; i < orderHistoryTitles.length; i++) {
			TableColumn column = new TableColumn(tableHistory, SWT.NULL);
			column.setText(orderHistoryTitles[i]);
		}
		
		//Display titles to table
		for(int i = 0; i < orderHistoryTitles.length; i++) {
			tableHistory.getColumn(i).pack();
		}
	}

	public void displayItemToTable() {
		tableOrder.removeAll();

		// int count = 0;
		for (Item eItem : m_listOfOrderItems.m_itemList) {
			TableItem item = new TableItem(tableOrder, SWT.NULL);
			item.setText(0, eItem.m_name);
			item.setText(1, eItem.m_size);
			item.setText(2, eItem.m_price + "");
			// tableOrder.getColumn(count).pack();
			// count++;
		}

		for (int i = 0; i < titles.length; i++) {
			tableOrder.getColumn(i).pack();
		}

		tableOrder.redraw();
	}
	
	public void displayOrdersToOrderTable() {
		table.removeAll();
		
		for(String i: m_orderList.listOfOrders.keySet()) {
			TableItem item = new TableItem(table, SWT.NULL);
			OrderedItems oi = m_orderList.listOfOrders.get(i);
			item.setText(0, oi.m_orderID + "");
			item.setText(1, oi.m_customer.getName());
			item.setText(2, oi.dateOrder.format(myFormatObj) + "");
			item.setText(3, oi.m_table.getTableNumber());
			item.setText(4, oi.isPaid+"");
		}
		
		for(int i = 0; i <orderListTitles.length; i++) {
			table.getColumn(i).pack();

		}
		
		table.redraw();
		
	}
	
	public void displayOrderHistory(OrderedItems oi) {
		tableHistory.removeAll();
		    		    
		    // Iterate through each order in the order history
		for (Item eItem : oi.m_itemList) {
			TableItem item = new TableItem(tableHistory, SWT.NULL);
			item.setText(0, eItem.m_name);
			item.setText(1, eItem.m_size);
			item.setText(2, eItem.m_price + "");
			// tableOrder.getColumn(count).pack();
			// count++;
		}
			for (int i = 0; i < orderHistoryTitles.length; i++) {
				tableHistory.getColumn(i).pack();
			}


		tableHistory.redraw();
	}
	
	
	
	
	//---------------------------------------------------------------------
	public void addItem(Button btn, Combo cb, String itemType)
	{
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				String textSel = cb.getText();
				textSel = textSel.toUpperCase();
				ItemSize iSize = ItemSize.valueOf(textSel);
				
				Item item =null;
				if (itemType.equalsIgnoreCase("Pepsi"))
				{
					item = new Pepsi (iSize, priceItems.pepsiPrice);
				}
				if (itemType.equalsIgnoreCase("Coke"))
				{
					item = new Coke (iSize, priceItems.cokePrice);
				}
				if (itemType.equalsIgnoreCase("OnionPizza"))
				{
					item = new OnionPizza (iSize, priceItems.onionPizzaPrice);
				}
				if (itemType.equalsIgnoreCase("CheesePizza"))
				{
					item = new CheesePizza (iSize, priceItems.cheesePizzaPrice);
				}
				if (itemType.equalsIgnoreCase("NonVeg"))
				{
					item = new NonVeg (iSize, priceItems.nonVegPizzaPrice);
				}
				
				m_listOfOrderItems.addItems(item);
				m_listOfOrderItems.showItem();
				totalValue.setText(m_listOfOrderItems.getCost() + "");
				displayItemToTable();
				btnSubmit.setEnabled(true);
			}
		});
	}
}
