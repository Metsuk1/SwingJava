package forms;

import javax.swing.*;
import data.interfaces.IDB;
import repository.UserRepository;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import repository.UserRepository;

public class registerWindow extends JFrame {
    private final UserRepository userRepository;


    public registerWindow(UserRepository userRepository) {
        super("Register");
        this.userRepository = userRepository;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300 );
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


        JButton buttonRegister = new JButton("Register");
        buttonRegister.setBounds(150, 130, 100, 30);
        add(buttonRegister);

        buttonRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = textFieldUsername.getText();
                String password = new String(textFieldPassword.getPassword());

                if(username.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(registerWindow.this, "Username and password cannot be empty");
                }

                boolean is_register = userRepository.registerUser(username, password);
                if (is_register) {
                    JOptionPane.showMessageDialog(registerWindow.this, "You have been registered successfully");
                }
                else {
                    JOptionPane.showMessageDialog(registerWindow.this, "Something went wrong");
                }

            }
        });




        setVisible(true);
    }

}
