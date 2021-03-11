package com.iquestgroup.remotelearning.week5.w5p4.models;

import java.util.StringTokenizer;

public class PigLatinTranslatorImpl implements PigLatinTranslator {

  private static final int NO_PHRASES_TRANSLATED = 0;
  private static final int START_INDEX_FIRST_LETTER = 0;
  private static final int END_INDEX_FIRST_LETTER = 1;
  private static final int END_INDEX_SECOND_LETTER = 2;
  private static final String STRING_DELIMITER = " ";
  private static final String NEW_LINE = "\n";
  private static final String PREFIX_PIG_LATIN = "ay";
  private StringTokenizer stringTokenizer;
  private final Display display;
  private static int phrasesTranslated;

  public PigLatinTranslatorImpl() {
    display = new Display();
    phrasesTranslated = 0;
  }

  @Override
  public void translatePhrase(String englishPhrase) {
    tokenizePhrase(englishPhrase);
    while (stringTokenizer.hasMoreTokens()) {
      String latinWord;
      String englishWord = stringTokenizer.nextToken();
      if (Character.isUpperCase(englishWord.charAt(START_INDEX_FIRST_LETTER))) {
        String englishWordUpdated = updateWord(englishWord);
        latinWord = translateWord(englishWordUpdated);
      } else {
        latinWord = translateWord(englishWord);
      }
      printLatinWord(latinWord);
    }
    display.getTextArea().append(NEW_LINE);
    if (phrasesTranslated == NO_PHRASES_TRANSLATED) {
      configureAndDisplayFrame();
    }
    phrasesTranslated++;
  }

  @Override
  public String translateWord(String englishWord) {
    return englishWord.substring(END_INDEX_FIRST_LETTER) + englishWord
        .substring(START_INDEX_FIRST_LETTER, END_INDEX_FIRST_LETTER) + PREFIX_PIG_LATIN;
  }

  private void tokenizePhrase(String englishPhrase) {
    stringTokenizer = new StringTokenizer(englishPhrase);
  }

  private String updateWord(String firstWord) {
    return firstWord.substring(START_INDEX_FIRST_LETTER, END_INDEX_FIRST_LETTER).toLowerCase()
        + firstWord.substring(END_INDEX_FIRST_LETTER, END_INDEX_SECOND_LETTER).toUpperCase()
        + firstWord
        .substring(END_INDEX_SECOND_LETTER);
  }

  private void printLatinWord(String latinWord) {
    display.getTextArea().append(latinWord + STRING_DELIMITER);
  }

  private void configureAndDisplayFrame() {
    display.configurePanel();
    display.configureFrame();
    display.showFrame();
  }
}
