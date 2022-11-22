package Presentation.Abstract;

public interface IProductPresentation {
	<T> void addProduct(T product,int selectedType);
	void deleteProduct(int selectedType,int productId);
	void listProductById(int selectedType);
	void listProductByBrandName(int selectedType);
	void productMenu(int selectedType);
}
