package app.ui;

import app.component.DisplayCard;
import app.model.flashcard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Screen2 implements ActionListener
{
  private final Connection connection;
  private String actionPerformed;
  private JPanel basePanel;
  private JFrame details;
  private flashcard currCard;

  Screen2(Connection connection) {
    this.connection = connection;
    this.details = new JFrame("Details");
    this.basePanel = new JPanel();
    this.details.add(this.basePanel);
    this.basePanel.setLayout(new GridLayout(0,4));
    this.basePanel.setSize(400, 500);


  }


  void run(String actionPerformed) throws SQLException
  {
    Statement statement = this.connection.createStatement();

    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("select * from cards where ");
    stringBuilder.append("type = ");
    stringBuilder.append("'");
    stringBuilder.append(actionPerformed);
    stringBuilder.append("' ;");
    ResultSet resultSet = statement.executeQuery(stringBuilder.toString());

    ArrayList<String> arrayList = new ArrayList<String>();
    ArrayList<flashcard> flashcards = new ArrayList<>();
    while (resultSet.next())
    {

      flashcard f1 = new flashcard();
      f1.setCardno(resultSet.getInt("cardno"));
      f1.setType(resultSet.getString("type"));
      f1.setWord(resultSet.getString("word"));
      f1.setMeaning(resultSet.getString("meaning"));
      flashcards.add(f1);

    }

    for (flashcard f1 : flashcards)
    {
      DisplayCard wordCard = new DisplayCard(f1.getWord(),f1.getMeaning(),true);
      this.basePanel.add(wordCard);

    }
    this.details.setSize(400, 500);
    this.details.setVisible(true);
    this.basePanel.setVisible(true);


  }

  @Override
  public void actionPerformed(ActionEvent e)
  {
      PopupFactory popupFactory = new PopupFactory();
      Popup popup;
      DisplayCard displayCard = new DisplayCard();
      popup = popupFactory.getPopup(this.basePanel,displayCard,180,200);
      popup.show();









//      JPanel jPanel1 = new JPanel();
//
//      this.basePanel.add(jPanel1);
//      JLabel jLabel = new JLabel(f1.getMeaning());
//      jLabel.setBounds(180, 100, 50, 200);
//      jLabel.setBackground(Color.ORANGE);
//      jPanel1.add(jLabel);
//      JButton jButton1 = new JButton("Click this to close");
//      jButton1.addActionListener(new ActionListener()
//      {
//        @Override
//        public void actionPerformed(ActionEvent e)
//        {
//          jPanel1.setVisible(false);
//          jLabel.setVisible(false);
//        }
//      });
//      jPanel1.add(jButton1);
//      jPanel1.setLayout(new GridLayout(0, 4));
//      popup = popupFactory.getPopup(this, new DisplayCard(), 180, 100);
//      popup.show();
    }
  }

