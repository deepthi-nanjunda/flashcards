package app.ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Screen1 {
  private final Connection conn;
  private final JFrame mainFrame;
  private final JPanel basePanel;

  public Screen1(final Connection connection,
                 final JFrame mainFrame) {
    this.mainFrame = mainFrame;
    this.basePanel = new JPanel();
    this.mainFrame.add(this.basePanel);
    this.conn = connection;
    this.basePanel.setSize(500, 600);
    this.mainFrame.setSize(500, 600);
    this.mainFrame.setVisible(true);

  }
  public void run() {
    try {
      Statement statement = this.conn.createStatement();
      ResultSet resultSet = statement.executeQuery("select distinct type from cards;");

      ArrayList<String> arrayList = new ArrayList<String>();

      while (resultSet.next()) {
        arrayList.add(resultSet.getString("type"));
      }

      final Screen2 screen2 = new Screen2(this.conn);

      for (int i = 0; i < arrayList.size(); i++)
      {
        JButton b = new JButton(arrayList.get(i));
        b.setBounds(200, (70 * i), 100, 40);
        this.basePanel.add(b);
        b.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e)
          {
            try {
              screen2.run(e.getActionCommand());
            } catch (SQLException exception) {
              // throw exception
              exception.printStackTrace();
            }
          }
        });
      }
      this.basePanel.setVisible(true);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
