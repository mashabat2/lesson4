public class Product {
    private long id;
    private String name;
    private String supplier;
    private String price;

    Product(long id, String name, String supplier, String price){
        this.id = id;
        this.name = name;
        this.supplier = supplier;
        this.price = price;
    }

    public long getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getSupplier(){
        return supplier;
    }
    public String getPrice(){
        return price;
    }

}
