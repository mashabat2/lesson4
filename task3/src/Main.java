public class Main {
    public static void main(String[] args) throws ProductNotFound {
        Product first = new Product(10, "Banana", "Farm", "200");
        Product second = new Product(20, "Orange", "Grands", "250");
        ProductCatalog2 catalog = new ProductCatalog2();

        // Добавим продукт
        try {
            catalog.createProduct(first);
            catalog.createProduct(second);

        } catch (ProductAlreadyExists e) {
            e.printStackTrace();
        }

        // вывод информации о продуктах
        for (Product product : catalog.getAllProducts()) {
            product.productInfo();
            System.out.println("____");
        }

        Product third = new Product(30, "Apple", "Farm2", "100");
        // Добавим новый продукт

        try {
            catalog.updateProduct(third);
        } catch (ProductNotValid e) {
            e.printStackTrace();
        }



        // вывод информации о продуктах
        for (Product product : catalog.getAllProducts()) {
            product.productInfo();
            System.out.println("____");
        }

        // удаление продукта
        catalog.deleteProduct(20);


        // вывод информации о продуктах
        for (Product product : catalog.getAllProducts()) {
            product.productInfo();
            System.out.println("____");
        }


    }
}
