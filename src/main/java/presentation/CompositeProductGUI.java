package presentation;

import businessLogic.BaseProduct;
import businessLogic.CompositeProduct;
import model.Administrator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Set;

public class CompositeProductGUI extends JFrame{
    private JPanel contentPane;
    private JLabel selectLbl;
    private JComboBox comboBox2;
    private JButton selectProductBtn;
    private JButton doneBtn;
    public CompositeProductGUI(Administrator admin){
        setTitle("Composite products system");
        setBounds(200, 200, 600, 250);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setBackground(Color.ORANGE);

        selectLbl = new JLabel("<html>Select the base products that will make up the new composite product</html>");
        selectLbl.setFont(new Font("Tahoma", Font.ITALIC, 15));
        selectLbl.setBounds(15, 20, 500, 50);
        contentPane.add(selectLbl);

        Set<BaseProduct> products = admin.getListProducts();
        int sizeListProducts = products.size();
        String[] productNames = new String[sizeListProducts];
        int i = 0;
        for(BaseProduct b : products){
            productNames[i] = b.getTitle();
            i++;
        }

        comboBox2 = new JComboBox(productNames);
        comboBox2.setBounds(40, 70, 500, 30);
        contentPane.add(comboBox2);

        selectProductBtn = new JButton("Select product");
        selectProductBtn.setBounds(210, 120, 150, 20);
        contentPane.add(selectProductBtn);

        doneBtn = new JButton("Done");
        doneBtn.setBounds(240, 150, 100, 20);
        contentPane.add(doneBtn);

    }

    public String getComboBoxText2(){
        return (String) this.comboBox2.getSelectedItem();
    }

    public void selectProductBtnAL(ActionListener action){
        this.selectProductBtn.addActionListener(action);
    }

    public void doneBtnAL(ActionListener action){
        this.doneBtn.addActionListener(action);
    }
}
