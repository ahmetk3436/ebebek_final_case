package Presentation.Concrete;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import Presentation.Abstract.IProductPresentation;
import UseCases.Concrete.DataAccessImpl;
import UseCases.Concrete.MobilePhoneImpl;
import UseCases.Concrete.NotebookImpl;



public class ProductPresentation implements IProductPresentation {
	public static final Scanner scan = new Scanner(System.in);
	Logger logger = Logger.getLogger(ProductPresentation.class.getName());
	MobilePhoneImpl mobilePhone = new MobilePhoneImpl(logger,scan);
	NotebookImpl notebook = new NotebookImpl(logger,scan);
	DataAccessImpl dataAccess = new DataAccessImpl(logger,scan);

	public ProductPresentation() {
		logger.setLevel(Level.INFO);
		try {
		takeUserInput();
		}catch(Exception e) {
		logger.info(e.getLocalizedMessage());
		}
		
	}
	private void takeUserInput() {
		boolean stopWhile = true;
		while(stopWhile) {
		try {
			switch(dataAccess.takeUserInput()) {
			case 1:
				productMenu(1);
				break;
			case 2:
				productMenu(2);
				break;
			case 3:
				dataAccess.getBrands();
				break;
			case 4:
				logger.info("------------------");
				mobilePhone.ListProductsByBrand();
				logger.info("------------------");
				notebook.ListProductsByBrand();
				break;
			case 5:
				logger.info("Çıkış yapıldı");
				stopWhile = false;
				System.exit(0);
				break;
				default:
					break;
			}
		}catch(Exception e ) {
			logger.info("Hata mevcut : " + e.getLocalizedMessage());
		}
		}
	}
	@Override
	public <T> void addProduct(T product,int selectedType) {
		try {
			switch(selectedType)
			{
			case 1 : 
				mobilePhone.Add(product);
				break;
			case 2: 
				notebook.Add(product);
				break;
				default:
					break;
			}
		}catch(Exception e )
		{
			logger.info("Ürün eklenemedi hata mevcut : "+ e.getLocalizedMessage());
		}
	
		
	}
	@Override
	public void deleteProduct(int selectedType,int productId) {
		try {
			switch(selectedType)
			{
			case 1: 
				mobilePhone.Delete(productId);
				break;
			case 2: 
				notebook.Delete(productId);
				break;
				default:
					break;
			}
		}catch(Exception e )
		{
			logger.info("Ürün silinemedi hata mevcut : " + e.getLocalizedMessage());
		}
	}
	@Override
	public void listProductById(int selectedType) {
		try {
			switch(selectedType)
			{
			case 1: 
				mobilePhone.ListProductsById();
				break;
			case 2: 
				notebook.ListProductsById();
				break;
				default:
					break;
			}
		}catch(Exception e )
		{
logger.info("Ürünler ID numarasına göre listelenemedi hata mevcut : " + e.getLocalizedMessage());
		}		
	}
	@Override
	public void listProductByBrandName(int selectedType) {
		try {
			switch(selectedType)
			{
			case 1: 
				mobilePhone.ListProductsByBrand();
				break;
			case 2: 
				notebook.ListProductsByBrand();
				break;
				default:
					break;
			}
		}catch(Exception e )
		{
			logger.info("Ürünler markasına göre listelenemedi hata mevcut :  " + e.getLocalizedMessage());
		}			
	}
	@Override
	public void productMenu(int selectedType) {
			switch(selectedType) {
			case 2:
				switch(mobilePhone.menu()) {
				case 1:
					addProduct(dataAccess.takeMobilePhoneData(),1);
					break;
				case 2:
					deleteProduct(1,dataAccess.takeProductId());
					break;
				case 3:
					mobilePhone.ListProductsByBrand();
					break;
				case 4:
					mobilePhone.ListProductsById();
					break;
				case 5:
					System.exit(0);
					break;
					default:
				break;
				}
				break;
			case 1: 
				switch(notebook.menu()) {
				case 1:
					addProduct(dataAccess.takeNotebookData(),2);
					break;
				case 2:
					deleteProduct(2,dataAccess.takeProductId());
					break;
				case 3:
					notebook.ListProductsByBrand();
					break;
				case 4:
					notebook.ListProductsById();
					break;
				case 5:
					System.exit(0);
					break;
					default:
				break;
				}
				break;
				default : 
					break;
			}
		}
}
