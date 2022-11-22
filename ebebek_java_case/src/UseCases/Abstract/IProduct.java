package UseCases.Abstract;


public interface IProduct {
	public <T> void Add(T product);
	public void Delete(int id);
	public void ListProductsById();
	public void ListProductsByBrand();
	public int menu();
}
