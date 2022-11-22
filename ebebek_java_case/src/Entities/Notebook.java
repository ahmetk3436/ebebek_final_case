package Entities;

import Entities.domain.Product;

public class Notebook extends Product{
	String category;
	public Notebook(int id, float unitPrice, float discountRate, int stockAmount, String name, String brandName,
			int ram, int storage, float screenSize) {
		super(id, unitPrice, discountRate, stockAmount, name, brandName, ram, storage, screenSize);
		this.category = "Notebook";
	}
	public Notebook() {
		
	}
}
