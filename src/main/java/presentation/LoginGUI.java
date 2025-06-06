package presentation;

import enums.Role;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LoginGUI extends JFrame {
    private JPanel contentPane;
    private JLabel usernameLbl;
    private JLabel passwordLbl;
    private JLabel roleLbl;
    private JLabel dontHaveAnAccount;
    private JButton loginBtn;
    private JButton registerNowBtn;
    private JTextField usernameTextF;
    private JPasswordField passwordField;
    private JComboBox<Role> roleComboBox;

    public LoginGUI(){
        setTitle("Log in system");
        setBounds(200, 200, 400, 400);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setBackground(Color.ORANGE);

        usernameLbl = new JLabel("Username");
        usernameLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
        usernameLbl.setBounds(50, 50, 100, 20);
        contentPane.add(usernameLbl);

        usernameTextF = new JTextField();
        usernameTextF.setBounds(150, 50, 150, 20);
        contentPane.add(usernameTextF);

        passwordLbl = new JLabel("Password");
        passwordLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
        passwordLbl.setBounds(50, 100, 100, 20);
        contentPane.add(passwordLbl);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 100, 150, 20);
        contentPane.add(passwordField);

        roleLbl = new JLabel("Role");
        roleLbl.setFont(new Font("Tahoma", Font.BOLD, 15));
        roleLbl.setBounds(70, 150, 100, 20);
        contentPane.add(roleLbl);

        Role[] roles = new Role[] {Role.ADMINISTRATOR, Role.CLIENT, Role.EMPLOYEE};
        roleComboBox = new JComboBox<Role>(roles);
        roleComboBox.setBounds(150, 150, 150, 20);
        contentPane.add(roleComboBox);

        loginBtn = new JButton("Log in");
        loginBtn.setBounds(130, 220, 130, 30);
        contentPane.add(loginBtn);

        dontHaveAnAccount = new JLabel("Don't have an account?");
        dontHaveAnAccount.setFont(new Font("Tahoma", Font.ITALIC, 15));
        dontHaveAnAccount.setBounds(30, 300, 200, 20);
        contentPane.add(dontHaveAnAccount);

        registerNowBtn = new JButton("REGISTER NOW");
        registerNowBtn.setBounds(210, 300, 150, 20);
        contentPane.add(registerNowBtn);
    }
    public void registerNowAL(ActionListener action){
        this.registerNowBtn.addActionListener(action);
    }

    public void loginBtnAL(ActionListener action){
        this.loginBtn.addActionListener(action);
    }

    public String getUsernameTextF(){
        return this.usernameTextF.getText();
    }

    public char[] getPasswordTextF(){
        return this.passwordField.getPassword();
    }

    public Role getRoleComboBox(){
        return (Role) this.roleComboBox.getSelectedItem();
    }


}
