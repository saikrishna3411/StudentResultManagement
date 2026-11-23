package com.nit.day2;


public class ProductBo {
	
		private int id;
		private String name;
		private String about;
		private double price;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getAbout() {
			return about;
		}
		public void setAbout(String about) {
			this.about = about;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		@Override
		public String toString() {
			return "ProductBo [id=" + id + ", name=" + name + ", about=" + about + ", price=" + price + "]";
		}
		
		

		
}
