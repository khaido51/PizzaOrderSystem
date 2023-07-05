package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PriceOfAllItems {
	float[] cheesePizzaPrice = new float[4];
	float[] nonVegPizzaPrice = new float[4];
	float[] onionPizzaPrice = new float[4];
	float[] cokePrice = new float[4];
	float[] pepsiPrice = new float[4];

	String line = "";
	String splitBy = ",";

	public void readFile() {

		int lineNo = 1;
		try {
			BufferedReader br = new BufferedReader(new FileReader("PriceList.csv"));
			while ((line = br.readLine()) != null) {
				String[] priceList = line.split(splitBy);
				
				System.out.println("Item: " + priceList[0] + " " + priceList[1] + " " + priceList[2] + " "
						+ priceList[3] + " " + priceList[4]);

				if (lineNo == 1) {
					cheesePizzaPrice[0] = Float.parseFloat(priceList[1]);
					cheesePizzaPrice[1] = Float.parseFloat(priceList[2]);
					cheesePizzaPrice[2] = Float.parseFloat(priceList[3]);
					cheesePizzaPrice[3] = Float.parseFloat(priceList[4]);
					
				} 
				if (lineNo == 2) {
					nonVegPizzaPrice[0] = Float.parseFloat(priceList[1]);
					nonVegPizzaPrice[1] = Float.parseFloat(priceList[2]);
					nonVegPizzaPrice[2] = Float.parseFloat(priceList[3]);
					nonVegPizzaPrice[3] = Float.parseFloat(priceList[4]);

				} 
				if (lineNo == 3) {
					onionPizzaPrice[0] = Float.parseFloat(priceList[1]);
					onionPizzaPrice[1] = Float.parseFloat(priceList[2]);
					onionPizzaPrice[2] = Float.parseFloat(priceList[3]);
					onionPizzaPrice[3] = Float.parseFloat(priceList[4]);
				} 
				if (lineNo == 4) {
					cokePrice[0] = Float.parseFloat(priceList[1]);
					cokePrice[1] = Float.parseFloat(priceList[2]);
					cokePrice[2] = Float.parseFloat(priceList[3]);
					cokePrice[3] = Float.parseFloat(priceList[4]);
				} 
				if (lineNo == 5){
					pepsiPrice[0] = Float.parseFloat(priceList[1]);
					pepsiPrice[1] = Float.parseFloat(priceList[2]);
					pepsiPrice[2] = Float.parseFloat(priceList[3]);
					pepsiPrice[3] = Float.parseFloat(priceList[4]);
				}
				// .....
				// ......
				/// .....
				lineNo++;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
