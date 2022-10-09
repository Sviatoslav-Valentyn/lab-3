package Task1_2_3.Freight_department.Exceptions;

public class NoNameException extends Exception {
    public NoNameException() {
        super("No name in good");
    }
}