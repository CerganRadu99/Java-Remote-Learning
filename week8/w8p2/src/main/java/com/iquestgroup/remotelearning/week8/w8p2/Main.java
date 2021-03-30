package com.iquestgroup.remotelearning.week8.w8p2;

import com.iquestgroup.remotelearning.week8.w8p2.models.Card;
import com.iquestgroup.remotelearning.week8.w8p2.models.DeckOfCards;
import com.iquestgroup.remotelearning.week8.w8p2.shuffler.DeckOfCardsShuffler;

public class Main {

  public static void main(String[] args) {
    DeckOfCards deckOfCards = new DeckOfCards();
    deckOfCards.fill();
    Card[] cards = deckOfCards.getCards();

    System.out.println("-----BEFORE SHUFFLING-----");
    for (Card card : cards) {
      System.out.println(card);
    }

    DeckOfCardsShuffler deckOfCardsShuffler = new DeckOfCardsShuffler(deckOfCards);
    deckOfCardsShuffler.shuffle();
    Card[] shuffledCards = deckOfCardsShuffler.getDeckOfCards().getCards();

    System.out.println("-----AFTER SHUFFLING-----");
    for (Card shuffledCard : shuffledCards) {
      System.out.println(shuffledCard);
    }
  }
}
