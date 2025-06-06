package businessLogic;
import model.Client;
import javax.swing.*;
import java.io.FileWriter;
import java.util.*;
import java.util.stream.Collectors;

public class DeliveryService implements IDeliveryServiceProcessing{
    HashMap<Order, List<MenuItem>> orders = new HashMap<>();
    private List<Client> clients;
    public DeliveryService(){
        clients = new ArrayList<>();
    }

    public void addNewClient(Client newClient) {
        boolean usernameUsedAlready = false;
        for(Client c : clients){
            if(c.getUsername().compareTo(newClient.getUsername()) == 0){
                usernameUsedAlready = true;
                JOptionPane.showMessageDialog(null, "The username entered is already in use. Try another one!");
            }
        }
        if(usernameUsedAlready == false){
            clients.add(newClient);
        }
    }

    public boolean validateClient(String username, String password){
        boolean validClient = false;

        for(Client c : clients) {
            if (c.getUsername().equals(username) && c.getPassword().equals(password)) {
                validClient = true;
            }
        }

        if (validClient == false) {
            JOptionPane.showMessageDialog(null, "Invalid username or incorrect password!!! Make sure you have an account!!!");
        }

        return validClient;
    }

    public boolean validateAdmin(String username, String password){
        boolean validAdmin = false;
        if (username.equals("Admin10") && password.equals("aaa")) {
            validAdmin = true;
        }

        if (validAdmin == false) {
            JOptionPane.showMessageDialog(null, "Invalid username or incorrect password for the ADMINISTRATOR account!!!");
        }

        return validAdmin;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void addNewOrder(Order order, List<MenuItem> products) {
        int price = 0;
        this.orders.put(order, products);
        try{
            FileWriter fw = new FileWriter("D:\\PT2022_30229_Amalia_Filimon_Assignment_4\\bills\\bill" + order.getOrderID());
            for(MenuItem menuItem : products){
                price += menuItem.computePrice();
                fw.write(menuItem.getTitle() + "\n");
            }
            fw.write("The total price is: " + price);
            fw.close();
        }catch(Exception e){System.out.println(e);}
    }

    public void generateReport1(String startHour, String endHour){
        int start = Integer.parseInt(startHour);
        int end = Integer.parseInt(endHour);
        Set<Order> ordersFromMap = orders.keySet();
        List<Order> generatedOrders = ordersFromMap.stream()
                .filter(o -> Integer.parseInt(o.getOrderTime()) > start && Integer.parseInt(o.getOrderTime()) < end)
                .collect(Collectors.toList());

        try{
            FileWriter fw = new FileWriter("D:\\PT2022_30229_Amalia_Filimon_Assignment_4\\reports\\Report1");
            fw.write("The following orders were placed between the time interval: " + startHour + " - " + endHour + "\n");
            for(Order order : generatedOrders){
                fw.write("Order ID: " + order.getOrderID() + ", order date: " + order.getOrderDate() + ", order hour: " + order.getOrderTime() + ", PRODUCTS:" + "\n");
                for(MenuItem item : orders.get(order)){
                    fw.write(item.getTitle() + ", ");
                }
                fw.write("\n");
            }
            fw.close();
        }catch(Exception e){System.out.println(e);}
    }

    public void generateReport2(int number){
        Set<Order> ordersFromMap = orders.keySet();
        List<MenuItem> generatedProducts = null;
        for(Order o : ordersFromMap){
            List<MenuItem> products = orders.get(o);
            generatedProducts = products.stream()
                    .filter(p -> p.getQuantity() > number)
                    .collect(Collectors.toList());
        }
        try{
            FileWriter fw = new FileWriter("D:\\PT2022_30229_Amalia_Filimon_Assignment_4\\reports\\Report2");
            fw.write("The following products were ordered more than " + number + " times so far" + "\n");
            for(MenuItem item : generatedProducts){
                fw.write("Title: " + item.getTitle() + ", quantity: " + item.getQuantity() + "\n");
            }
            fw.close();
        }catch(Exception e){System.out.println(e);}

    }

    public void generateReport3(int number, int amount){
        Map<Client, List<Order>> orderedProductsByClient = new HashMap<>();
        List<Client> generatedClients = clients.stream()
                .filter(c -> c.getNumberOrders() > number)
                .collect(Collectors.toList());

        if(generatedClients.isEmpty()){
            try{
                FileWriter fw = new FileWriter("D:\\PT2022_30229_Amalia_Filimon_Assignment_4\\reports\\Report3");
                fw.write("There are NO clients who have ordered more than " + number + " times so far" + "\n");
                fw.close();
            }catch(Exception e){System.out.println(e);}
        }else{
        List<Order> ordersPerClient = new ArrayList<>();
        for(Client c : generatedClients){
            for(Order o : orders.keySet()) {
                if(o.getIdClient() == c.getIdClient()) {
                    int orderPrice = 0;
                    for(MenuItem item : this.orders.get(o)){
                        orderPrice += item.computePrice();
                    }
                        o.setOrderPrice(orderPrice);
                        ordersPerClient.add(o);

                }
            }
            orderedProductsByClient.put(c, ordersPerClient);
        }

        List<Order> totalOrdersPerClient = null;
        for(Client c : orderedProductsByClient.keySet()){
            totalOrdersPerClient = ordersPerClient.stream()
                    .filter(ord -> ord.getOrderPrice() > amount)
                    .collect(Collectors.toList());
        }

        try{
            FileWriter fw = new FileWriter("D:\\PT2022_30229_Amalia_Filimon_Assignment_4\\reports\\Report3");
            fw.write("The following clients have ordered more than " + number + " times so far." + "\n");
            for(Client client : generatedClients){
                fw.write("Username: " + client.getUsername() + ", ID: " + client.getIdClient() + ", Number of orders: " + client.getNumberOrders() + "\n");
            }
            fw.write("And the orders with a value higher than " + amount + "$ are:" + "\n");
            for(Order o : totalOrdersPerClient){
                fw.write("ID Client: " + o.getIdClient() + ", order price: " + o.getOrderPrice() + "$" + "\n");
            }
            fw.close();
        }catch(Exception e){System.out.println(e);}
        }

    }

    public void generateRaport4(String date){

        List<Order> generatedOrders = null;
        generatedOrders = orders.keySet().stream()
                .filter(p -> p.getOrderDate().equals(date))
                .collect(Collectors.toList());

        List<MenuItem> products = new ArrayList<>();

        for(Order o : generatedOrders){
            for(MenuItem item : orders.get(o)){
                products.add(item);
            }
        }

        Map<String, Long> map = null;
        map = products.stream()
                .collect(Collectors.groupingBy(MenuItem::getTitle, Collectors.counting()));

        try{
            FileWriter fw = new FileWriter("D:\\PT2022_30229_Amalia_Filimon_Assignment_4\\reports\\Report4");
            fw.write("The following products were ordered on " + date + ": " + "\n");
            for(String title : map.keySet()){
                    fw.write("Title: " + title + ", quantity: " + map.get(title) + "\n");
            }
            fw.close();
        }catch(Exception e){System.out.println(e);}
    }
}
