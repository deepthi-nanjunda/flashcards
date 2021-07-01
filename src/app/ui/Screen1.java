package app.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Screen1 extends JPanel implements ActionListener {
  private final Connection conn;
  private final Screen2 screen2;
  private JTabbedPane jTabbedPane;

  public Screen1(final Connection connection,
                 final Screen2 screen2,
                 final JTabbedPane jTabbedPane) {
    this.conn = connection;
    this.screen2 = screen2;
    this.jTabbedPane = jTabbedPane;
    setVisible(true);
    setSize(500, 600);
    setLayout(new GridLayout(1, 1));

    try {
      Statement statement = this.conn.createStatement();
      ResultSet resultSet = statement.executeQuery("select distinct type from cards;");

      ArrayList<String> arrayList = new ArrayList<String>();

      while (resultSet.next()) {
        arrayList.add(resultSet.getString("type"));
      }

      for (int i = 0; i < arrayList.size(); i++) {
        JButton b = new JButton(arrayList.get(i));
        b.setBounds(200, (70 * i), 100, 40);
        add(b);
        b.addActionListener(this);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    try {

      this.screen2.removeAll();
      this.screen2.run(e.getActionCommand());
      this.jTabbedPane.setSelectedComponent(this.screen2);
    } catch (SQLException exception) {
      exception.printStackTrace();
    }
  }
}
