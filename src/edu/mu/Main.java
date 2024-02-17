package edu.mu;

import java.util.ArrayList;

import edu.mu.inventory.Genre;
import edu.mu.inventory.MediaProduct;
import edu.mu.inventory.StockManagerSingleton;
import edu.mu.inventory.TapeRecordProduct;
import edu.mu.inventory.VinylRecordProduct;

public class Main {

	public static void main(String[] args) {
	//StockManagerSingleton.initializeStock(); //this was a test
	
	StockManagerSingleton single = new StockManagerSingleton();
	single.initializeStock();
	//single.printListOfMediaProduct(single.getProductList());
	
	/*ArrayList<VinylRecordProduct> records = new ArrayList<VinylRecordProduct>();
	
	records = single.getVinylRecordList(single.getProductList());
	for(MediaProduct song: records) {
		System.out.println(song);
	}
	ArrayList<TapeRecordProduct> tapes = new ArrayList<TapeRecordProduct>();
	tapes = single.getTapeRecordList(single.getProductList());
	for(MediaProduct song: tapes) {
		System.out.println(song);
	}*/
	/*ArrayList<MediaProduct> belowPrice = new ArrayList<MediaProduct>();
	belowPrice = single.getMediaProductBelowPrice(25);
	for(MediaProduct song : belowPrice) {
		System.out.println(song);
	}*/
	MediaProduct newSong = new MediaProduct("Vinyl", "Rubber Soul", 25, 1965, Genre.ROCK);
	single.addItem(newSong);
	single.saveStock();
	}

}
