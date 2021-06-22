package app;

import app.ui.Screen1;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

  public static void main(String[] args) throws SQLException {
    // write your code here

    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/flash_card", "root", "MyLibraSql@123");
    JFrame jframe = new JFrame();
    Screen1 s1 = new Screen1(connection, jframe );
    s1.run();
  }
}
