package app.ui;

import app.component.DisplayCard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.function.Supplier;


public class insertScreen extends JPanel implements ActionListener {
  private final JLabel type;
  private final JLabel title;
  private final JTextField typeName;
  private final JLabel word;
  private final JTextField wordName;
  private final JLabel meaning;
  private final JTextField explain;
  private final JButton submit;
  private final Connection connection;
  private PopupFactory popupFactory;
  public Popup popup;
  private Supplier<Boolean> myFunc;
  private final JButton reset;

  public insertScreen(Connection connection) throws SQLException {

    this.connection = connection;
    title = new JLabel("Insertion into the data base");
    title.setSize(100, 30);
    add(title);
    setLayout(new GridLayout(0, 2));


    type = new JLabel("Type");
    type.setSize(20, 20);
    add(type);

    typeName = new JTextField();
    typeName.setSize(50, 20);
    add(typeName);

    word = new JLabel("word");
    word.setSize(20, 20);
    add(word);

    wordName = new JTextField();
    wordName.setSize(70, 20);
    add(wordName);

    meaning = new JLabel("meaning");
    meaning.setSize(70, 20);
    add(meaning);

    explain = new JTextField();
    explain.setSize(70, 20);
    add(explain);

    submit = new JButton("submit");
    submit.setSize(20, 20);
    submit.addActionListener(this);
    add(submit);

    reset = new JButton("Reset");
    reset.setSize(20,20);
    reset.addActionListener(this);
    add(reset);

  }

  @Override
  public void actionPerformed(ActionEvent e) {
    try {
      Statement statement = this.connection.createStatement();
      if (e.getSource() == submit) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("insert into ");
        stringBuilder.append("cards values (");
        stringBuilder.append("null,");
        stringBuilder.append("'");
        stringBuilder.append(typeName.getText());
        stringBuilder.append("'");
        stringBuilder.append(", '");
        stringBuilder.append(wordName.getText());
        stringBuilder.append("'");
        stringBuilder.append(",");
        stringBuilder.append("'");
        stringBuilder.append(explain.getText());
        stringBuilder.append("'");
        stringBuilder.append(" );");

        int i = statement.executeUpdate(stringBuilder.toString());
        if (i == 1) {
          JPanel success = new JPanel();
          JLabel successLabel = new JLabel("Successfully Inserted");
          success.add(successLabel);
          JButton acknowledge = new JButton("OK");
          success.add(acknowledge);
          popupFactory = new PopupFactory();
          popup = this.popupFactory.getPopup(this, success, 400, 400);
          acknowledge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              popup.hide();
            }
          });
          popup.show();
        }
      }
      else if(e.getSource()==reset)
      {
        String def = " ";
        typeName.setText(def);
        wordName.setText(def);
        explain.setText(def);
      }
    } catch (SQLException exception) {
      exception.printStackTrace();
    }

  }
}
