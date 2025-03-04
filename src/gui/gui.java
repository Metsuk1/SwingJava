package gui;

import services.loginWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import services.registerWindow;
import data.interfaces.IDB;
import repository.UserRepository;

public class gui extends JFrame {
    private IDB db;

    public gui(IDB db) {
        super("Application");
        this.db = db;


        setSize(500,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addComponents();

    }

    private void addComponents() {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        JButton login = new JButton("Login");
        login.setBounds(200, 100, 100, 30);
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new loginWindow(new UserRepository(db));
                setVisible(false);
            }
        });


        JButton register = new JButton("Register");
        register.setBounds(200, 150, 100, 30);

        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new registerWindow(new UserRepository(db));
                setVisible(false);            }
        });


        JButton exit = new JButton("Exit");
        exit.setBounds(200, 200, 100, 30);
        exit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


        panel.add(login);
        panel.add(register);
        panel.add(exit);

        add(panel);

    }




}
