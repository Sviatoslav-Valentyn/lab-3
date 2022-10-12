package Task1_2_3;

import Task1_2_3.Service.Service;
import Task1_2_3.Warehouse.Warehouse;
import Task1_2_3.Freight_department.Freight_department;
import Task1_2_3.Freight_department.Exceptions.NoManufacturerException;
import Task1_2_3.Freight_department.Exceptions.NoNameException;
import Task1_2_3.Freight_department.Exceptions.WrongAmountException;
import Task1_2_3.Freight_department.Exceptions.WrongSellingPriceException;
import Task1_2_3.Freight_department.Exceptions.WrongBuyingPriceException;
import Task1_2_3.Client.Client;
import Task1_2_3.Save.Good;
import Task1_2_3.Save.History;
import Task1_2_3.Save.Receipt;
import Task1_2_3.Save.Save;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Task1_2_3 {
    public static void main(String[] args) throws WrongSellingPriceException,
            WrongBuyingPriceException, NoManufacturerException, WrongAmountException, NoNameException {

        final Client client1 = new Client("Andriy");
        final Client client2 = new Client("Sviatoslav");

        final Good electric_scooter = new Good("Xiaomi",
                "Mi Electric Scooter 3 Black", 300, 500);
        Map<Good, Integer> goods = new HashMap<Good, Integer>();
        goods.put(electric_scooter, 20);
        final Good laptop = new Good("Asus", "ASUS ROG Strix G17 G713IC-HX010",
                800, 1100);
        final Good laptop2 = new Good("Apple ", "Apple MacBook Pro 14 M1 Pro",
                1400, 2200);
        final Good playStation  = new Good("Sony", "Sony PlayStation 5 Digital Edition",
                400, 800);
        final Good smart_watch = new Good("Mi Band", "Mi Band 6 NFC",
                30, 65);
        LinkedList<Receipt> history = new LinkedList<Receipt>();

        Save foxtrot = new Save(new Warehouse(goods), new History(history));
        Freight_department foxtrotFreight = new Freight_department(foxtrot);
        foxtrotFreight.receiveCargo(laptop, 30);
        foxtrotFreight.receiveCargo(laptop2, 50);
        foxtrotFreight.receiveCargo(playStation, 50);
        foxtrotFreight.receiveCargo(smart_watch, 200);

        try {
            if (foxtrotFreight.validate(foxtrotFreight.getReport())) {
                System.out.printf("check completed successfully");
            }
        } catch (final NoManufacturerException | NoNameException | WrongBuyingPriceException |
                       WrongSellingPriceException | WrongAmountException err)
        {
            throw new RuntimeException(err);
        }

        Map<Good, Integer> purchase1 = new HashMap<Good, Integer>();
        purchase1.put(playStation, 2);
        purchase1.put(smart_watch, 1);
        purchase1.put(laptop, 2);

        Map<Good, Integer> purchase2 = new HashMap<Good, Integer>();
        purchase2.put(laptop, 1);
        purchase2.put(laptop2, 1);

        Map<Good, Integer> purchase3 = new HashMap<Good, Integer>();
        purchase3.put(laptop2, 2);

        foxtrot.sellGood(purchase1, client1, LocalDate.of(2022, 10, 8));
        foxtrot.sellGood(purchase2, client1, LocalDate.of(2020, 10, 9));
        foxtrot.sellGood(purchase3, client2, LocalDate.of(2022, 10, 9));

        Service service = new Service(foxtrot);
        service.sortGoodsByAlphabet();

        System.out.printf("\n all goods by Andriy: \n");
        service.getAllGoodsByClient(client1);

        System.out.printf("\n all goods by Sviatoslav: \n");
        service.getAllGoodsByClient(client2);

        System.out.printf("biggest income:");
        service.getBiggestIncome();
        System.out.printf("\n");

        System.out.printf("\n most popular godd:");
        service.getMostPopularGood();
        System.out.printf("\n");
    }
}
