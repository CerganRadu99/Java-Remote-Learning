package com.iquestgroup.remotelearning.week5.w5p3.models;

import java.util.Random;


public class SentencesGenerator {

  protected Display display;
  protected StringBuilder stringBuilder;
  protected static final int LENGTH_WHEN_STRING_BUILDER_EMPTY = 0;
  private static final int NUMBER_OF_SENTENCES = 20;
  private final Random random;
  private static final int START_INDEX_FIRST_LETTER = 0;
  private static final int END_INDEX_FIRST_LETTER = 1;
  private static final String STRING_DELIMITER = " ";
  private static final String END_PERIOD = ".";
  private static final String[] articles = {"the", "a", "one", "some", "any"};
  private static final String[] nouns = {"boy", "girl", "dog", "town", "car"};
  private static final String[] verbs = {"drove", "jumped", "ran", "walked", "skipped"};
  private static final String[] prepositions = {"to", "from", "over", "under", "on"};

  public SentencesGenerator() {
    random = new Random();
    stringBuilder = new StringBuilder();
    display = new Display();
  }

  public void outputSentences() {
    display.configurePanel();
    display.configureFrame();
    display.showFrame();
  }

  public void generateSentences() {
    for (int i = 0; i < NUMBER_OF_SENTENCES; i++) {
      stringBuilder = createSentence();
      String sentence = makeSentencePrintable(stringBuilder);
      display.getTextArea().append(sentence + "\n");
      stringBuilder.setLength(LENGTH_WHEN_STRING_BUILDER_EMPTY);
    }
  }

  protected StringBuilder createSentence() {
    stringBuilder.append(pickRandomArticle());
    stringBuilder.append(STRING_DELIMITER);
    stringBuilder.append(pickRandomNoun());
    stringBuilder.append(STRING_DELIMITER);
    stringBuilder.append(pickRandomVerb());
    stringBuilder.append(STRING_DELIMITER);
    stringBuilder.append(pickRandomPreposition());
    stringBuilder.append(STRING_DELIMITER);
    stringBuilder.append(pickRandomArticle());
    stringBuilder.append(STRING_DELIMITER);
    stringBuilder.append(pickRandomNoun());
    return stringBuilder;
  }

  protected String makeSentencePrintable(StringBuilder stringBuilder) {
    stringBuilder.append(END_PERIOD);
    String printableSentence = stringBuilder.toString();
    return
        printableSentence.substring(START_INDEX_FIRST_LETTER, END_INDEX_FIRST_LETTER).toUpperCase()
            + printableSentence.substring(END_INDEX_FIRST_LETTER);
  }

  private String pickRandomArticle() {
    return articles[random.nextInt(articles.length)];
  }

  private String pickRandomNoun() {
    return nouns[random.nextInt(nouns.length)];
  }

  private String pickRandomVerb() {
    return verbs[random.nextInt(verbs.length)];
  }

  private String pickRandomPreposition() {
    return prepositions[random.nextInt(prepositions.length)];
  }

}
