package Task1_2_3.Freight_department.Exceptions;

public class WrongAmountException extends Exception {
    public WrongAmountException() {
        super("Amount of goods is wrong");
    }
}