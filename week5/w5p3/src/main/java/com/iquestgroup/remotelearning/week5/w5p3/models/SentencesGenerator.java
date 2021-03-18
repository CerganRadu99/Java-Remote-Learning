package com.iquestgroup.remotelearning.week5.w5p3.models;

import java.util.Random;


public class SentencesGenerator {

  private final Display display;
  private StringBuilder stringBuilder;
  private static final int LENGTH_WHEN_STRING_BUILDER_EMPTY = 0;
  private static final int NUMBER_OF_SENTENCES = 20;
  private final Random random;
  private static final int START_INDEX_FIRST_LETTER = 0;
  private static final int END_INDEX_FIRST_LETTER = 1;
  private static final String STRING_DELIMITER = " ";
  private static final String END_PERIOD = ".";
  private static final String[] ARTICLES = {"the", "a", "one", "some", "any"};
  private static final String[] NOUNS = {"boy", "girl", "dog", "town", "car"};
  private static final String[] VERBS = {"drove", "jumped", "ran", "walked", "skipped"};
  private static final String[] PREPOSITIONS = {"to", "from", "over", "under", "on"};

  public SentencesGenerator() {
    random = new Random();
    stringBuilder = new StringBuilder();
    display = new Display();
  }

  public Display getDisplay() {
    return display;
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

  public StringBuilder createSentence() {
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

  public String makeSentencePrintable(StringBuilder stringBuilder) {
    stringBuilder.append(END_PERIOD);
    String printableSentence = stringBuilder.toString();
    return
        printableSentence.substring(START_INDEX_FIRST_LETTER, END_INDEX_FIRST_LETTER).toUpperCase()
            + printableSentence.substring(END_INDEX_FIRST_LETTER);
  }

  private String pickRandomArticle() {
    return ARTICLES[random.nextInt(ARTICLES.length)];
  }

  private String pickRandomNoun() {
    return NOUNS[random.nextInt(NOUNS.length)];
  }

  private String pickRandomVerb() {
    return VERBS[random.nextInt(VERBS.length)];
  }

  private String pickRandomPreposition() {
    return PREPOSITIONS[random.nextInt(PREPOSITIONS.length)];
  }
}
