package app.ui;

import app.model.flashcard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;

public class screen2
{
    private Connection connection;
    private String actionPerformed;

    private JFrame f = new JFrame("Cards");
    screen2(Connection connection)
    {
        this.connection=connection;


    }


    void run(String actionPerformed) throws SQLException
    {
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Statement statement = this.connection.createStatement();

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select * from cards where ");
        stringBuilder.append("type = ");
        stringBuilder.append("'");
        stringBuilder.append(actionPerformed);
        stringBuilder.append("' ;");
        ResultSet resultSet = statement.executeQuery(stringBuilder.toString());

        ArrayList<String> arrayList=new ArrayList<String>();
        ArrayList<flashcard> flashcards = new ArrayList<>();
        JFrame f = new JFrame();
        while(resultSet.next())
        {

            flashcard f1 = new flashcard();
            f1.setCardno(resultSet.getInt("cardno"));
            f1.setType(resultSet.getString("type"));
            f1.setWord(resultSet.getString("word"));
            f1.setMeaning(resultSet.getString("meaning"));
            flashcards.add(f1);

        }

        for(flashcard f1:flashcards)
        {
            JButton b = new JButton(f1.getWord());
            f.add(b);
            b.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    PopupFactory popupFactory = new PopupFactory();
                    JPanel jPanel=new JPanel();
                    Popup popup;
                    JLabel jLabel= new JLabel(f1.getMeaning());
                    jPanel.add(jLabel);
                    jPanel.setLayout(new GridLayout(1,1));
                    popup=popupFactory.getPopup(f,jPanel,180, 100);
                    popup.show();
                }
            });
        }

        f.setLayout(new GridLayout(0,4));
        f.setSize(500,600);
        f.setVisible(true);


    }
}
