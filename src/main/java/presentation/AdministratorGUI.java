package presentation;

import model.Administrator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class AdministratorGUI extends JFrame {
    private JPanel contentPane;
    private JLabel menuLbl;
    private JLabel manageProductsLbl;
    private JLabel titleLbl;
    private JLabel ratingLbl;
    private JLabel caloriesLbl;
    private JLabel proteinLbl;
    private JLabel fatLbl;
    private JLabel sodiumLbl;
    private JLabel priceLbl;
    private JLabel compositeProductLbl;
    private JLabel createReportsLbl;
    private JButton menuBaseProductsBtn;
    private JButton menuCompositeProductsBtn;
    private JButton addProductBtn;
    private JButton deleteProductBtn;
    private JButton createOrModifyBtn;
    private JButton selectReportBtn;
    private JButton backToLoginBtn;
    private JTextField titleTextF;
    private JTextField ratingTextF;
    private JTextField caloriesTextF;
    private JTextField proteinTextF;
    private JTextField fatTextF;
    private JTextField sodiumTextF;
    private JTextField priceTextF;
    private JComboBox comboBox;

    public AdministratorGUI(Administrator admin){
        setTitle("Administrator operations");
        setBounds(200, 200, 450, 700);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setBackground(Color.ORANGE);

        menuLbl = new JLabel("Current menu here:");
        menuLbl.setFont(new Font("Tahoma", Font.ITALIC, 15));
        menuLbl.setBounds(10, 10, 150, 20);
        contentPane.add(menuLbl);

        menuBaseProductsBtn = new JButton("<html>Base Products</html>");
        menuBaseProductsBtn.setBounds(155, 10, 120, 20);
        contentPane.add(menuBaseProductsBtn);

        menuCompositeProductsBtn = new JButton("<html>Composite Products</html>");
        menuCompositeProductsBtn.setBounds(280, 10, 150, 20);
        contentPane.add(menuCompositeProductsBtn);

        manageProductsLbl = new JLabel("Manage the products from the menu");
        manageProductsLbl.setFont(new Font("Tahoma", Font.ITALIC, 15));
        manageProductsLbl.setBounds(10, 50, 250, 20);
        contentPane.add(manageProductsLbl);

        titleLbl = new JLabel("Title");
        titleLbl.setFont(new Font("Tahoma", Font.ITALIC, 15));
        titleLbl.setBounds(80, 90, 50, 20);
        contentPane.add(titleLbl);

        titleTextF = new JTextField();
        titleTextF.setBounds(130, 90, 210, 20);
        contentPane.add(titleTextF);

        ratingLbl = new JLabel("Rating");
        ratingLbl.setFont(new Font("Tahoma", Font.ITALIC, 15));
        ratingLbl.setBounds(70, 120, 50, 20);
        contentPane.add(ratingLbl);

        ratingTextF = new JTextField();
        ratingTextF.setBounds(130, 120, 210, 20);
        contentPane.add(ratingTextF);

        caloriesLbl = new JLabel("Calories");
        caloriesLbl.setFont(new Font("Tahoma", Font.ITALIC, 15));
        caloriesLbl.setBounds(70, 150, 100, 20);
        contentPane.add(caloriesLbl);

        caloriesTextF = new JTextField();
        caloriesTextF.setBounds(130, 150, 210, 20);
        contentPane.add(caloriesTextF);

        proteinLbl = new JLabel("Protein");
        proteinLbl.setFont(new Font("Tahoma", Font.ITALIC, 15));
        proteinLbl.setBounds(70, 180, 100, 20);
        contentPane.add(proteinLbl);

        proteinTextF = new JTextField();
        proteinTextF.setBounds(130, 180, 210, 20);
        contentPane.add(proteinTextF);

        fatLbl = new JLabel("Fat");
        fatLbl.setFont(new Font("Tahoma", Font.ITALIC, 15));
        fatLbl.setBounds(80, 210, 50, 20);
        contentPane.add(fatLbl);

        fatTextF = new JTextField();
        fatTextF.setBounds(130, 210, 210, 20);
        contentPane.add(fatTextF);

        sodiumLbl = new JLabel("Sodium");
        sodiumLbl.setFont(new Font("Tahoma", Font.ITALIC, 15));
        sodiumLbl.setBounds(70, 240, 100, 20);
        contentPane.add(sodiumLbl);

        sodiumTextF = new JTextField();
        sodiumTextF.setBounds(130, 240, 210, 20);
        contentPane.add(sodiumTextF);

        priceLbl = new JLabel("Price");
        priceLbl.setFont(new Font("Tahoma", Font.ITALIC, 15));
        priceLbl.setBounds(70, 270, 100, 20);
        contentPane.add(priceLbl);

        priceTextF = new JTextField();
        priceTextF.setBounds(130, 270, 210, 20);
        contentPane.add(priceTextF);

        addProductBtn = new JButton("Add product");
        addProductBtn.setBounds(60, 310, 150, 20);
        contentPane.add(addProductBtn);

        deleteProductBtn = new JButton("Delete product");
        deleteProductBtn.setBounds(220, 310, 150, 20);
        contentPane.add(deleteProductBtn);

        compositeProductLbl = new JLabel("<html>If you want to create a composite product or modify an existing one, press the next button:</html>");
        compositeProductLbl.setFont(new Font("Tahoma", Font.ITALIC, 15));
        compositeProductLbl.setBounds(15, 350, 430, 50);
        contentPane.add(compositeProductLbl);

        createOrModifyBtn = new JButton("Create or modify");
        createOrModifyBtn.setBounds(140, 400, 150, 30);
        contentPane.add(createOrModifyBtn);

        createReportsLbl = new JLabel("<html>To generate reports about the performed orders, select the one you want to generate from the next box:</html>");
        createReportsLbl.setFont(new Font("Tahoma", Font.ITALIC, 15));
        createReportsLbl.setBounds(15, 450, 430, 50);
        contentPane.add(createReportsLbl);

        String[] reports = {"Report 1", "Report 2", "Report 3", "Report 4"};
        comboBox = new JComboBox(reports);
        comboBox.setBounds(5, 500, 425, 30);
        contentPane.add(comboBox);

        selectReportBtn = new JButton("Select report");
        selectReportBtn.setBounds(150, 540, 150, 20);
        contentPane.add(selectReportBtn);

        backToLoginBtn = new JButton("Back to login point");
        backToLoginBtn.setBounds(120, 600, 180, 20);
        contentPane.add(backToLoginBtn);

    }

    public void menuBtnAL(ActionListener action){
        this.menuBaseProductsBtn.addActionListener(action);
    }

    public void menuCompositeProductsBtnAL(ActionListener action){
        this.menuCompositeProductsBtn.addActionListener(action);
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

    public void addProductBtnAL(ActionListener action){
        this.addProductBtn.addActionListener(action);
    }

    public void deleteProductBtnAL(ActionListener action){
        this.deleteProductBtn.addActionListener(action);
    }

    public void backToLoginAL(ActionListener action){
        this.backToLoginBtn.addActionListener(action);
    }

    public void createOrModifyProductAL(ActionListener action){
        this.createOrModifyBtn.addActionListener(action);
    }

    public void selectReportBtnAL(ActionListener action){
        this.selectReportBtn.addActionListener(action);
    }

    public String getComboBoxText(){
        return (String) this.comboBox.getSelectedItem();
    }

}
