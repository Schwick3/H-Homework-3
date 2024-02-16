package edu.mu;

import edu.mu.inventory.StockManagerSingleton;

public class Main {

	public static void main(String[] args) {
	StockManagerSingleton.initializeStock(); //this was a test
	
	StockManagerSingleton single = new StockManagerSingleton();
	single.initializeStock();
	single.printListOfMediaProduct(single.getProductList());

	}

}
