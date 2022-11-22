package Entities.domain;

public abstract class Product {
	public  int id;
	public  float unitPrice;
	public  float discountRate;
	public  int stockAmount;
	public  String name;
	public  String brandName;
	public  int ram;
	public  int storage;
	public  float screenSize;
	protected Product(int id,float unitPrice,float discountRate,int stockAmount,String name,String
			brandName,int ram,int storage,float screenSize) {
		this.id = id;
		this.unitPrice = unitPrice;
		this.discountRate = discountRate;
		this.stockAmount = stockAmount;
		this.name = name;
		this.brandName = brandName;
		this.ram = ram;
		this.storage = storage;
		this.screenSize = screenSize;
	}
	protected Product()
	{
		
	}
}
