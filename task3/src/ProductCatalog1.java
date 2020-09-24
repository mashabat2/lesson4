import java.util.*;

public class ProductCatalog1 {
    HashMap<Long, Product> products = new HashMap<Long, Product>();  // Long - идентификатор

    public List<Product> getAllProducts(){
        return new ArrayList<Product>(products.values());
    }

    public void createProduct(Product product) throws ProductAlreadyExists {
        if (products.keySet().contains(product.getId())) {  // если существует ключ с именем ID
            throw new ProductAlreadyExists("Товар уже добавлен");
        } else {
            products.put(product.getId(), product);
        }
    }

    public void updateProduct(Product product) throws ProductNotFound, ProductNotValid {
        if (product.getName().equals("")) {
            throw new ProductNotValid("Нет имени!");
        }

        if (!products.keySet().contains(product.getId())) {
            throw new ProductNotFound("Товар не найден");
        }
        else {
            products.put(product.getId(), product);
        }
    }

    public void deleteProduct(long id) throws ProductNotFound{
        if (!products.keySet().contains(id)) {
            throw new ProductNotFound("not found");
        }
        else{
            products.remove(id);
        }
    }
}
