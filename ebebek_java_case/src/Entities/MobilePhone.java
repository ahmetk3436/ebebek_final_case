package Entities;

import Entities.domain.Product;

public class MobilePhone extends Product{
	String category;
	public MobilePhone(int id, float unitPrice, float discountRate, int stockAmount, String name, String brandName,
			int ram, int storage, float screenSize,String color,int batteryPower) {
		super(id, unitPrice, discountRate, stockAmount, name, brandName, ram, storage, screenSize);
		this.color = color;
		this.batteryPower = batteryPower;
		this.category = "MobilePhone";
	}
	String color;
	int batteryPower;
	public MobilePhone() {
		
	}
}
