package edu.mu.inventory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class StockManagerSingleton {
	protected String inventoryFilePath;
	private static List<String[]> invList = new ArrayList<String[]>();
	
	
	public static boolean initializeStock(String inventoryFilePath) {
		try {
			Scanner fileIn = new Scanner(new FileInputStream(inventoryFilePath));
			
			fileIn.nextLine();
			
			while(fileIn.hasNextLine()) {
				String[] line = fileIn.nextLine().split(",");
				invList.add(line);
				
				
				
			}
			for(String[] _line : invList) {
				if(_line[0].equals("CD")) {
					//CD obj constructor
				}
				else if(_line[0].equals("Vinyl")) {
					//vinyl obj constructor
				}
				else if(_line[0].equals("Tape")) {
					//tape obj constructor
				}
			}
			
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
			System.out.println("Item #" +i +":" + productListIterator.next());
			i++;
		}
	}

}
