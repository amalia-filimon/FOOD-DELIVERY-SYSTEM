package presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Report1GUI extends JFrame {
    private JPanel contentPane;
    private JLabel titleLbl;
    private JLabel startHourLbl;
    private JLabel endHourLbl;
    private JTextField startHourTextF;
    private JTextField endHourTextF;
    private JButton generateBtn;
    public Report1GUI(){
        setTitle("Report 1");
        setBounds(200, 200, 500, 300);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setBackground(Color.ORANGE);

        titleLbl = new JLabel("<html>A report will be generated with the orders performed between a given start hour and a given end hour regardless the date. Complete the following data to generate the report:</html>");
        titleLbl.setFont(new Font("Tahoma", Font.ITALIC, 15));
        titleLbl.setBounds(10, 10, 460, 80);
        contentPane.add(titleLbl);

        startHourLbl = new JLabel("Start hour:");
        startHourLbl.setFont(new Font("Tahoma", Font.ITALIC, 15));
        startHourLbl.setBounds(100, 100, 80, 20);
        contentPane.add(startHourLbl);

        startHourTextF = new JTextField();
        startHourTextF.setBounds(190, 100, 170, 20);
        contentPane.add(startHourTextF);

        endHourLbl = new JLabel("End hour:");
        endHourLbl.setFont(new Font("Tahoma", Font.ITALIC, 15));
        endHourLbl.setBounds(100, 130, 80, 20);
        contentPane.add(endHourLbl);

        endHourTextF = new JTextField();
        endHourTextF.setBounds(190, 130, 170, 20);
        contentPane.add(endHourTextF);

        generateBtn = new JButton("Generate report");
        generateBtn.setBounds(180, 180, 150, 20);
        contentPane.add(generateBtn);
    }

    public String startHourTextF(){
        return this.startHourTextF.getText();
    }

    public String endHourTextF(){
        return this.endHourTextF.getText();
    }

    public void generateBtnAL(ActionListener action){
        this.generateBtn.addActionListener(action);
    }
}
