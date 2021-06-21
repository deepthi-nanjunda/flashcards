package com.company;

import cards.screen1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
	// write your code here

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/flash_card", "root",  "MyLibraSql@123");

        screen1 s1 = new screen1(connection);
        s1.run();
    }
}
