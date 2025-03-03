package forms;

import repository.UserRepository;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class loginWindow extends JFrame {
    private final UserRepository userRepository;

    public loginWindow(UserRepository userRepository) {
        super("Login");
        this.userRepository = userRepository;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(null);


        JLabel labelUsername = new JLabel("Enter Username");
        labelUsername.setBounds(50, 30, 120, 30);
        add(labelUsername);

        JTextField textFieldUsername = new JTextField();
        textFieldUsername.setBounds(180, 30, 150, 30);
        add(textFieldUsername);

        JLabel labelPassword = new JLabel("Enter Password");
        labelPassword.setBounds(50, 80, 120, 30);
        add(labelPassword);

        JPasswordField textFieldPassword = new JPasswordField();
        textFieldPassword.setBounds(180, 80, 150, 30);
        add(textFieldPassword);


        JButton buttonLogin = new JButton("Log in");
        buttonLogin.setBounds(150, 130, 100, 30);
        add(buttonLogin);

        buttonLogin.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String username = textFieldUsername.getText();
                String password = new String(textFieldPassword.getPassword());

                if(username.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(loginWindow.this, "Username or Password is Empty");

                    return;
                }

                boolean success = userRepository.loginUser(username, password);
                if(success) {
                   // JOptionPane.showMessageDialog(loginWindow.this, "Login Successful");
                    setVisible(false);
                }
                else {
                    JOptionPane.showMessageDialog(loginWindow.this, "Login Failed");
                }


            }
        });















        setVisible(true);
    }


}
