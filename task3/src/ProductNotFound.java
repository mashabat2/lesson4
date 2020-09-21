public class ProductNotFound extends Exception{
    private String sms;

    ProductNotFound(String sms){
        this.sms = sms;
    }
    ProductNotFound(){
        this.sms = "Товар в корзине.";
    }
}

