package presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Report4GUI extends JFrame {
    private JPanel contentPane;
    private JLabel titleLbl;
    private JTextField dayTextF;
    private JButton generateBtn;
    public Report4GUI(){
        setTitle("Report 4");
        setBounds(200, 200, 400, 250);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setBackground(Color.ORANGE);

        titleLbl = new JLabel("<html>A report will be generated with the products ordered within a specified day with the number of times they have been ordered. Complete the data down below:</html>");
        titleLbl.setFont(new Font("Tahoma", Font.ITALIC, 15));
        titleLbl.setBounds(5, 15, 380, 80);
        contentPane.add(titleLbl);

        dayTextF = new JTextField();
        dayTextF.setBounds(120, 100, 150, 20);
        contentPane.add(dayTextF);

        generateBtn = new JButton("Generate report");
        generateBtn.setBounds(120, 140, 150, 20);
        contentPane.add(generateBtn);
    }

    public void generateBtnAL(ActionListener action){
        this.generateBtn.addActionListener(action);
    }

    public String getDayTextF(){
        return this.dayTextF.getText();
    }
}
