package com.iquestgroup.remotelearning.week8.w8p2.filler;

import com.iquestgroup.remotelearning.week8.w8p2.models.Card;
import com.iquestgroup.remotelearning.week8.w8p2.models.CardGenerator;

public class DeckOfCardsFiller {

  public Card[] fillDeckOfCards(CardGenerator cardGenerator, int length) {
    Card[] cards = new Card[length];
    for (int index = 0; index < length; index++) {
      cards[index] = cardGenerator.next();
    }
    return cards;
  }
}
