import javax.swing.*;

import data.Database;
import gui.gui;
import data.interfaces.IDB;

public class App {
    public static void main(String[] args) {
        IDB db = Database.getInstance("jdbc:postgresql://localhost:5432", "postgres", "0000","swingJava");

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
               try{
                   new gui(db).setVisible(true);
               }catch (Exception e){
                   e.printStackTrace();
               }
            }
        });

    }
}