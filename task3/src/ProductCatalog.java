import java.util.*;
public class ProductCatalog {

    Map products = new HashMap<String, List>();

    public List<Product> getAllProducts() {
        return (List) products;
    }

    public void createProduct(Product product) {
        try {
            if (products.keySet().contains(product)) {
                throw new ProductAlreadyExists("Товар уже добавлен");
            } else {
                products.put(product.getId(), new String[]{product.getName(), product.getSupplier(), product.getPrice()});
            }
        } catch (ProductAlreadyExists productAlreadyExists) {
            productAlreadyExists.printStackTrace();
        }
    }

    public void updateProduct(Product product) {
        try {
            if (product.getName() == "") {
                throw new ProductNotValid("Имя не введено.");
            }

            if (!products.keySet().contains(product.getId())) {
                throw new ProductNotFound("Товара с таким id нет.");
            } else {
                products.put(product.getId(), new String[]{product.getName(), product.getSupplier(), product.getPrice()});
            }
        } catch (ProductNotFound notFound) {
            notFound.printStackTrace();
        } catch (ProductNotValid productNotValid) {
            productNotValid.printStackTrace();
        }
    }

    public void deleteProduct(int id) {
        try{
            if(products.keySet().contains(id)){
                products.remove(id);
            }else{
                throw new ProductNotFound("Товар не найден.");
            }
        } catch (ProductNotFound productNotFound) {
            productNotFound.printStackTrace();
        }
    }
}



