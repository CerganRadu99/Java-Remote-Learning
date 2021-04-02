package com.iquestgroup.remotelearning.week8.w8p2.models;

import java.util.Objects;

public class Card {

  private final Number number;
  private final Suite suite;

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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Card card = (Card) o;
    return number == card.number && suite == card.suite;
  }

  @Override
  public int hashCode() {
    return Objects.hash(number, suite);
  }
}
