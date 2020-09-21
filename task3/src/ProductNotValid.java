public class ProductNotValid extends Exception{
    private String sms;

    ProductNotValid(String sms){
        this.sms = sms;
    }
}
