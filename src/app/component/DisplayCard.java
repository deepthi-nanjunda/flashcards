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
    this.basePanel = basePanel;
    this.jTextArea = new JTextArea(this.meaning);
    this.myFunc = myFunc;
    jButton = new JButton("Click me");
    jButton.addActionListener(this);

    setVisible(true);
    setBounds(150, 180, 300, 400);
    setBackground(Color.ORANGE);
    setLayout(new GridLayout());
    add(jTextArea);
    add(jButton);
  }

  @Override
  public void actionPerformed(ActionEvent e) {

    myFunc.get();
  }

}
