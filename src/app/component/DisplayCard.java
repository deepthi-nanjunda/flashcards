package app.component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DisplayCard extends JPanel implements ActionListener {


  private String word, meaning;
  private boolean displayWord;
  private JLabel jLabel;
  private JButton jButton;

  public DisplayCard(String word,
                     String meaning,
                     boolean displayWord) {
    this.word = word;
    this.meaning = meaning;
    this.displayWord = displayWord;

    if (displayWord) {
      this.jLabel = new JLabel(word);
    } else {
      this.jLabel = new JLabel(meaning);
    }
    jButton = new JButton("Click me");
    jButton.addActionListener(this);

    setBounds(150, 180, 300, 400);
    setBackground(Color.ORANGE);
    setLayout(new GridLayout());
    add(jLabel);
    add(jButton);
  }


  @Override
  public void actionPerformed(ActionEvent e) {
  if(!displayWord)
  {
    jLabel.setVisible(false);
  }

  }
}
