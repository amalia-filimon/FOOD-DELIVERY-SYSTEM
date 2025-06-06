package presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Report3GUI extends JFrame {
    private JPanel contentPane;
    private JLabel titleLbl;
    private JLabel amountLbl;
    private JLabel numberLbl;
    private JTextField amountTextF;
    private JTextField numberTextF;
    private JButton generateBtn;

    public Report3GUI(){
        setTitle("Report 3");
        setBounds(200, 200, 400, 300);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setBackground(Color.ORANGE);

        titleLbl = new JLabel("<html>A report will be generated with the clients that have ordered more than a specified number of times so far and the value of the order which was higher than a specified amount. Complete the data down below:</html>");
        titleLbl.setFont(new Font("Tahoma", Font.ITALIC, 15));
        titleLbl.setBounds(5, 10, 380, 100);
        contentPane.add(titleLbl);

        numberLbl = new JLabel("Specified number:");
        numberLbl.setFont(new Font("Tahoma", Font.ITALIC, 15));
        numberLbl.setBounds(40, 120, 200, 20);
        contentPane.add(numberLbl);

        numberTextF = new JTextField();
        numberTextF.setBounds(180, 120, 150, 20);
        contentPane.add(numberTextF);

        amountLbl = new JLabel("Specified amount:");
        amountLbl.setFont(new Font("Tahoma", Font.ITALIC, 15));
        amountLbl.setBounds(40, 160, 200, 20);
        contentPane.add(amountLbl);

        amountTextF = new JTextField();
        amountTextF.setBounds(180, 160, 150, 20);
        contentPane.add(amountTextF);

        generateBtn = new JButton("Generate report");
        generateBtn.setBounds(130, 200, 150, 20);
        contentPane.add(generateBtn);

    }

    public String specifiedNumberTextF(){
        return this.numberTextF.getText();
    }

    public String specifiedAmountTextF(){
        return this.amountTextF.getText();
    }

    public void generateBtnAL(ActionListener action){
        this.generateBtn.addActionListener(action);
    }

}
