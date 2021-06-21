package cards;

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
    private PopupFactory popupFactory;
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
                    Popup p;
                    JLabel jLabel= new JLabel(f1.getMeaning());
                    p=popupFactory.getPopup(f,jLabel,180, 100);
                    p.show();


                }
            });
        }
        f.setLayout(new GridLayout(0,4));
        f.setSize(500,600);
        f.setVisible(true);


    }
}
