package app.component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.Supplier;

public class DisplayCard extends JPanel implements ActionListener {


  private String meaning;
  private JButton jButton;
  private JTextArea jTextArea;
  private JPanel basePanel;
  private Popup popup;
  private Supplier<Boolean> myFunc;

  public DisplayCard(final Supplier<Boolean> myFunc,
                     final String meaning) {
    this.meaning = meaning;
    this.jTextArea = new JTextArea(this.meaning);
    this.jTextArea.setSize(200,200);
//    this.jTextArea.setBounds(100, 150, 200, 200);
    this.jTextArea.setLineWrap(true);
    this.jTextArea.setWrapStyleWord(true);
    this.jTextArea.setBackground(Color.PINK);
    this.jTextArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    this.myFunc = myFunc;
    jButton = new JButton("Close");
    jButton.addActionListener(this);
    jButton.setBounds(1000, 400, 50 , 50);
    jButton.setBackground(Color.WHITE);
    setLocation(400,400);
    setLayout(new GridLayout(0,1));
    setVisible(true);
    add(jTextArea);
    add(jButton);
  }

  @Override
  public void actionPerformed(ActionEvent e) {

    myFunc.get();
  }

}
