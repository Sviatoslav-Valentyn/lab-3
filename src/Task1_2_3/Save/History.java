package Task1_2_3.Save;
import java.util.Iterator;
import java.util.LinkedList;

public class History {
    private LinkedList<Receipt> receipts;

    public History(final LinkedList<Receipt> receipts) {
        this.receipts = receipts;
    }

    public void addReceipt(final Receipt receipt) {
        this.receipts.add(receipt);
    }

    public LinkedList<Receipt> getReceipts() {
        return receipts;
    }

    @Override
    public String toString() {
        return "History{" +
                "receipts=" + receipts +
                '}';
    }
}