package presentation;

import businessLogic.BaseProduct;
import model.Administrator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Set;

public class ModifyAndCreateCompositeProductGUI extends JFrame {
    private JLabel modifyLbl;
    private JLabel titleLbl;
    private JLabel ratingLbl;
    private JLabel caloriesLbl;
    private JLabel proteinLbl;
    private JLabel fatLbl;
    private JLabel sodiumLbl;
    private JLabel priceLbl;
    private JLabel compositeProductLbl;
    private JComboBox comboBox1;
    private JPanel contentPane;
    private JButton modifyProductBtn;
    private JButton createProductBtn;
    private JTextField titleTextF;
    private JTextField ratingTextF;
    private JTextField caloriesTextF;
    private JTextField proteinTextF;
    private JTextField fatTextF;
    private JTextField sodiumTextF;
    private JTextField priceTextF;
    private JTextField compositeProductNameTextF;

    public ModifyAndCreateCompositeProductGUI(Administrator admin){
        setTitle("Composite products");
        setBounds(200, 200, 600, 550);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setBackground(Color.ORANGE);

        modifyLbl = new JLabel("<html>To modify an existing product, select it from the box below and fill in the new values in the appropriate boxes:</html>");
        modifyLbl.setFont(new Font("Tahoma", Font.ITALIC, 15));
        modifyLbl.setBounds(15, 20, 500, 50);
        contentPane.add(modifyLbl);

        Set<BaseProduct> products = admin.getListProducts();
        int sizeListProducts = products.size();
        String[] productNames = new String[sizeListProducts];
        int i = 0;
        for(BaseProduct b : products){
            productNames[i] = b.getTitle();
            i++;
        }
        comboBox1 = new JComboBox(productNames);
        comboBox1.setBounds(40, 80, 500, 30);
        contentPane.add(comboBox1);

        titleLbl = new JLabel("Title");
        titleLbl.setFont(new Font("Tahoma", Font.ITALIC, 15));
        titleLbl.setBounds(80, 140, 50, 20);
        contentPane.add(titleLbl);

        titleTextF = new JTextField();
        titleTextF.setBounds(130, 140, 210, 20);
        contentPane.add(titleTextF);

        ratingLbl = new JLabel("Rating");
        ratingLbl.setFont(new Font("Tahoma", Font.ITALIC, 15));
        ratingLbl.setBounds(70, 170, 50, 20);
        contentPane.add(ratingLbl);

        ratingTextF = new JTextField();
        ratingTextF.setBounds(130, 170, 210, 20);
        contentPane.add(ratingTextF);

        caloriesLbl = new JLabel("Calories");
        caloriesLbl.setFont(new Font("Tahoma", Font.ITALIC, 15));
        caloriesLbl.setBounds(70, 200, 100, 20);
        contentPane.add(caloriesLbl);

        caloriesTextF = new JTextField();
        caloriesTextF.setBounds(130, 200, 210, 20);
        contentPane.add(caloriesTextF);

        proteinLbl = new JLabel("Protein");
        proteinLbl.setFont(new Font("Tahoma", Font.ITALIC, 15));
        proteinLbl.setBounds(70, 230, 100, 20);
        contentPane.add(proteinLbl);

        proteinTextF = new JTextField();
        proteinTextF.setBounds(130, 230, 210, 20);
        contentPane.add(proteinTextF);

        fatLbl = new JLabel("Fat");
        fatLbl.setFont(new Font("Tahoma", Font.ITALIC, 15));
        fatLbl.setBounds(80, 260, 50, 20);
        contentPane.add(fatLbl);

        fatTextF = new JTextField();
        fatTextF.setBounds(130, 260, 210, 20);
        contentPane.add(fatTextF);

        sodiumLbl = new JLabel("Sodium");
        sodiumLbl.setFont(new Font("Tahoma", Font.ITALIC, 15));
        sodiumLbl.setBounds(70, 290, 100, 20);
        contentPane.add(sodiumLbl);

        sodiumTextF = new JTextField();
        sodiumTextF.setBounds(130, 290, 210, 20);
        contentPane.add(sodiumTextF);

        priceLbl = new JLabel("Price");
        priceLbl.setFont(new Font("Tahoma", Font.ITALIC, 15));
        priceLbl.setBounds(70, 320, 100, 20);
        contentPane.add(priceLbl);

        priceTextF = new JTextField();
        priceTextF.setBounds(130, 320, 210, 20);
        contentPane.add(priceTextF);

        modifyProductBtn = new JButton("Modify product");
        modifyProductBtn.setBounds(380, 230, 150, 20);
        contentPane.add(modifyProductBtn);

        compositeProductLbl = new JLabel("<html>To create a new composite product, enter the name of the new product and press the next button:</html>");
        compositeProductLbl.setFont(new Font("Tahoma", Font.ITALIC, 15));
        compositeProductLbl.setBounds(15, 350, 500, 50);
        contentPane.add(compositeProductLbl);

        compositeProductNameTextF = new JTextField();
        compositeProductNameTextF.setBounds(100, 400, 390, 20);
        contentPane.add(compositeProductNameTextF);

        createProductBtn = new JButton("<html>Create new composite product</html>");
        createProductBtn.setBounds(220, 440, 150, 50);
        contentPane.add(createProductBtn);
    }

    public String getComboBoxText(){
        return (String) this.comboBox1.getSelectedItem();
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

    public void modifyProductAL(ActionListener action){
        this.modifyProductBtn.addActionListener(action);
    }

    public void createCompositeProductBtnAL(ActionListener action){
        this.createProductBtn.addActionListener(action);
    }

    public String productNameTextF(){
        return this.compositeProductNameTextF.getText();
    }

}
