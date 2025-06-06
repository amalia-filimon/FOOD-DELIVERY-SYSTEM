package businessLogic;

import model.Administrator;
import model.Client;

import java.util.List;

public interface IDeliveryServiceProcessing {
    void addNewClient(Client newClient);
    boolean validateClient(String username, String password);
    boolean validateAdmin(String username, String password);
    void addNewOrder(Order order, List<MenuItem> products);
    void generateReport1(String startHour, String endHour);
    void generateReport2(int number);
    void generateReport3(int number, int amount);
    void generateRaport4(String date);
}
