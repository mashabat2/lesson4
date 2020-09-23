import java.util.*;

public class ProductCatalog2 {
    private List<Product> products = new ArrayList<>();

    public List<Product> getAllProducts() {
        return products;
    }

    public void createProduct(Product product) throws ProductAlreadyExists {
        if (products.indexOf(product) != -1) throw new ProductAlreadyExists("Товар уже добавлен");
        else products.add(product);
    }

    public void updateProduct(Product product) throws ProductNotValid {
        List<Long> ids = new ArrayList<>();
        for (Product catalogProduct : products) {
            ids.add(catalogProduct.getId());
        }
        if (ids.contains(product.getId())) {
            if (product.getName().equals("")) throw new ProductNotValid("Name is not set");
            products.add(ids.indexOf(product.getId()), product);
            products.remove(ids.indexOf(product.getId())+1);
        } else throw new ProductNotFound("Товар не найден");
    }

    public void deleteProduct(long id) {
        boolean deleted = false;
        for (Product x: products) {
            if (x.getId() == id) {
                products.remove(x);
                deleted = true;
            }
        }
        if (!deleted) {
            throw new ProductNotFound("Товар не найден");
        }
    }
}




