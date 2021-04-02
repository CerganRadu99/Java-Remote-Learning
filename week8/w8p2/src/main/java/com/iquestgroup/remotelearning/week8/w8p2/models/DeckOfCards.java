package com.iquestgroup.remotelearning.week8.w8p2.models;

import com.iquestgroup.remotelearning.week8.w8p2.filler.DeckOfCardsFiller;
import com.iquestgroup.remotelearning.week8.w8p2.generator.CardGeneratorImpl;

public class DeckOfCards {

  private static final int NUMBER_OF_CARDS = 52;
  private Card[] cards;

  public DeckOfCards() {
    cards = new Card[NUMBER_OF_CARDS];
  }

  public Card[] getCards() {
    return cards;
  }

  public void fill() {
    CardGenerator cardGenerator = new CardGeneratorImpl();
    DeckOfCardsFiller deckOfCardsFiller = new DeckOfCardsFiller();
    cards = deckOfCardsFiller.fillDeckOfCards(cardGenerator, NUMBER_OF_CARDS);
  }
}
