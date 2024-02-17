package edu.mu.inventory;

public class MediaProduct {
	protected String title;
	protected double price;
	protected int year;
	protected Genre genre;
	protected String medium;
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	//public MediaProduct() {
		
	//}
		//constructor
	/*public MediaProduct(String title, String price, String year, String genre) {
		this.title = title;
		this.price = Double.parseDouble(price);
		this.year = Integer.parseInt(year);
		this.genre = Genre.valueOf(genre);
	}*/
	//constructor 2
		public MediaProduct(String medium, String title2, double price2, int year2, Genre genre2) {
			this.medium = medium;
			this.title = title2;
			this.price = price2;
			this.year = year2;
			this.genre = genre2;
		}
		public String getMedium() {
			return medium;
		}
		public void setMedium(String medium) {
			this.medium = medium;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public int getYear() {
			return year;
		}
		public void setYear(int year) {
			this.year = year;
		}
		public Genre getGenre() {
			return genre;
		}
		public void setGenre(Genre genre) {
			this.genre = genre;
		}
	@Override
	public String toString() {
		return "Title = " + title + ", Price = " + price + ", Year = " + year + ", Genre = " + genre + "]";
	}
	
	
}
