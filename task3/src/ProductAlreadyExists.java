public class ProductAlreadyExists extends Exception{
    private String sms;

    ProductAlreadyExists(String sms){
        this.sms = sms;
    }
    ProductAlreadyExists(){
        this.sms = "Товар в корзине.";
    }
}
