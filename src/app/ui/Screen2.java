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
import java.util.function.Supplier;

public class Screen2 extends JPanel implements ActionListener {
  private final Connection connection;
  public Popup popup;
  private PopupFactory popupFactory;


  public Screen2(Connection connection) {
    this.connection = connection;
    setVisible(true);
    setSize(500, 600);
    setLayout(new GridLayout(0, 1));
    add(new JLabel("Nothing to see here", SwingConstants.CENTER));
  }


    public void run(String actionPerformed) throws SQLException {
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
    while (resultSet.next()) {

      flashcard f1 = new flashcard();
      f1.setCardno(resultSet.getInt("cardno"));
      f1.setType(resultSet.getString("type"));
      f1.setWord(resultSet.getString("word"));
      f1.setMeaning(resultSet.getString("meaning"));
      flashcards.add(f1);

    }

    for (flashcard f1 : flashcards) {
      JButton word = new JButton(f1.getWord());
      word.setBackground(Color.WHITE);
      word.addActionListener(this);
      add(word);
    }
  }

  @Override
  public void actionPerformed(ActionEvent e) {

    try {
      Statement statement = this.connection.createStatement();
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("select meaning from cards where ");
      stringBuilder.append("word = ");
      stringBuilder.append("'");
      stringBuilder.append(e.getActionCommand());
      stringBuilder.append("';");
      ResultSet resultSet = statement.executeQuery(stringBuilder.toString());

      resultSet.next();
      popupFactory = new PopupFactory();
      final Supplier<Boolean> myfunc = this::deletePopUp;
      DisplayCard meaningCard = new DisplayCard(myfunc, resultSet.getString("meaning"));
      popup = this.popupFactory.getPopup(this, meaningCard, 550, 300);
      popup.show();



    } catch (SQLException exception) {
      exception.printStackTrace();
    }
  }

  public boolean deletePopUp() {
    this.popup.hide();
    return true;
  }
}



