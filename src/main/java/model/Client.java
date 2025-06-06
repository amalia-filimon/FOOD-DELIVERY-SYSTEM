package model;

import businessLogic.BaseProduct;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Client{

    private String username;
    private String password;
    private String name;
    private String address;
    private int numberOrders;
    private static final AtomicInteger count = new AtomicInteger(0);
    private int idClient;
    public Client(String username, String password, String name, String address){
        this.username = username;
        this.password = password;
        this.name = name;
        this.address = address;
        this.idClient = count.incrementAndGet();
    }

    public Client(){

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public int getIdClient() {
        return idClient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOrders() {
        return numberOrders;
    }

    public void setNumberOrders(int numberOrders) {
        this.numberOrders = numberOrders;
    }

    public List<BaseProduct> searchByCriteria(Administrator admin, String title, String rating, String calories, String protein, String fat, String sodium, String price){
        Set<BaseProduct> data = admin.getListProducts();
        List<BaseProduct> products = new ArrayList<>();
        for(BaseProduct b : data){
            products.add(b);
        }

        List<BaseProduct> filteredData = products
                .stream()
                .filter(b -> b.getTitle().contains(title) && b.getRating().contains(rating) && b.getCalories().contains(calories) && b.getProtein().contains(protein) && b.getFat().contains(fat) && b.getSodium().contains(sodium) && b.getPrice().contains(price))
                .collect(Collectors.toList());

        return filteredData;
    }

    @Override
    public int hashCode(){
        return this.idClient;
    }

}
