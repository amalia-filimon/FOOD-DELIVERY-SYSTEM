package presentation;

import businessLogic.BaseProduct;
import businessLogic.CompositeProduct;
import model.Administrator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Set;
import java.util.List;

public class ClientGUI extends JFrame {
    private JPanel contentPane;
    private JButton viewMenuBtn;
    private JButton searchBtn;
    private JButton createOrderBtn;
    private JButton compositeProductsBtn;
    private JButton backBtn;
    private JLabel viewMenuLbl;
    private JLabel searchLbl;
    private JLabel titleLbl;
    private JLabel ratingLbl;
    private JLabel caloriesLbl;
    private JLabel proteinLbl;
    private JLabel fatLbl;
    private JLabel sodiumLbl;
    private JLabel priceLbl;
    private JLabel createOrderLbl;
    private JLabel dateLbl;
    private JLabel timeLbl;
    private JTextField dateTextF;
    private JTextField timeTextF;
    private JTextField titleTextF;
    private JTextField ratingTextF;
    private JTextField caloriesTextF;
    private JTextField proteinTextF;
    private JTextField fatTextF;
    private JTextField sodiumTextF;
    private JTextField priceTextF;


    public ClientGUI(Administrator admin){
        setTitle("Client operations");
        setBounds(200, 200, 550, 450);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setBackground(Color.ORANGE);

        viewMenuLbl = new JLabel("See the menus here: ");
        viewMenuLbl.setFont(new Font("Tahoma", Font.ITALIC, 15));
        viewMenuLbl.setBounds(10, 10, 200, 20);
        contentPane.add(viewMenuLbl);

        viewMenuBtn = new JButton("Base products");
        viewMenuBtn.setBounds(170, 10, 160, 20);
        contentPane.add(viewMenuBtn);

        compositeProductsBtn = new JButton("Composite products");
        compositeProductsBtn.setBounds(350, 10, 160, 20);
        contentPane.add(compositeProductsBtn);

        searchLbl = new JLabel("Search for products based on one or multiple criteria:");
        searchLbl.setFont(new Font("Tahoma", Font.ITALIC, 15));
        searchLbl.setBounds(10, 50, 400, 20);
        contentPane.add(searchLbl);

        titleLbl = new JLabel("title");
        titleLbl.setFont(new Font("Tahoma", Font.ITALIC, 15));
        titleLbl.setBounds(20, 80, 50, 20);
        contentPane.add(titleLbl);

        titleTextF = new JTextField();
        titleTextF.setBounds(60, 80, 120, 20);
        contentPane.add(titleTextF);

        ratingLbl = new JLabel("rating");
        ratingLbl.setFont(new Font("Tahoma", Font.ITALIC, 15));
        ratingLbl.setBounds(10, 110, 50, 20);
        contentPane.add(ratingLbl);

        ratingTextF = new JTextField();
        ratingTextF.setBounds(60, 110, 120, 20);
        contentPane.add(ratingTextF);

        caloriesLbl = new JLabel("calories");
        caloriesLbl.setFont(new Font("Tahoma", Font.ITALIC, 15));
        caloriesLbl.setBounds(5, 140, 60, 20);
        contentPane.add(caloriesLbl);

        caloriesTextF = new JTextField();
        caloriesTextF.setBounds(60, 140, 120, 20);
        contentPane.add(caloriesTextF);

        proteinLbl = new JLabel("protein");
        proteinLbl.setFont(new Font("Tahoma", Font.ITALIC, 15));
        proteinLbl.setBounds(5, 170, 60, 20);
        contentPane.add(proteinLbl);

        proteinTextF = new JTextField();
        proteinTextF.setBounds(60, 170, 120, 20);
        contentPane.add(proteinTextF);

        fatLbl = new JLabel("fat");
        fatLbl.setFont(new Font("Tahoma", Font.ITALIC, 15));
        fatLbl.setBounds(270, 80, 60, 20);
        contentPane.add(fatLbl);

        fatTextF = new JTextField();
        fatTextF.setBounds(310, 80, 120, 20);
        contentPane.add(fatTextF);

        sodiumLbl = new JLabel("sodium");
        sodiumLbl.setFont(new Font("Tahoma", Font.ITALIC, 15));
        sodiumLbl.setBounds(250, 110, 60, 20);
        contentPane.add(sodiumLbl);

        sodiumTextF = new JTextField();
        sodiumTextF.setBounds(310, 110, 120, 20);
        contentPane.add(sodiumTextF);

        priceLbl = new JLabel("price");
        priceLbl.setFont(new Font("Tahoma", Font.ITALIC, 15));
        priceLbl.setBounds(260, 140, 60, 20);
        contentPane.add(priceLbl);

        priceTextF = new JTextField();
        priceTextF.setBounds(310, 140, 120, 20);
        contentPane.add(priceTextF);

        searchBtn = new JButton("Search");
        searchBtn.setBounds(310, 170, 120, 20);
        contentPane.add(searchBtn);

        createOrderLbl = new JLabel("To create a new order, complete the data and press the next button:");
        createOrderLbl.setFont(new Font("Tahoma", Font.ITALIC, 15));
        createOrderLbl.setBounds(10, 210, 480, 20);
        contentPane.add(createOrderLbl);

        dateLbl = new JLabel("Order date:");
        dateLbl.setFont(new Font("Tahoma", Font.ITALIC, 15));
        dateLbl.setBounds(20, 250, 80, 20);
        contentPane.add(dateLbl);

        dateTextF = new JTextField();
        dateTextF.setBounds(120, 250, 150, 20);
        contentPane.add(dateTextF);

        timeLbl = new JLabel("Order time:");
        timeLbl.setFont(new Font("Tahoma", Font.ITALIC, 15));
        timeLbl.setBounds(20, 290, 80, 20);
        contentPane.add(timeLbl);

        timeTextF = new JTextField();
        timeTextF.setBounds(120, 290, 150, 20);
        contentPane.add(timeTextF);

        createOrderBtn = new JButton("Create new order");
        createOrderBtn.setBounds(350, 270, 150, 20);
        contentPane.add(createOrderBtn);

        backBtn = new JButton("Back");
        backBtn.setBounds(200, 360, 150, 20);
        contentPane.add(backBtn);

    }

    public void menuBtnAL(ActionListener action){
        this.viewMenuBtn.addActionListener(action);
    }

    public void searchBtnAL(ActionListener action){
        this.searchBtn.addActionListener(action);
    }

    public String getTitleTextF(){
        return this.titleTextF.getText();
    }

    public String getRatingTextF(){
        return this.ratingTextF.getText();
    }

    public String getCaloriesTextF(){
        return this.caloriesTextF.getText();
    }

    public String getProteinTextF(){
        return this.proteinTextF.getText();
    }

    public String getFatTextF(){
        return this.fatTextF.getText();
    }

    public String getSodiumTextF(){
        return this.sodiumTextF.getText();
    }

    public String getPriceTextF(){
        return this.priceTextF.getText();
    }

    public void createOrderAL(ActionListener action){
        this.createOrderBtn.addActionListener(action);
    }

    public void compositeProductsBtnAL(ActionListener action){
        this.compositeProductsBtn.addActionListener(action);
    }

    public String orderDateTextF(){
        return this.dateTextF.getText();
    }

    public String orderTimeTextF(){
        return this.timeTextF.getText();
    }

    public void backBtnAL(ActionListener action){
        this.backBtn.addActionListener(action);
    }
}
