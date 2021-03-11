package com.iquestgroup.remotelearning.week5.p1.models;

import java.util.ArrayList;
import java.util.Arrays;
import org.apache.commons.lang3.math.NumberUtils;

public class StringList implements List<String> {

  private static final int LIST_CAPACITY = 4;
  private static final int STRINGS_ARE_EQUAL = 0;
  private final java.util.List<String> operations = new ArrayList<>();
  private final String[] numbersAsStrings = new String[LIST_CAPACITY];
  private int indexNumber;

  public StringList() {
    indexNumber = 0;
  }

  public java.util.List<String> getOperations() {
    return operations;
  }

  @Override
  public void add(String element) throws CustomException {
    operations.add("add()");
    if (isNullOrEmpty(element)) {
      throw new CustomException("Null");
    } else if (!NumberUtils.isCreatable(element)) {
      throw new CustomException("Invalid number.");
    } else {
      numbersAsStrings[indexNumber++] = element;
    }
  }

  @Override
  public String get(int position) throws CustomException {
    operations.add("get()");
    if (isIndexOutOfBounds(position)) {
      throw new CustomException("Index out of bounds.");
    } else {
      return numbersAsStrings[position];
    }
  }

  @Override
  public boolean contains(String element) {
    operations.add("contains()");
    for (String currentString : numbersAsStrings) {
      if (currentString.compareTo(element) == STRINGS_ARE_EQUAL) {
        return true;
      }
    }
    return false;
  }

  @Override
  public boolean containsAll(List<String> foreignList) {
    operations.add("containsAll()");
    java.util.List arrayAsList = Arrays.asList(numbersAsStrings);
    for (int index = 0; index < foreignList.size(); index++) {
      if (!arrayAsList.contains(foreignList.get(index))) {
        return false;
      }
    }
    return true;
  }

  @Override
  public int size() {
    operations.add("size()");
    return numbersAsStrings.length;
  }

  private boolean isNullOrEmpty(String currentString) {
    if (currentString != null && !currentString.isEmpty()) {
      return false;
    }
    return true;
  }

  private boolean isIndexOutOfBounds(int index) {
    return index >= numbersAsStrings.length;
  }
}
