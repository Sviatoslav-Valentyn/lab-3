package Task1_2_3.Freight_department;

import Task1_2_3.Freight_department.Exceptions.*;
import Task1_2_3.Save.Good;
import Task1_2_3.Save.Save;

import java.util.Map;

public class Freight_department {

    private Save save;

    public Freight_department(final Save save) {
        this.save = save;
    }

    public Map<Good, Integer> getReport() {
        return save.getWarehouse().getGoods();
    }

    public void receiveCargo(final Good good, final int amount) {
        save.receiveCargo(good, amount);
    }

    public void receiveCargo(final Map<Good, Integer> deliveredGoods) {
        save.receiveCargo(deliveredGoods);
    }
    public boolean validate(final Map<Good, Integer> report) throws
            NoManufacturerException, NoNameException, WrongBuyingPriceException,
            WrongSellingPriceException, WrongAmountException {
        for (Map.Entry<Good, Integer> entry : report.entrySet()) {
            if (entry.getKey().getManufacturer().isEmpty()) {
                throw new NoManufacturerException();
            }
            else if (entry.getKey().getName().isEmpty()) {
                throw new NoNameException();
            }
            else if (entry.getValue() < 0) {
                throw new WrongAmountException();
            }
            else if (entry.getKey().getBuyingPrice() <= 0) {
                throw new WrongBuyingPriceException();
            }
            else if (entry.getKey().getSellingPrice() <= 0) {
                throw new WrongSellingPriceException();
            }
        }

        return true;
    }
}