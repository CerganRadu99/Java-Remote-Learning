package com.iquestgroup.remotelearning.week8.w8p2.shuffler;

import com.iquestgroup.remotelearning.week8.w8p2.models.Card;
import com.iquestgroup.remotelearning.week8.w8p2.models.DeckOfCards;
import java.util.Random;

public class DeckOfCardsShuffler {

  private final Random random;
  private final DeckOfCards deckOfCards;

  public DeckOfCardsShuffler(DeckOfCards deckOfCards, int randomSeed) {
    this.deckOfCards = deckOfCards;
    random = new Random(randomSeed);
  }

  public DeckOfCards getDeckOfCards() {
    return deckOfCards;
  }

  public void shuffle() {
    for (int indexFirstElementSwitched = deckOfCards.getCards().length - 1; indexFirstElementSwitched > 0; indexFirstElementSwitched--) {
      int indexSecondElementSwitched = random.nextInt(indexFirstElementSwitched + 1);
      Card temporaryCard = deckOfCards.getCards()[indexFirstElementSwitched];
      deckOfCards.getCards()[indexFirstElementSwitched] = deckOfCards.getCards()[indexSecondElementSwitched];
      deckOfCards.getCards()[indexSecondElementSwitched] = temporaryCard;
    }
  }
}
