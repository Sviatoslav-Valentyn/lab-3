package Task1_2_3.Freight_department.Exceptions;

public class WrongSellingPriceException extends Exception {
    public WrongSellingPriceException() {
        super("Selling price of good is wrong");
    }
}