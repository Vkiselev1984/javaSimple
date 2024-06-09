import java.util.List;

public interface VendingMachine {

    abstract void addProduct(Product product);

    public void initProducts(List<Product>listProduct);

    public Product getProduct(String name);
}
