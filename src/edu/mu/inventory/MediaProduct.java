package edu.mu.inventory;

public class MediaProduct {
	protected String title;
	protected double price;
	protected int year;
	protected Genre genre;
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	//constructor
	public MediaProduct(String title, String price, String year, String genre) {
		this.title = title;
		this.price = Double.parseDouble(price);
		this.year = Integer.parseInt(year);
		this.genre = Genre.valueOf(genre);
	}
}
