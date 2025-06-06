package businessLogic;

import model.Administrator;

import java.util.ArrayList;
import java.util.List;

public class CompositeProduct implements MenuItem{
    private String title;
    private List<BaseProduct> products;
    private int quantity;

    public CompositeProduct(String title){
        this.title = title;
        this.products = new ArrayList<>();
    }

    public int computePrice(){
        int price = 0;
        for(MenuItem item : products){
            price += item.computePrice();
        }
        return price;
    }

    public void addNewProduct(BaseProduct b){
        this.products.add(b);
    }

    public String getProducts(){
        String print = "";
        for(BaseProduct b : this.products){
            print = print + b.getTitle() + ", ";
        }
        return print;
    }

    public String getTitle() {
        return title;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
