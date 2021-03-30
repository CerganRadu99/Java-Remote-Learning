package com.iquestgroup.remotelearning.week8.w8p2.models;

import com.iquestgroup.remotelearning.week8.w8p2.filler.DeckOfCardsFiller;
import com.iquestgroup.remotelearning.week8.w8p2.generator.CardGenerator;

public class DeckOfCards {

  private static final int NUMBER_OF_CARDS = 52;
  private final Card[] cards;

  public DeckOfCards() {
    cards = new Card[NUMBER_OF_CARDS];
  }

  public Card[] getCards() {
    return cards;
  }

  public void fill() {
    DeckOfCardsFiller.fill(cards, new CardGenerator());
  }
}
