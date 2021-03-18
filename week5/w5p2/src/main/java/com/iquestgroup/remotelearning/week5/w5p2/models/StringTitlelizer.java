package com.iquestgroup.remotelearning.week5.w5p2.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class StringTitlelizer implements Titlelizer {

  private static final String STRING_DELIMITER = " ";
  private static final String EMPTY_STRING = "";
  private static final int START_INDEX_FIRST_WORD = 0;
  private static final int EQUAL_STRINGS = 0;
  private static final int END_INDEX_FIRST_WORD = 1;
  private static final String[] WORDS_TO_IGNORE = {"the", "a", "to", "in", "of", "this", "is"};
  private static final List<String> LIST_WORDS_TO_IGNORE = new ArrayList<>(
      Arrays.asList(WORDS_TO_IGNORE));

  @Override
  public String titlelize(String toTitlelize) {
    if (toTitlelize == null) {
      throw new IllegalArgumentException("Parameter 'toTitlelize' cannot be null");
    }
    if (toTitlelize.compareTo(EMPTY_STRING) == EQUAL_STRINGS) {
      return toTitlelize;
    }
    if (isTitlelized(toTitlelize)) {
      return toTitlelize;
    }
    StringBuilder stringBuilder = new StringBuilder();
    String[] tokenizedString = tokenize(toTitlelize);
    for (String currentToken : tokenizedString) {
      if (!isWordToIgnore(currentToken) || (isWordToIgnore(currentToken) && isFirstWord(
          currentToken, toTitlelize))) {
        stringBuilder.append(
            currentToken.substring(START_INDEX_FIRST_WORD, END_INDEX_FIRST_WORD).toUpperCase())
            .append(currentToken.substring(END_INDEX_FIRST_WORD)).append(STRING_DELIMITER);
      } else {
        stringBuilder.append(currentToken).append(STRING_DELIMITER);
      }

    }
    return stringBuilder.toString().trim();
  }

  private boolean isWordToIgnore(String toCheck) {
    return LIST_WORDS_TO_IGNORE.contains(toCheck);
  }

  private boolean isFirstWord(String toCheck, String whereToCheck) {
    return whereToCheck.indexOf(toCheck) == START_INDEX_FIRST_WORD;
  }

  private String[] tokenize(String toTokenize) {
    return toTokenize.split(STRING_DELIMITER);
  }

  private boolean isTitlelized(String toCheck) {
    String[] tokenizedString = tokenize(toCheck);
    for (String currentToken : tokenizedString) {
      if (!isWordToIgnore(currentToken) && Character.isLowerCase(currentToken.charAt(0))) {
        return false;
      } else if (isFirstWord(currentToken, toCheck) && Character
          .isLowerCase(currentToken.charAt(START_INDEX_FIRST_WORD))) {
        return false;
      }
    }
    return true;
  }
}
