package com.iquestgroup.remotelearning.week8.w8p2.shuffler;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.*;

import com.iquestgroup.remotelearning.week8.w8p2.models.Card;
import com.iquestgroup.remotelearning.week8.w8p2.models.DeckOfCards;
import com.iquestgroup.remotelearning.week8.w8p2.models.Number;
import com.iquestgroup.remotelearning.week8.w8p2.models.Suite;
import org.junit.Before;
import org.junit.Test;

public class DeckOfCardsShufflerTest {

  public static final DeckOfCards UNSHUFFLED_DECK;

  static {
    UNSHUFFLED_DECK = new DeckOfCards();
    UNSHUFFLED_DECK.fill();
  }

  private DeckOfCardsShuffler deckOfCardsShuffler;

  @Before
  public void setup() {
    initData();
  }

  @Test
  public void testShuffle() {
    int objectsOnSamePositionCounter = 0;
    deckOfCardsShuffler.shuffle();
    Card[] shuffledDeckOfCards = deckOfCardsShuffler.getDeckOfCards().getCards();
    int expectedLength = UNSHUFFLED_DECK.getCards().length;
    int actualLength = shuffledDeckOfCards.length;
    assertEquals(expectedLength, actualLength);
    for (int index = 0; index < actualLength; index++) {
      Number notExpectedNumber = UNSHUFFLED_DECK.getCards()[index].getNumber();
      Suite notExpectedSuite = UNSHUFFLED_DECK.getCards()[index].getSuite();
      Number actualNumber = shuffledDeckOfCards[index].getNumber();
      Suite actualSuite = shuffledDeckOfCards[index].getSuite();
      if (actualNumber == notExpectedNumber && actualSuite == notExpectedSuite) {
        objectsOnSamePositionCounter++;
      }
    }
    assertThat(objectsOnSamePositionCounter, is(not(actualLength)));
  }

  private void initData() {
    DeckOfCards deckOfCards = new DeckOfCards();
    deckOfCards.fill();
    deckOfCardsShuffler = new DeckOfCardsShuffler(deckOfCards);
  }
}
