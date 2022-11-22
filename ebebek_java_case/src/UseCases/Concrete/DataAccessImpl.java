package UseCases.Concrete;

import java.util.Comparator;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.logging.Logger;

import Entities.MobilePhone;
import Entities.Notebook;
import UseCases.Abstract.IDataAccess;

public class DataAccessImpl implements IDataAccess{
	public final Scanner scan;
	public final Logger logger;
	protected static SortedSet<String> brands = new TreeSet<>(new Comparator<String>() {
		@Override
		public int compare(String s1, String s2) {
            return s1.trim().compareTo(s2.trim());
		}
    });
	
	public enum Category{
MOBILEPHONE,
NOTEBOOK
}
	public enum Brands{
		SAMSUNG,
		LENOVO,
		APPLE,
		HUAWEI,
		CASPER,
		ASUS,
		HP,
		XIAOMI,
		MONSTER
	}
	public DataAccessImpl (Logger logger,Scanner scan) {
		this.scan = scan;
		this.logger = logger;
		brands.add("SAMSUNG");
		brands.add("LENOVO");
		brands.add("APPLE");
		brands.add("HUAWEI");
		brands.add("CASPER");
		brands.add("ASUS");
		brands.add("HP");
		brands.add("XIAOMI");
		brands.add("MONSTER");
	}
	@Override
	public int takeUserInput() {
		int result=0;
		  try {
	        	
	        		logger.info("Yapmak istediğiniz işlemi seçiniz \n1 - Notebook İşlemleri\n2 - Telefon İşlemleri\n3 - Markalar\n4 - Ürünleri Listele \n5 - Çıkış Yap");
	        		var userInput = scan.next();
	        		Integer.parseInt(userInput);
	        		int userIntInput = Integer.parseInt(userInput);
	        		if((userIntInput >0 && userIntInput <5))
	        		{
	        			result = userIntInput;
	        			return result;	        		
	        		} else {
	        			logger.info("Girdi değeri hatalı olduğu için işleme devam edilemiyor\n");
	        		}
	        		
	       
	        }catch(Exception e) {
	        	logger.info("Sonuç hatalı : "+ e.getLocalizedMessage());
	        }
		  return result;
	}
	
	@Override
	public MobilePhone takeMobilePhoneData() {
		MobilePhone phone = new MobilePhone();
		try {
			logger.info("Unit Price: ");
	        float unitPrice = scan.nextFloat();
	        logger.info("Discount Rate : ");
	        float discountRate = scan.nextFloat();
	        logger.info("Stock : ");
	        int stockAmount = scan.nextInt();
	        logger.info("Name : ");
	        String name = scan.next();
	        logger.info("Storage : ");
	        int storage = scan.nextInt();
	        logger.info("Screen Size : ");
	        float screenSize = scan.nextFloat();
	        logger.info("RAM : ");
	        int ram = scan.nextInt();
	        logger.info("Battery Power : ");
	        int batteryPower = scan.nextInt();
	        logger.info("Color : ");
	        String color = scan.next();
	        logger.info("Brand : \n");
	        int i = 0;
		       for(String element : brands)
		       {
		    	   	logger.info((i+1) + " - " + element);
		    	   	i++;
		       }
	        String selectedBrand = scan.next();
	        Integer.parseInt(selectedBrand);
	        int selectedBrandIndex = Integer.parseInt(selectedBrand);
	        var brandName = brands.toArray()[selectedBrandIndex - 1].toString();
			phone = new MobilePhone(MobilePhoneImpl.mobilePhoneProducts.size() + 1,unitPrice,discountRate,stockAmount,name,brandName,ram,storage,screenSize,color,batteryPower);
		}catch(Exception e) {
			logger.info(e.getLocalizedMessage());
		}
		return phone;
	}
	@Override
	public Notebook takeNotebookData() {
		Notebook notebook = new Notebook();
		try {
			logger.info("Unit Price : ");
	        float unitPrice = scan.nextFloat();
	        logger.info("Discount Rate : ");
	        float discountRate = scan.nextFloat();
	        logger.info("Stock : ");
	        int stockAmount = scan.nextInt();
	        logger.info("Name : ");
	        String name = scan.next();
	        logger.info("Storage : ");
	        int storage = scan.nextInt();
	        logger.info("Screen Size : ");
	        float screenSize = scan.nextFloat();
	        logger.info("RAM : ");
	        int ram = scan.nextInt();
	        logger.info("Brand : \n");
	        int i = 0;
		       for(String element : brands)
		       {
		    	   	logger.info((i+1) + " - " + element);
		    	   	i++;
		       }
	        String selectedBrand = scan.next();
	        Integer.parseInt(selectedBrand);
	        int selectedBrandIndex = Integer.parseInt(selectedBrand);
	        var brandName = brands.toArray()[selectedBrandIndex - 1].toString();
			notebook = new Notebook(NotebookImpl.notebookProducts.size() + 1,unitPrice,discountRate,stockAmount,name,brandName,ram,storage,screenSize);
		}catch(Exception e) {
			logger.info(e.getLocalizedMessage());
		}
		return notebook;		
	}
	@Override
	public int selectType() {
		logger.info("Yapmak istediğiniz işlemi seçiniz \n1 - Mobile\n2 - Notebook");
		var userInput = scan.next();
		Integer.parseInt(userInput);
		int userIntInput = Integer.parseInt(userInput);
		if((userIntInput >0 && userIntInput <3))
		{
			return userIntInput;	        		
		} else {
			logger.info("Girdi değeri hatalı olduğu için işleme devam edilemiyor\n");
		}
		return 0;
	}
	@Override
	public void getBrands() {
		 int i = 0;
	       for(String element : brands)
	       {
	    	   	logger.info((i+1) + " - " + element);
	    	   	i++;
	       }		
	}
	@Override
	public int takeProductId() {
		logger.info("Silmek istediğiniz ürünün idsini giriniz");
		var userInput = scan.next();
		Integer.parseInt(userInput);
		int userIntInput = Integer.parseInt(userInput);
		if((userIntInput >0))
		{
			return userIntInput;        		
		} else {
			logger.info("Girdi değeri hatalı olduğu için işleme devam edilemiyor\n");
		}		
		return 0;
	}
}