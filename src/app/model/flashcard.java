package app.model;

public class flashcard {
  private int cardno;
  private String type;
  private String word;
  private String meaning;

  public int getCardno() {
    return cardno;
  }

  public void setCardno(int cardno) {
    this.cardno = cardno;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getWord() {
    return word;
  }

  public void setWord(String word) {
    this.word = word;
  }

  public String getMeaning() {
    return meaning;
  }

  public void setMeaning(String meaning) {
    this.meaning = meaning;
  }
}
