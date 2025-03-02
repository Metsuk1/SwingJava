package forms;

import javax.swing.*;
import data.interfaces.IDB;

public class registerWindow extends JFrame {

    public registerWindow(IDB db ) {
        this();
    }

    public registerWindow() {
        super("Register");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300 );
        setLocationRelativeTo(null);
        setVisible(true);
    }


}
