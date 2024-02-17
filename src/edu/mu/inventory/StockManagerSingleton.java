package edu.mu.inventory;

import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class StockManagerSingleton {
	protected final static String inventoryFilePath = "files/inventory.csv";
	private static List<String[]> invList = new ArrayList<String[]>();


	private static ArrayList<MediaProduct> productList = new ArrayList<MediaProduct>();
	private static ArrayList<TapeRecordProduct> tapeProductList = new ArrayList<TapeRecordProduct>();
	private static ArrayList<CDRecordProduct> CDProductList = new ArrayList<CDRecordProduct>();
	private static ArrayList<VinylRecordProduct> vinylProductList = new ArrayList<VinylRecordProduct>();
	
	public static ArrayList<MediaProduct> getProductList() {
		return productList;
	}

	public static void setProductList(ArrayList<MediaProduct> productList) {
		StockManagerSingleton.productList = productList;
	}
	
	
	public static boolean initializeStock() {
		try {
			Scanner fileIn = new Scanner(new FileInputStream(inventoryFilePath));
			
			fileIn.nextLine();
			
			while(fileIn.hasNextLine()) {
				String[] line = fileIn.nextLine().split(",");
				invList.add(line);
				
				
				
			}
			for(String[] _line : invList) {
				if(_line[0].equals("CD")) {
					CDRecordProduct cItem = new CDRecordProduct(_line[1], _line[2], _line[3], _line[4]);
					productList.add(cItem);
					CDProductList.add(cItem);
				}
				else if(_line[0].equals("Vinyl")) {
					VinylRecordProduct vItem = new VinylRecordProduct(_line[1], _line[2], _line[3], _line[4]);
					productList.add(vItem);
					vinylProductList.add(vItem);
				}
				else if(_line[0].equals("Tape")) {
					TapeRecordProduct tItem = new TapeRecordProduct(_line[1], _line[2], _line[3], _line[4]);
					productList.add(tItem);
					tapeProductList.add(tItem);
				}
			}
			
		fileIn.close();		
		return true;
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
			return false;
				
			}
		
		
	}
	
	public void printListOfMediaProduct(ArrayList<MediaProduct> productList) {
		
		ArrayList<MediaProduct> newList = new ArrayList<MediaProduct>(); //ignore this im gonna use it later - skylar
		int i = 1; // variable to display item number
		
		Iterator<MediaProduct> productListIterator = productList.iterator(); // iterator for the passed in ArrayList
		
		if(productListIterator.hasNext() == false) { //checks to see if the list is initially empty
			System.out.print("Error: there are not items in invtentory");
		}
		
		while(productListIterator.hasNext()) { //iterates through passed in list
			System.out.println("Item #" +i +": " + productListIterator.next().toString());
			i++;
		}
	}
	
	public boolean updateItemPrice(MediaProduct product, double newPrice) {
		try {
			product.setPrice(newPrice); //Attempts to set new price, throws error otherwise
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	public boolean addItem(MediaProduct product) {
		try {
			productList.add(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		/*if (productList != null) {
			productList.add(product);
			return true;
		}
		else {
			System.out.println("Could not add product to Product list");
			return false;
			
		}*/
	}
	public boolean removeItem(MediaProduct product) { //Has not been tested
		Iterator<MediaProduct> productListIterator = productList.iterator(); // iterator for the passed in ArrayList
		
		while(productListIterator.hasNext()) {
			if(product.equals(productListIterator.next())) {
				productListIterator.remove();
				return true;
			}
		}
		return false;
	}
	
	public boolean saveStock() {
		try {
			
			BufferedWriter bw = new BufferedWriter(new FileWriter(inventoryFilePath, false));
			for(MediaProduct item: productList) {
				bw.write(item + System.lineSeparator());
			}
			bw.close();
			
			return true;
		}
		
		catch(IOException e) { 
			e.printStackTrace();
			return false;
			
		}
		
		
	}
	
	public ArrayList<MediaProduct> getMediaProductBelowPrice (int maxprice){
		// list to put the cheaper options in
		ArrayList<MediaProduct> cheapList = new ArrayList<>();
		//cycle through products
		for (MediaProduct product : productList) {
			//check if product is cheaper than the maximum price and create a copy of it if so.
			if (product.getPrice() < maxprice) {
				MediaProduct cheapProduct = new MediaProduct(product.getTitle(), product.getPrice()
						, product.getYear(), product.getGenre());
				cheapList.add(cheapProduct);
			}
			
			
		}
		
		return cheapList;
	}
	
	public ArrayList<VinylRecordProduct> getVinylRecordList (ArrayList<MediaProduct> productList){		
		ArrayList<VinylRecordProduct> vinylRecordList = new ArrayList<VinylRecordProduct>(); //makes array list to be returned
		
		for(MediaProduct record: productList) { // iterates through the passed in list
			if(record instanceof VinylRecordProduct) { // checks if the current record is vinyl
				vinylRecordList.add((VinylRecordProduct) record); //if so add it to the list
			}
		}
		return vinylRecordList; //returns the list
	}
	
	public ArrayList<CDRecordProduct> getCDRecordList (ArrayList<MediaProduct> productList){  //works the same as getVinylRecordList
		
		ArrayList<CDRecordProduct> CDRecordList = new ArrayList<CDRecordProduct>();
		
		for(MediaProduct record: productList) {
			if(record instanceof CDRecordProduct) {
				CDRecordList.add((CDRecordProduct) record);
			}
		}
		return CDRecordList;
	}
	
	public ArrayList<TapeRecordProduct> getTapeRecordList (ArrayList<MediaProduct> productList){  //works the same as getVinylRecordList
		
		ArrayList<TapeRecordProduct> TapeRecordList = new ArrayList<TapeRecordProduct>();
		
		for(MediaProduct record: productList) {
			if(record instanceof TapeRecordProduct) {
				TapeRecordList.add((TapeRecordProduct) record);
			}
		}
		return TapeRecordList;
	}
	
}

