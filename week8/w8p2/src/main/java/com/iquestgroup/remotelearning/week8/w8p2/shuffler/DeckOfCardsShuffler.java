package com.iquestgroup.remotelearning.week8.w8p2.shuffler;

import com.iquestgroup.remotelearning.week8.w8p2.models.Card;
import com.iquestgroup.remotelearning.week8.w8p2.models.DeckOfCards;
import java.util.Random;

public class DeckOfCardsShuffler {

  private static final Random RANDOM = new Random();
  private final DeckOfCards deckOfCards;

  public DeckOfCardsShuffler(DeckOfCards deckOfCards) {
    this.deckOfCards = deckOfCards;
  }

  public DeckOfCards getDeckOfCards() {
    return deckOfCards;
  }

  public void shuffle() {
    for (int indexFirstElementSwitched = deckOfCards.getCards().length - 1; indexFirstElementSwitched > 0; indexFirstElementSwitched--) {
      int indexSecondElementSwitched = RANDOM.nextInt(indexFirstElementSwitched + 1);
      Card temporaryCard = deckOfCards.getCards()[indexFirstElementSwitched];
      deckOfCards.getCards()[indexFirstElementSwitched] = deckOfCards.getCards()[indexSecondElementSwitched];
      deckOfCards.getCards()[indexSecondElementSwitched] = temporaryCard;
    }
  }
}
