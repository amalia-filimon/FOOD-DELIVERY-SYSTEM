import businessLogic.*;
import model.Administrator;
import presentation.*;

import java.util.ArrayList;
import java.util.List;

public class MainClass {
    public static void main(String[] args){
        LoginGUI login = new LoginGUI();
        Controller controller = new Controller(login);
        login.setVisible(true);
//        DeliveryService delivery = new DeliveryService();
//        delivery.searchByCriteria("Spicy", "", "", "", "", "", "");
//        delivery.makeProductObjects();
//        Administrator admin = new Administrator();
//        admin.readData();
//        AdministratorGUI ad = new AdministratorGUI();
//        ClientGUI c = new ClientGUI();
//        c.setVisible(true);
//        AdministratorGUI admin = new AdministratorGUI();
//        admin.setVisible(true);

//        BaseProduct b = new BaseProduct();
//        CompositeProduct c = new CompositeProduct();
//        List<MenuItem> list = new ArrayList<>();
//        list.add(b);
//        list.add(c);
    }
}
