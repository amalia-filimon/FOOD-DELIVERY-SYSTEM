package businessLogic;

import model.Administrator;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class BaseProduct implements Comparable<BaseProduct>, MenuItem{
    private String title;
    private String rating;
    private String calories;
    private String protein;
    private String fat;
    private String sodium;
    private String price;
    private int quantity;

    public BaseProduct(String title, String rating, String calories, String protein, String fat, String sodium, String price){
        this.title = title;
        this.rating = rating;
        this.calories = calories;
        this.protein = protein;
        this.fat = fat;
        this.sodium = sodium;
        this.price = price;
    }

    public String toString(){
        return "title: " + title + ", r: " + rating + ", c: " + calories + ", p: " + price;
    }

    public String getTitle() {
        return title;
    }

    public String getRating() {
        return rating;
    }

    public String getCalories() {
        return calories;
    }

    public String getProtein() {
        return protein;
    }

    public String getFat() {
        return fat;
    }

    public String getSodium() {
        return sodium;
    }

    public String getPrice() {
        return price;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setCalories(String calories) {
        this.calories = calories;
    }

    public void setProtein(String protein) {
        this.protein = protein;
    }

    public void setFat(String fat) {
        this.fat = fat;
    }

    public void setSodium(String sodium) {
        this.sodium = sodium;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public int compareTo(BaseProduct o) {
        return this.getTitle().compareTo(o.getTitle());
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public int computePrice() {
        String priceString = this.getPrice();
        int price = Integer.parseInt(priceString);
        return price;
    }
}
