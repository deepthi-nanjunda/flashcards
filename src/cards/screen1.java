package cards;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import cards.screen2;

public class screen1
{
    private Connection conn;
    public screen1(Connection connection)
    {
        this.conn=connection;
    }

 public void run()
 {
         try
         {
             Statement statement = this.conn.createStatement();
             ResultSet resultSet = statement.executeQuery("select distinct type from cards;");

             ArrayList<String> arrayList=new ArrayList<String>();
             JFrame f = new JFrame();
                while(resultSet.next())
                {

                    arrayList.add(resultSet.getString("type"));

                }
             f.setSize(500,600);
                f.setVisible(true);
                screen2 s2=new screen2(this.conn);
             for(int i=0;i<arrayList.size();i++)
             {
                        JButton b = new JButton(arrayList.get(i));
                        b.setBounds(200,(70*i), 100, 40);
                        f.add(b);
                        b.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                f.dispose();
                                try {
                                    s2.run(e.getActionCommand());
                                } catch (SQLException throwable) {
                                    throwable.printStackTrace();
                                }
                            }
                        });
             }
         }
         catch(Exception e)
         {
             e.printStackTrace();
         }
 }

}
