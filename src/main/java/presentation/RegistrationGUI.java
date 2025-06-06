package presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class RegistrationGUI extends JFrame {
    private JPanel contentPane;
    private JLabel usernameLbl;
    private JLabel passwordLbl;
    private JLabel confirmPassLbl;
    private JLabel nameLbl;
    private JLabel addressLbl;
    private JTextField usernameTextF;
    private JPasswordField passwordField;
    private JPasswordField confirmPassField;
    private JTextField nameTextF;
    private JTextField addressTextF;
    private JButton doneBtn;
    private JButton backBtn;

    public RegistrationGUI(){
        setTitle("Registration system");
        setBounds(200, 200, 400, 420);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setBackground(Color.ORANGE);

        usernameLbl = new JLabel("Username");
        usernameLbl.setFont(new Font("Tahoma", Font.BOLD, 13));
        usernameLbl.setBounds(50, 50, 100, 20);
        contentPane.add(usernameLbl);

        usernameTextF = new JTextField();
        usernameTextF.setBounds(150, 50, 180, 20);
        contentPane.add(usernameTextF);

        passwordLbl = new JLabel("Password");
        passwordLbl.setFont(new Font("Tahoma", Font.BOLD, 13));
        passwordLbl.setBounds(50, 100, 100, 20);
        contentPane.add(passwordLbl);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 100, 180, 20);
        contentPane.add(passwordField);

        confirmPassLbl = new JLabel("Confirm password");
        confirmPassLbl.setFont(new Font("Tahoma", Font.BOLD, 13));
        confirmPassLbl.setBounds(20, 150, 120, 20);
        contentPane.add(confirmPassLbl);

        confirmPassField = new JPasswordField();
        confirmPassField.setBounds(150, 150, 180, 20);
        contentPane.add(confirmPassField);

        nameLbl = new JLabel("Name");
        nameLbl.setFont(new Font("Tahoma", Font.BOLD, 13));
        nameLbl.setBounds(60, 200, 100, 20);
        contentPane.add(nameLbl);

        nameTextF = new JTextField();
        nameTextF.setBounds(150, 200, 180, 20);
        contentPane.add(nameTextF);

        addressLbl = new JLabel("Address");
        addressLbl.setFont(new Font("Tahoma", Font.BOLD, 13));
        addressLbl.setBounds(50, 250, 100, 20);
        contentPane.add(addressLbl);

        addressTextF = new JTextField();
        addressTextF.setBounds(150, 250, 180, 20);
        contentPane.add(addressTextF);

        doneBtn = new JButton("DONE");
        doneBtn.setBounds(120, 300, 150, 20);
        contentPane.add(doneBtn);

        backBtn = new JButton("Back to login point");
        backBtn.setBounds(120, 330, 150, 20);
        contentPane.add(backBtn);
    }

    public void addDoneAL(ActionListener action){
        this.doneBtn.addActionListener(action);
    }

    public void addBackAL(ActionListener action){
        this.backBtn.addActionListener(action);
    }

    public String getUsernameTextF(){
        return this.usernameTextF.getText();
    }

    public char[] getFirstPass(){
        return this.passwordField.getPassword();
    }

    public char[] getSecondPass(){
        return this.confirmPassField.getPassword();
    }

    public String getNameTextF(){
        return this.nameTextF.getText();
    }

    public String getAddress(){
        return this.addressTextF.getText();
    }
}
