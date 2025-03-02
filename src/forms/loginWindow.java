package forms;

import javax.swing.*;
import data.interfaces.IDB;

public class loginWindow extends JFrame {
    public loginWindow(IDB db) {
        this();
    }

    public loginWindow() {
        super("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }


}
