package UseCases.Concrete;

import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.logging.Logger;

import Entities.Notebook;
import UseCases.Abstract.IProduct;


public class NotebookImpl extends Notebook implements IProduct {
	public final Logger logger;
	public final Scanner scan;
	 protected static TreeSet<Notebook> notebookProducts = new TreeSet<>(new Comparator<Notebook>() {
	        @Override
	        public int compare(Notebook s1, Notebook s2) {
	            return s1.brandName.trim().compareTo(s2.brandName.trim());
	        }
	    });
	public NotebookImpl(Logger logger,Scanner scan) { 
		this.logger = logger;
		this.scan = scan;
		Notebook n1 = new Notebook(notebookProducts.size() + 1,10.0f,15.0f,10,"pc-1","SAMSUNG",16,512,14.1f);
		notebookProducts.add(n1);
		Notebook n2 = new Notebook(notebookProducts.size() + 1,30.0f,22.0f,48,"pc-2","XIAOMI",32,1024,17.3f);
		notebookProducts.add(n2);
		Notebook n3 = new Notebook(notebookProducts.size() + 1,30.0f,22.0f,24,"pc-3","ASUS",32,256,15.6f);

		notebookProducts.add(n3);
	}
	@Override
	public <T> void Add(T product) {
		notebookProducts.add((Notebook) product);

	}

	@Override
	public void Delete(int id) {
		var productList = notebookProducts.toArray();
		Notebook product = (Notebook) productList[id-1];
		System.out.println(notebookProducts.remove(product));
	}

	@Override
	public void ListProductsById() {
		
	TreeSet<Notebook> notebookListById = new TreeSet<>(new Comparator<Notebook>() {
		  @Override
	        public int compare(Notebook s1, Notebook s2) {
	        	String id1 = Integer.toString(s1.id);
	        	String id2 = Integer.toString(s2.id);
	            return   id1.trim().compareTo(id2.trim());
	        }
	});
	for(var item : notebookProducts) {
		notebookListById.add(item);
	}
	 for(Notebook notebook : notebookListById){
         System.out.println(notebook.name + " " + notebook.unitPrice+ " " + notebook.brandName);
     }
	}

	@Override
	public void ListProductsByBrand() {
		   for(Notebook notebook : notebookProducts){
	            System.out.println(notebook.name + " " + notebook.unitPrice + " " + notebook.brandName);
	        }  	
		   }
	@Override
	public int menu() {
		String result;
		logger.info("İşlem Yapmak İçin Aşağıdaki Sayılardan Birini Giriniz\n1- Notebook Eklemek İçin\n2 - Notebook Silmek İçin\n3 - Notebookları Marka Adlarına Göre Listelemek İçin\n4 - Notebookları ID numaralarına göre sıralamak için\n5 - Programı Sonlandırmak İçin");
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
