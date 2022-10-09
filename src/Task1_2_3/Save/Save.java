package Task1_2_3.Save;

import Task1_2_3.Client.Client;
import Task1_2_3.Warehouse.Warehouse;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Save {
    private Warehouse warehouse;
    protected History history;

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public History getHistory() {
        return history;
    }

    public void setWarehouse(final Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public Save(final Warehouse warehouse, final History history) {
        this.warehouse = warehouse;
        this.history = history;
    }

    public void sellGood(final Map<Good, Integer> goods, final Client client, final LocalDate date) {
        final Map<Good, Integer> tmp = new HashMap<Good, Integer>();
        Receipt r = new Receipt(tmp, client, date);

        for (Map.Entry<Good, Integer> entry : goods.entrySet()) {
            warehouse.sellGood(entry.getKey(), entry.getValue());
            r.addGood(entry.getKey(), entry.getValue());
        }

        history.addReceipt(r);
    }

    public void receiveCargo(final Good good, final int amount) {
        warehouse.addGood(good, amount);
    }

    public void receiveCargo(final Map<Good, Integer> deliveredGoods) {
        warehouse.addGood(deliveredGoods);
    }

    @Override
    public String toString() {
        return "Save{" +
                "warehouse=" + warehouse +
                ", history=" + history +
                '}';
    }
}