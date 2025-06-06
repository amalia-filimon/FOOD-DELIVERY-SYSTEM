package businessLogic;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Order {
    private static final AtomicInteger count = new AtomicInteger(0);
    private int orderID;
    private int idClient;
    private String orderDate;
    private String orderTime;
    private int orderPrice;

    public Order(String orderDate, String orderTime){
        this.orderID = count.incrementAndGet();
        this.orderDate = orderDate;
        this.orderTime = orderTime;
        this.orderPrice = 0;
    }

    public int getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(int orderPrice) {
        this.orderPrice = orderPrice;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public String getOrderDate() {
        return orderDate;
    }

    @Override
    public int hashCode(){
        return this.orderID;
    }

    public String toString(){
        return String.valueOf(this.orderID);
    }

}
