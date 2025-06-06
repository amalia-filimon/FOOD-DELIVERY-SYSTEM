package presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Report2GUI extends JFrame {
    private JPanel contentPane;
    private JLabel titleLbl;
    private JTextField numberTextF;
    private JButton generateBtn;
    public Report2GUI(){
        setTitle("Report 2");
        setBounds(200, 200, 300, 250);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setBackground(Color.ORANGE);

        titleLbl = new JLabel("<html>A report will be generated with the products ordered more than a specified number of times so far. Complete the number down below:</html>");
        titleLbl.setFont(new Font("Tahoma", Font.ITALIC, 15));
        titleLbl.setBounds(5, 10, 280, 70);
        contentPane.add(titleLbl);

        numberTextF = new JTextField();
        numberTextF.setBounds(90, 100, 100, 20);
        contentPane.add(numberTextF);

        generateBtn = new JButton("Generate report");
        generateBtn.setBounds(65, 140, 150, 20);
        contentPane.add(generateBtn);
    }

    public String numberTextF(){
        return this.numberTextF.getText();
    }

    public void generateBtn(ActionListener action){
        this.generateBtn.addActionListener(action);
    }
}
