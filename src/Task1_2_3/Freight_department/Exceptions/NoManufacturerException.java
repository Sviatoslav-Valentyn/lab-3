package Task1_2_3.Freight_department.Exceptions;

public class NoManufacturerException extends Exception {
    public NoManufacturerException() {
        super("No manufacturer in good");
    }
}