import java.util.List;
import java.util.ArrayList;

public class CupOfCoffeeVendingMachine implements VendingMachine {

    private List<Product> listProduct;

    public CupOfCoffeeVendingMachine() {
        listProduct = new ArrayList<>();
    }

    @Override
    public void addProduct(Product product) {
        listProduct.add(product);
    }        

    @Override
    public void initProducts(List<Product>listProduct){
        this.listProduct = listProduct;
    }

    @Override
    public Product getProduct(String name){
        for(Product product : listProduct){
            if (product.getName().equals(name)){
                return product;
            }
        }
        return null;
    }

    public Product getProduct(String name, double volume, double temperature){
        for(Product product : listProduct){
            if (product.getName().equals(name) && ((CupOfCoffee)product).getTemperature() == temperature && ((CupOfCoffee)product).getVolume() == volume){
                return product;
            }
        }
        return null;
    }
}

