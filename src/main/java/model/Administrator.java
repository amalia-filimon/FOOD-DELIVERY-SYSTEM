package model;

import businessLogic.BaseProduct;
import businessLogic.CompositeProduct;
import businessLogic.Order;
import presentation.AdministratorGUI;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Administrator{
    private Set<BaseProduct> listBaseProducts;
    private List<CompositeProduct> listCompositeProducts;
    private String username;
    private String password;
    public Administrator(String username, String password){
        this.username = username;
        this.password = password;
        listCompositeProducts = new ArrayList<>();
        listBaseProducts = new TreeSet<>();
        List<List<String>> data =  new ArrayList<>();

        try (Stream<String> linesStream = Files.lines(Paths.get("products.csv"))) {
            linesStream.forEach(line -> {
                List<String> lineData = Arrays.asList(line.split(","));
                data.add(lineData);
            });
        } catch (IOException e) {
            System.out.println("input is not found ");
        }

        for(List<String> list : data){
            BaseProduct b = new BaseProduct(list.get(0), list.get(1), list.get(2), list.get(3), list.get(4), list.get(5), list.get(6));
            this.listBaseProducts.add(b);
        }
    }

    public String getUsername() {
        return username;
    }

    public void addNewBaseProduct(BaseProduct b){
        this.listBaseProducts.add(b);
    }

    public void deleteProduct(BaseProduct b){
        this.listBaseProducts.remove(b);
    }

    public void modifyProduct(String selectedProduct, String title, String rating, String calories, String protein, String fat, String sodium, String price){
        Set<BaseProduct> products = this.listBaseProducts;
        String titleB, ratingB, caloriesB, proteinB, fatB, sodiumB, priceB;
        for(BaseProduct b : products){
            if(b.getTitle().equals(selectedProduct)){
                titleB = b.getTitle();
                ratingB = b.getRating();
                caloriesB = b.getCalories();
                proteinB = b.getProtein();
                fatB = b.getFat();
                sodiumB = b.getSodium();
                priceB = b.getPrice();
                if(title.compareTo("") != 0){
                    b.setTitle(title);
                }else b.setTitle(titleB);
                if(rating.compareTo("") != 0){
                    b.setRating(rating);
                }else b.setRating(ratingB);
                if(calories.compareTo("") != 0){
                    b.setCalories(calories);
                }else b.setCalories(caloriesB);
                if(protein.compareTo("") != 0){
                    b.setProtein(protein);
                }else b.setProtein(proteinB);
                if(fat.compareTo("") != 0){
                    b.setFat(fat);
                }else b.setFat(fatB);
                if(sodium.compareTo("") != 0){
                    b.setSodium(sodium);
                }else b.setSodium(sodiumB);
                if(price.compareTo("") != 0){
                    b.setPrice(price);
                }else b.setPrice(priceB);
            }
        }
    }

    public Set<BaseProduct> getListProducts() {
        return listBaseProducts;
    }

    public void addNewCompositeProduct(CompositeProduct cp){
        this.listCompositeProducts.add(cp);
    }

    public List<CompositeProduct> getListCompositeProducts() {
        return listCompositeProducts;
    }
}
