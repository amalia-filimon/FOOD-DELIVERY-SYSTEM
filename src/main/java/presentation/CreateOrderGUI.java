package presentation;

import businessLogic.BaseProduct;
import businessLogic.CompositeProduct;
import model.Administrator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Set;

public class CreateOrderGUI extends JFrame {
    private JPanel contentPane;
    private JLabel selectLbl;
    private JComboBox comboBox;
    private JButton addItemBtn;
    private JButton createOrderBtn;
    private JButton backBtn;
    public CreateOrderGUI(Administrator admin){
        setTitle("Order system");
        setBounds(200, 200, 600, 300);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setBackground(Color.ORANGE);

        selectLbl = new JLabel("Select the products you want to order:");
        selectLbl.setFont(new Font("Tahoma", Font.ITALIC, 15));
        selectLbl.setBounds(15, 10, 500, 50);
        contentPane.add(selectLbl);

        Set<BaseProduct> products = admin.getListProducts();
        List<CompositeProduct> listCompositeProducts = admin.getListCompositeProducts();

        int sizeListProducts = products.size() + listCompositeProducts.size();
        String[] productNames = new String[sizeListProducts];
        int i = 0;
        for(BaseProduct b : products){
            productNames[i] = b.getTitle();
            i++;
        }
        if(listCompositeProducts.isEmpty() == false){
            for(CompositeProduct cp : listCompositeProducts){
                productNames[i] = cp.getTitle();
                i++;
            }
        }

        comboBox = new JComboBox(productNames);
        comboBox.setBounds(40, 60, 500, 30);
        contentPane.add(comboBox);

        addItemBtn = new JButton("Add to cart");
        addItemBtn.setBounds(230, 100, 120, 20);
        contentPane.add(addItemBtn);

        createOrderBtn = new JButton("Create order");
        createOrderBtn.setBounds(230, 140, 120, 20);
        contentPane.add(createOrderBtn);

        backBtn = new JButton("Back");
        backBtn.setBounds(230, 180, 120, 20);
        contentPane.add(backBtn);
    }
    public String getComboBoxText(){
        return (String) this.comboBox.getSelectedItem();
    }

    public void addItemAL(ActionListener action){
        this.addItemBtn.addActionListener(action);
    }

    public void createOrderAL(ActionListener action){
        this.createOrderBtn.addActionListener(action);
    }

    public void backBtnAL(ActionListener action){
        this.backBtn.addActionListener(action);
    }

}
