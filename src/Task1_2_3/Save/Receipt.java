package Task1_2_3.Save;
import java.time.LocalDate;
import java.util.Map;

import Task1_2_3.Client.Client;

public class Receipt {
    private Map<Good, Integer> goods;
    private Client client;

    private LocalDate date;

    public Receipt(final Map<Good, Integer> goods, final Client client, final LocalDate date) {
        this.goods = goods;
        this.client = client;
        this.date = date;
    }

    public Receipt(final Client client, final LocalDate date) {
        this.client = client;
        this.date = date;
    }

    public Receipt(final Map<Good, Integer> goods, final Client client) {
        this.goods = goods;
        this.client = client;
    }

    public Receipt(final Client client) {
        this.client = client;
    }


    public Receipt() {
    }

    public LocalDate getDate() {
        return date;
    }


    public Map<Good, Integer> getGoods() {
        return goods;
    }

    public Client getClient() {
        return client;
    }

    public void addGood(final Good good, final int amount) {
        final Good tmp = new Good(good.getManufacturer(), good.getName(), good.getBuyingPrice(), good.getSellingPrice());
        this.goods.put(tmp, amount);
    }

    public void addGood(final Map<Good, Integer> goods) {
        for (Map.Entry<Good, Integer> entry : goods.entrySet()) {
            final Good tmp = new Good(entry.getKey().getManufacturer(), entry.getKey().getName(), entry.getKey().getBuyingPrice(), entry.getKey().getSellingPrice());
            this.goods.put(tmp, entry.getValue());
        }
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "goods=" + goods +
                ", client=" + client +
                ", date=" + date +
                '}';
    }
}