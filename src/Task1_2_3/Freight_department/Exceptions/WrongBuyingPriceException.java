package Task1_2_3.Freight_department.Exceptions;

public class WrongBuyingPriceException extends Exception {
    public WrongBuyingPriceException() {
        super("Buying price of good is wrong");
    }
}