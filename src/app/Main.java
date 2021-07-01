package app;

import app.ui.Screen1;
import app.ui.Screen2;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

  public static void main(String[] args) throws SQLException {
    // write your code here

    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/flash_card", "root", "MyLibraSql@123");
    JFrame jframe = new JFrame();
    jframe.setVisible(true);
    jframe.setSize(500,600);
    JTabbedPane jTabbedPane = new JTabbedPane(JTabbedPane.TOP);
    Screen2 screen2 = new Screen2(connection);
    jTabbedPane.add("type", new Screen1(connection,screen2, jTabbedPane));
    jTabbedPane.add("words",screen2);

    jframe.add(jTabbedPane);
  }
}
