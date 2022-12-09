package UseCases.Concrete;

import java.util.Comparator;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.logging.Logger;

import Entities.MobilePhone;
import Entities.Notebook;
import UseCases.Abstract.IProduct;

public class MobilePhoneImpl extends MobilePhone implements IProduct{
	public final Logger logger;
	public final Scanner scan;
	protected static SortedSet<MobilePhone> mobilePhoneProducts = new TreeSet<>(new Comparator<MobilePhone>() {
	        @Override
	        public int compare(MobilePhone s1, MobilePhone s2) {
	            return s1.brandName.trim().compareTo(s2.brandName.trim());
	        }
	    });
	
	public MobilePhoneImpl(Logger logger,Scanner scan) {
		this.logger = logger;
		this.scan = scan;
		MobilePhone mp1 = new MobilePhone(mobilePhoneProducts.size() + 1,15000.0f,15.0f,20,"mp-1","XIAOMI",8,128,6.4f,"Red",5000);
		mobilePhoneProducts.add(mp1);
		MobilePhone mp2 = new MobilePhone(mobilePhoneProducts.size() + 1,9000.0f,15.0f,20,"mp-2","CASPER",4,64,6.1f,"Blue",4000);
		mobilePhoneProducts.add(mp2);
	}
	@Override
	public <T> void Add(T product) {
		mobilePhoneProducts.add((MobilePhone)product);		
	}

	@Override
	public void Delete(int id) {
		MobilePhone product;
		for(MobilePhone item : mobilePhoneProducts)
		{
			if(item.id == id)
			{
			product = item;	
			System.out.println(mobilePhoneProducts.remove(product));
			break;
			}
		}		
	}

	@Override
	public void ListProductsById() {
		TreeSet<MobilePhone> mobilePhoneListById = new TreeSet<>(new Comparator<MobilePhone>() {
			  @Override
		        public int compare(MobilePhone s1, MobilePhone s2) {
		        	String id1 = Integer.toString(s1.id);
		        	String id2 = Integer.toString(s2.id);
		            return   id1.trim().compareTo(id2.trim());
		        }
		});
		for(var item : mobilePhoneProducts) {
			mobilePhoneListById.add(item);
		}
		 String leftAlignFormat = "| %-2s | %-12s  | %-8f  | %-8f | %-8s | %-8d GB | %-8f | %-5d  | %-8s  | %-8d  |%n";
	        String line = "+--------------------------------------------------------------------------------+%n";
	        System.out.format(line);
	        System.out.format("| ID | Ürün Adı     | Fiyat    | İndirim    | Marka    | Depolama    | Ekran    | RAM     | RENK   | BATARYA     |%n");
	        System.out.format(line);
		 for(MobilePhone phone : mobilePhoneListById){
			   System.out.format(leftAlignFormat,phone.id,phone.name,phone.unitPrice,phone.discountRate,
			            phone.brandName,phone.storage,phone.screenSize,phone.ram,phone.color,phone.batteryPower);	     }		
	}

	@Override
	public void ListProductsByBrand() {
		 String leftAlignFormat = "| %-2s | %-12s  | %-8f  | %-8f | %-8s | %-8d GB | %-8f | %-5d  | %-8s  | %-8d  |%n";
	        String line = "+--------------------------------------------------------------------------------+%n";
	        System.out.format(line);
	        System.out.format("| ID | Ürün Adı     | Fiyat    | İndirim    | Marka    | Depolama    | Ekran    | RAM     | RENK   | BATARYA     |%n");
	        System.out.format(line);
		 for(MobilePhone phone : mobilePhoneProducts){
			   System.out.format(leftAlignFormat,phone.id,phone.name,phone.unitPrice,phone.discountRate,
			            phone.brandName,phone.storage,phone.screenSize,phone.ram,phone.color,phone.batteryPower);	        }  				
	}
	@Override
	public int menu() {
		String result;
		logger.info("İşlem Yapmak İçin Aşağıdaki Sayılardan Birini Giriniz\n1- Telefon Eklemek İçin\n2 - Telefon Silmek İçin\n3 - Telefonları Marka Adlarına Göre Listelemek İçin\n4 - Telefonları ID numaralarına göre sıralamak için\n5 - Programı Sonlandırmak İçin");
		try {
			result = scan.next();
			Integer.parseInt(result);
			return Integer.parseInt(result);
		}catch(Exception e){
			logger.info(e.getLocalizedMessage());
		}
		return 0;		
	}
		
}
