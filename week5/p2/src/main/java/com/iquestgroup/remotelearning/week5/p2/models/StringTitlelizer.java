package com.iquestgroup.remotelearning.week5.p2.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class StringTitlelizer implements Titlelizer {

  private static final String STRING_DELIMITER = " ";
  private static final int START_INDEX_FIRST_WORD = 0;
  private static final int END_INDEX_FIRST_WORD = 1;
  private static final String[] WORDS_TO_IGNORE = {"the", "a", "to", "in", "of", "this", "is"};
  private static final List<String> listWordsToIgnore = new ArrayList<>(
      Arrays.asList(WORDS_TO_IGNORE));

  @Override
  public String titlelize(String toTitlelize) {
    if (toTitlelize == null) {
      throw new IllegalArgumentException("Parameter 'toTitlelize' cannot be null");
    }
    if (toTitlelize.compareTo("") == 0) {
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
            .append(currentToken.substring(END_INDEX_FIRST_WORD)).append(" ");
      } else {
        stringBuilder.append(currentToken).append(" ");
      }

    }
    return stringBuilder.toString().trim();
  }

  private boolean isWordToIgnore(String toCheck) {
    return listWordsToIgnore.contains(toCheck);
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
