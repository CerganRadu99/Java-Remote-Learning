package com.iquestgroup.remotelearning.week8.w8p2.models;

public class Card {

  private Number number;
  private Suite suite;

  public Card(Number number, Suite suite) {
    this.number = number;
    this.suite = suite;
  }

  public Number getNumber() {
    return number;
  }

  public Suite getSuite() {
    return suite;
  }

  @Override
  public String toString() {
    return "Card{" +
        "number=" + number +
        ", suite=" + suite +
        '}';
  }
}
