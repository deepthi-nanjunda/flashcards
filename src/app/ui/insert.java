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


public class insert extends JPanel implements ActionListener {
  private final JLabel type;
  private final JLabel title;
  private final JTextArea typeName;
  private final JLabel word;
  private final JTextArea wordName;
  private final JLabel meaning;
  private final JTextArea explain;
  private final JButton submit;
  private final Connection connection;
  private PopupFactory popupFactory;
  public Popup popup;
  private Supplier<Boolean> myFunc;
  private final JButton reset;

  public insert(Connection connection) throws SQLException {

    this.connection = connection;
    setLayout(new FlowLayout());

    JPanel panel = new JPanel();
    panel.setSize(300,300);
    BorderLayout layout = new BorderLayout();
    layout.setHgap(20);
    layout.setVgap(20);
    panel.setLayout(layout);

    title = new JLabel();
    title.setText("Insertion");
    title.setSize(100, 30);
    add(title);
   // setLayout(new GridLayout(0, 2));

    type = new JLabel("Type");
    type.setSize(20,20);
   // type.setLocation(100,100);
   // type.setSize(20, 20);
    panel.add(type,BorderLayout.LINE_START);

    typeName = new JTextArea();
    typeName.setSize(50,20);
    //typeName.setLocation(150, 100);
    panel.add(typeName, BorderLayout.EAST);

    word = new JLabel("word");
    word.setSize(20,20);
    //word.setLocation(100, 170);
    panel.add(word,BorderLayout.WEST);

    wordName = new JTextArea();
    wordName.setSize(70,20);
//    wordName.setLocation(150, 770);
    panel.add(wordName,BorderLayout.EAST);

    meaning = new JLabel("meaning");
    meaning.setSize(70,20);
//    meaning.setLocation(100, 240);
    panel.add(meaning,BorderLayout.WEST);

    explain = new JTextArea();
    explain.setSize(70,20);
//    explain.setLocation(150, 240);
    panel.add(explain, BorderLayout.EAST);

    submit = new JButton("submit");
    submit.setSize(20,20);
//    submit.setLocation(300, 300);
    submit.addActionListener(this);
    add(submit,BorderLayout.SOUTH);

    reset = new JButton("Reset");
    reset.setSize(20,20);
    //reset.setLocation(300,300);
    reset.addActionListener(this);
    panel.add(reset, BorderLayout.SOUTH);

    add(panel);

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
