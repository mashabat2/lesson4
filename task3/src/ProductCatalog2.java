import java.util.*;

public class ProductCatalog2 {
    private final List<Product> products = new ArrayList<>();

    public List<Product> getAllProducts() {
        return products;
    }

    public void createProduct(Product product) throws ProductAlreadyExists {
        if (products.indexOf(product) != -1) {
            throw new ProductAlreadyExists("Товар уже добавлен");
        }
        else {
            products.add(product);
        }
    }

    public void updateProduct(Product product) throws ProductNotValid {
        List<Long> names = new ArrayList<>();
        for (Product x : products) {
            names.add(x.getId());
        }
        if (names.contains(product.getId())) {
            if (product.getName().equals("")) throw new ProductNotValid("Название не задано");
            products.add(names.indexOf(product.getId()), product);
            products.remove(names.indexOf(product.getId())+1);
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




