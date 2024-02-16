package edu.mu;

import java.util.ArrayList;

import edu.mu.inventory.StockManagerSingleton;
import edu.mu.inventory.VinylRecordProduct;

public class Main {

	public static void main(String[] args) {
	StockManagerSingleton.initializeStock(); //this was a test
	
	StockManagerSingleton single = new StockManagerSingleton();
	single.initializeStock();
	single.printListOfMediaProduct(single.getProductList());
	
	ArrayList<VinylRecordProduct> records = new ArrayList<VinylRecordProduct>();
	
	records = single.getVinylRecordList(single.getProductList());
	}

}
